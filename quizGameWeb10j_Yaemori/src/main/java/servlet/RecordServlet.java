package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.GameData;
import bean.QuizGameBean;
import bean.RecordData;
import dao.RecordDataDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/record")
public class RecordServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error="";
		QuizGameBean QGB =new QuizGameBean();
		RecordData recordData=new RecordData();
		String cmd=request.getParameter("cmd");
		int gameType=0;
		ArrayList<RecordData> rankingList=null;
		
		try {

		if(cmd.equals("insert")) {
			HttpSession session=request.getSession();
			GameData gameData=(GameData)session.getAttribute("gameData");
			//②セッションの状態を確認する。
			if(QGB.checkSession(gameData)==false) {//セッション切れエラー
				error="sess_error";
			}
			gameType=gameData.getGameType();
			
			//名前をパラメータから取得、なければ「ななしさん」
			String userName=request.getParameter("name");
			if(userName.equals("")) {
				userName="ななしさん";
			}
			//recordDataにそれぞれの情報を格納
			recordData.setName(userName);
			recordData.setScore(gameData.getCorrectAnswersCnt());
			recordData.setGameType(gameType);
			
			long completeTime=gameData.getGameEndTime()-gameData.getGameStartTime();
			recordData.setCompleteTime(completeTime);
			
		}else if(cmd.equals("show")) {
			String strGameType= request.getParameter("gameType");
			gameType =Integer.parseInt(strGameType);
			
			//gameDataを初期化し、セッションに登録←セッションにあるGameDataを消去するため
			HttpSession session=request.getSession();
			GameData gameData =new GameData();
			session.setAttribute("gameData",gameData);
		}
		
		RecordDataDAO recordDao =new RecordDataDAO();
		
		//コマンドがinsertなら登録メソッドを呼び出し
		if(cmd.equals("insert")) {
			recordDao.insertRecord(recordData);
		}
		//rankingListにselectDataAccordingToGameTypeメソッドの返り値を格納
		rankingList=recordDao.selectDataAccordingToGameType(gameType);
		
		}catch (IllegalStateException e) {//DB接続エラー
			error="db_error";
		}finally {
			if(error.equals("")) {
				request.setAttribute("rankingList",rankingList);
				request.setAttribute("gameType",gameType);
				request.setAttribute("cmd",cmd );
				request.getRequestDispatcher("/view/showRanking.jsp").forward(request,response);
			}else {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request,response);
			}
		}
			
		
	}
}