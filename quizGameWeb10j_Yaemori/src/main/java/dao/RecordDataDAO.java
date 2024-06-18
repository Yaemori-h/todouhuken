package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.RecordData;

public class RecordDataDAO {
	//データベース接続情報
	private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	private static String URL = "jdbc:mariadb://localhost/quizdb";
	private static String USER = "root";
	private static String PASS = "root123";

	private static Connection getConnection() {//DB接続メソッド
		try {

			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			return con;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	//③ゲームの種類をもとに、データベースから上位20位までの記録を取得するメソッド
	public ArrayList<RecordData> selectDataAccordingToGameType(int gameType) {
		
		Connection con = null;
		Statement smt = null;
		ArrayList<RecordData> recordList = new ArrayList<RecordData>();

		String sql = "SELECT * FROM recordinfo WHERE game_type=" + gameType
				+ " ORDER BY score DESC, complete_time ASC LIMIT 20";

		try {
			con = RecordDataDAO.getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				RecordData rData = new RecordData();
				rData.setName(rs.getString("name"));
				rData.setScore(rs.getInt("score"));
				rData.setCompleteTime(rs.getLong("complete_time"));
				recordList.add(rData);
			}
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return recordList;
	}

	//④引数の「得点」と「ゲームの種類」を元に順位を取得する
	public int selectOrderOfResult(int score, int gameType) {
		
		Connection con = null;
		Statement smt = null;
		int order = 0;
		
		String sql = "SELECT (od.DataCnt +1) AS OrderOfResult FROM " +
				"(SELECT count(*) AS DataCnt FROM recordinfo WHERE score > " + score + " AND game_type = " + gameType
				+ " ) od";

		try {
			con = RecordDataDAO.getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				order = rs.getInt("OrderOfResult");
			}
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return order;
	}

	//⑤データベースへ登録を行う
	public void insertRecord(RecordData recordData) {

		Connection con = null;
		Statement smt = null;

		String sql = "INSERT INTO recordinfo VALUES ('" + recordData.getName() + "'," + recordData.getScore() + ","
				+ recordData.getGameType() + ",(SELECT CURDATE()),(SELECT CURTIME())," + recordData.getCompleteTime()
				+ ")";

		try {
			con = RecordDataDAO.getConnection();
			smt = con.createStatement();
			smt.executeUpdate(sql);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}

	}

}
