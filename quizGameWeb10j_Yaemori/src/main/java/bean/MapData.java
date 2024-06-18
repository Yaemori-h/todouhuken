package bean;

public class MapData {
	private int dataID; //データID
	private String prefectureName; //県名
	private String fileName; //ファイル名
	private int gameType; //ゲームタイプ
	{
		this.dataID = 0;
		this.prefectureName = null;
		this.gameType = 0;
	}
//	アクセサメソッド
	public int getDataID() {
		return this.dataID;
	}

	public String getPrefectureName() {
		return this.prefectureName;
	}

	public int getGameType() {
		return this.gameType;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setDataID(int dataID) {
		this.dataID = dataID;
	}

	public void setPrefecture(String prefectureName) {
		this.prefectureName = prefectureName;
	}

	public void setGameType(int gameType) {
		this.gameType = gameType;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
