package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.MapData;

public class MapDataDAO {
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

	//③ゲームの種類を元に、データベースより地図情報を取得するメソッド
	public ArrayList<MapData> selectByGameType(int gameType) {
		Connection con = null;
		Statement smt = null;

		ArrayList<MapData> mapList = new ArrayList<MapData>();

		String sql = "SELECT * FROM quizinfo WHERE game_type = " + gameType;

		try {
			con = MapDataDAO.getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				MapData mData = new MapData();
				mData.setDataID(rs.getInt("data_id"));
				mData.setPrefecture(rs.getString("prefecture_name"));
				mData.setGameType(rs.getInt("game_type"));
				mData.setFileName(rs.getString("file_name"));
				mapList.add(mData);
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
		return mapList;
	}

	//④データベースより地図情報をすべて取得する
	public ArrayList<MapData> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<MapData> mapList = new ArrayList<MapData>();

		String sql = "SELECT * FROM quizinfo";

		try {
			con = MapDataDAO.getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				MapData mData = new MapData();
				mData.setDataID(rs.getInt("data_id"));
				mData.setPrefecture(rs.getString("prefecture_name"));
				mData.setGameType(rs.getInt("game_type"));
				mData.setFileName(rs.getString("file_name"));
				mapList.add(mData);
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
		return mapList;
	}

}
