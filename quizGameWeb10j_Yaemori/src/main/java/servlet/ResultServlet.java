package servlet;

import java.io.IOException;

import bean.GameData;
import bean.QuizGameBean;
import dao.RecordDataDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		String state = null;
		QuizGameBean QGB = new QuizGameBean();

		try {
			HttpSession session = request.getSession();
			GameData gameData = (GameData) session.getAttribute("gameData");

			if (QGB.checkSession(gameData) == false) {//セッション切れエラー
				error = "sess_error";
			}

			String answer_value = request.getParameter("answer");
			int answer = Integer.parseInt(answer_value);

			//選んだ回答をgameDataに格納
			String choice = gameData.getChoices(gameData.getProblemCnt() - 1).get(answer);
			gameData.setSelectAnswer(choice);

			//答えをstrAnswerに格納
			String strAnswer = gameData.getAnswer(gameData.getProblemCnt() - 1);
			String result;
			if (choice.equals(strAnswer)) {
				result = "正解";
				gameData.setCorrectAnswersCnt(gameData.getCorrectAnswersCnt() + 1);//正解数を１増やす。
			} else {
				result = "はずれ";
			}

			gameData.setResult(result);

			//⑤gameDataから現在の問題数と総問題数を取得し比較する。
			int problemCnt = gameData.getProblemCnt();
			int totalProblemCnt = gameData.getTotalProblemCnt();

			if (problemCnt < totalProblemCnt) {
				state = "nextGame";
			} else if (problemCnt == totalProblemCnt) {
				state = "gameResult";
				//②ゲームの終了時間を設定する。
				gameData.setGameEndTime(System.currentTimeMillis());
				//③recordDataDaoオブジェクトを生成する。
				RecordDataDAO recordDao = new RecordDataDAO();
				//④recordDataDaoよりselectOrderOfResultメソッドを呼び出し順位を取得する。
				//⑤取得した順位をgameDataに格納する。 ↓あとで2文に分ける必要があるかも
				gameData.setOrder(
						recordDao.selectOrderOfResult(gameData.getCorrectAnswersCnt(), gameData.getGameType()));
			}

		} catch (IllegalStateException e) {
			error = "db_error";

		} finally {
			if (error.equals("")) {
				request.setAttribute("state", state);
				request.getRequestDispatcher("/view/result.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}