package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.GameData;
import bean.MapData;
import bean.QuizGameBean;
import dao.MapDataDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/initGame")
public class InitGameServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		GameData gameData = new GameData();
		QuizGameBean QGB = new QuizGameBean();
		HttpSession session = request.getSession();
		String cmd = request.getParameter("cmd");

		try {
			if (cmd.equals("init")) {
				String strGameType = request.getParameter("gameType");
				ArrayList<MapData> mapDataList = new ArrayList<MapData>();
				MapDataDAO mapDao = new MapDataDAO();
				//④ gameDataの初期化を行う。
				gameData = new GameData();

				int gameType = Integer.parseInt(strGameType);
				gameData.setGameType(gameType);
				gameData.setProblemCnt(1);
				gameData.setGameName(QGB.showQuizName(gameType));
				//⑥・ 「日本地図あてクイズ」の場合、selectAllメソッドを呼び出す。
				//・ 「地域別クイズ」の場合、selectByGameTypeメソッドを呼び出す。
				if (gameType == 1 || gameType == 2 || gameType == 3) {
					mapDataList = mapDao.selectAll();
				} else {
					mapDataList = mapDao.selectByGameType(gameType);
				}
				//⑦selectAnswerメソッド、createProblemメソッドを呼び出す。開始時間設定。
				QGB.selectAnswer(gameData, mapDataList);
				QGB.createProblem(gameData, mapDataList);
				gameData.setGameStartTime(System.currentTimeMillis());

				session.setAttribute("gameData", gameData);//セッション登録

			} else if (cmd.equals("game")) {

				GameData gameData_continue = (GameData) session.getAttribute("gameData");

				if (QGB.checkSession(gameData_continue) == false) {//セッション切れエラー
					error = "sess_error";
				}
				gameData_continue.setProblemCnt(gameData_continue.getProblemCnt() + 1);
			}
		} catch (IllegalStateException e) {//DB接続エラー
			error = "db_error";
		} finally {
			if (error.equals("")) {
				request.getRequestDispatcher("/view/game.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}

	}
}
