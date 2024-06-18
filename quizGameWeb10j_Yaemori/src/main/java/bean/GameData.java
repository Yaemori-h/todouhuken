package bean;

import java.util.ArrayList;

public class GameData {

	static private final int selectCnt = 4; //選択肢数
	static private final int beginnerProblemCnt = 10; //初級編の問題数
	static private final int middleProblemCnt = 25; //中級編の問題数
	private int totalProblemCnt; //問題数
	private int problemCnt; //現在のゲーム数
	private int correctAnswersCnt;//スコア->正解数
	private int gameType;//ゲーム種類
	private int order;//順位
	private String gameName;//ゲーム名
	private long gameStartTime;//ゲーム開始時間
	private long gameEndTime; //ゲーム終了時間
	private ArrayList<String> answer; //問題の解答(県名)
	private ArrayList<ArrayList<String>> choices; //選択肢(県名)
	private ArrayList<String> selectAnswer;//回答
	private ArrayList<String> result;//結果
	private ArrayList<String> fileName;//ファイル名

	{
		this.totalProblemCnt = 0;
		this.problemCnt = 0;
		this.correctAnswersCnt = 0;
		this.gameType = 0;
		this.order = 0;
		this.gameName = null;
		this.gameStartTime = 0;
		this.gameEndTime = 0;
		this.answer = new ArrayList<String>();
		this.choices = new ArrayList<ArrayList<String>>();
		this.selectAnswer = new ArrayList<String>();
		this.result = new ArrayList<String>();
		this.fileName = new ArrayList<String>();
	}
	
	//アクセサメソッド
	public int getTotalProblemCnt() {
		return this.totalProblemCnt;
	}

	public int getProblemCnt() {
		return this.problemCnt;
	}

	public int getCorrectAnswersCnt() {
		return this.correctAnswersCnt;
	}

	public int getGameType() {
		return this.gameType;
	}

	public int getOrder() {
		return this.order;
	}

	public String getGameName() {
		return this.gameName;
	}

	public long getGameStartTime() {
		return this.gameStartTime;
	}

	public long getGameEndTime() {
		return this.gameEndTime;
	}

	public ArrayList<String> getAnswer() {
		return this.answer;
	}

	public ArrayList<ArrayList<String>> getChoices() {
		return this.choices;
	}

	public ArrayList<String> getSelectAnswer() {
		return this.selectAnswer;
	}

	public ArrayList<String> getResult() {
		return this.result;
	}

	public ArrayList<String> getFileName() {
		return this.fileName;
	}

	public static int getSelectCnt() {
		return selectCnt;
	}

	public static int getBeginnerProblemCnt() {
		return beginnerProblemCnt;
	}

	public static int getMiddleProblemCnt() {
		return middleProblemCnt;
	}

	public String getAnswer(int indexNo) {
		return this.answer.get(indexNo);
	}

	public ArrayList<String> getChoices(int indexNo) {
		return this.choices.get(indexNo);
	}

	public String getSelectAnswer(int indexNo) {
		return this.selectAnswer.get(indexNo);
	}

	public String getResult(int indexNo) {
		return this.result.get(indexNo);
	}

	public String getFileName(int indexNo) {
		return this.fileName.get(indexNo);
	}

	public void setTotalProblemCnt(int totalProblemCnt) {
		this.totalProblemCnt = totalProblemCnt;
	}

	public void setProblemCnt(int problemCnt) {
		this.problemCnt = problemCnt;
	}

	public void setCorrectAnswersCnt(int correctAnswersCnt) {
		this.correctAnswersCnt = correctAnswersCnt;
	}

	public void setGameType(int gameType) {
		this.gameType = gameType;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public void setGameStartTime(long gameStartTime) {
		this.gameStartTime = gameStartTime;
	}

	public void setGameEndTime(long gameEndTime) {
		this.gameEndTime = gameEndTime;
	}

	public void setAnswer(ArrayList<String> answer) {
		this.answer = answer;
	}

	public void setChoices(ArrayList<ArrayList<String>> choices) {
		this.choices = choices;
	}

	public void setSelectAnswer(ArrayList<String> selectAnswer) {
		this.selectAnswer = selectAnswer;
	}

	public void setResult(ArrayList<String> result) {
		this.result = result;
	}

	public void setFileName(ArrayList<String> fileName) {
		this.fileName = fileName;
	}

	public void setAnswer(String answer) {
		this.answer.add(answer);
	}

	public void setChoicesToIndividual(ArrayList<String> choices) {
		this.choices.add(choices);
	}

	public void setSelectAnswer(String selectAnswer) {
		this.selectAnswer.add(selectAnswer);
	}

	public void setResult(String result) {
		this.result.add(result);
	}

	public void setFileName(String fileName) {
		this.fileName.add(fileName);
	}

}
