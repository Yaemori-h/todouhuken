package bean;

public class RecordData {
	private String name; //名前
	private int score; //得点
	private int gameType; //ゲーム種類
	private long completeTime; //完了時間
	private boolean myDataFlag;
	{ //登録したデータフラグ	
		this.name = null;
		this.score = 0;
		this.gameType = 0;
		this.completeTime = 0;
		this.myDataFlag = false;
	}

	//アクセサメソッド
	public String getName() {
		return this.name;
	}

	public int getScore() {
		return this.score;
	}

	public int getGameType() {
		return this.gameType;
	}

	public long getCompleteTime() {
		return this.completeTime;
	}

	public boolean isMyDateFlag() {
		return this.myDataFlag;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setGameType(int gameType) {
		this.gameType = gameType;
	}

	public void setCompleteTime(long completeTime) {
		this.completeTime = completeTime;
	}

	public void setMyDataFlag(boolean myDataFlag) {
		this.myDataFlag = myDataFlag;
	}

}