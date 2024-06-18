package bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

public class QuizGameBean {

	private static int scoreCnt;//スコア順
	private static int orderCnt;//順位
	private static Random random;//Randomオブジェクト
	{
		QuizGameBean.scoreCnt = 1;
		QuizGameBean.orderCnt = 1;
		QuizGameBean.random = new Random();
	}

	//③出題されるすべての問題の回答と、画像ファイル名を格納するメソッド
	public void selectAnswer(GameData gameData, ArrayList<MapData> mapDataList) {

		Collections.shuffle(mapDataList);//shuffleメソッドでmapDataListをランダムに並び替える。

		//シャッフルされたmapDataListから、県名とファイル名を取り出しgameDataに格納。
		for (int i = 0; i < mapDataList.size(); i++) {
			gameData.setAnswer(mapDataList.get(i).getPrefectureName());
			gameData.setAnswer(gameData.getAnswer());

			gameData.setFileName(mapDataList.get(i).getFileName());
			gameData.setFileName(gameData.getFileName());
		}
		//⑤を呼び出し、問題数を設定
		getProblemCnt(gameData);

	}
	//④答えリストに同じ答えがあるかをチェックするメソッド→シャッフルすることによって解決。不必要なメソッド

	/*　アンサーと同じのとき　カウント＋１
	 * 　違うとき＋０
	 *　ループ抜け出したとき、カウントが１ならＯＫ、０ならエラー
	 * 
	 */
	//	public void chkAnswerList(ArrayList<String> answerList,String answer) {
	//		int equalCount=0;//answerと同じになった回数
	//		for(int i=0;i<answerList.size();i++) {
	//			if(answer.equals(answerList.get(i))) {
	//				equalCount++;
	//			}
	//		}
	//equalCountが１じゃないなら、エラー？やり直し？

	//	}

	//5⑤gameTypeより問題数を取得するメソッド
	public void getProblemCnt(GameData gameData) {
		int gameType = gameData.getGameType();
		switch (gameType) {
		case 1:
			gameData.setTotalProblemCnt(GameData.getBeginnerProblemCnt());
			break;
		case 2:
			gameData.setTotalProblemCnt(GameData.getMiddleProblemCnt());
			break;
		case 3:
			gameData.setTotalProblemCnt(47);
			break;
		case 4:
			gameData.setTotalProblemCnt(9);
			break;
		case 5:
			gameData.setTotalProblemCnt(8);
			break;
		case 6:
			gameData.setTotalProblemCnt(7);
			break;
		case 7:
			gameData.setTotalProblemCnt(7);
			break;
		case 8:
			gameData.setTotalProblemCnt(7);
			break;
		case 9:
			gameData.setTotalProblemCnt(9);
			break;
		}
	}

	//6⑥問題出題時に表示される選択肢を作成し格納するメソッド
	public void createProblem(GameData gameData, ArrayList<MapData> mapDataList) {

		ArrayList<String> choice = new ArrayList<String>();
		ArrayList<ArrayList<String>> choices = new ArrayList<ArrayList<String>>();

		int i;
		for (i = 0; i < gameData.getTotalProblemCnt(); i++) {//クイズの数ループ
			if (choice != null) {
				choice = new ArrayList<String>();//choiceの初期化
			}
			//選択肢の数（４）ループ、ここで選択肢を作る
			int j;//continueで返ってきたときcountを０にできるようここで定義

			//選択肢の数だけ、mapDataからランダムに取り出す
			for (j = 0; j < GameData.getSelectCnt(); j++) {
				MapData md = mapDataList.get(random.nextInt(mapDataList.size()));

				choice.add(md.getPrefectureName());
			}

			//作られた選択肢の重複チェックをして、選択肢リストに格納⑦ireru
			boolean judge = checkSessionchkChoiceList(choice, gameData.getAnswer(i));
			//重複チェックがfalseならjをリセット、インクリメントするはずだったiをデクリメントし打消し
			if (judge == false) {
				j = 0;
				i--;
				continue;
			}
			gameData.setChoicesToIndividual(choice);
		}
	}

	//⑦選択肢リストに同じ選択肢があるかをチェックするメソッド
	public boolean checkSessionchkChoiceList(ArrayList<String> choAnswerList, String answer) {
		boolean judge = true;
		int equalCount = 0;
		//答えが選択肢の中に１つだけ含まれるときだけtrue
		for (int i = 0; i < choAnswerList.size(); i++) {
			if (answer.equals(choAnswerList.get(i))) {
				equalCount++;
			}
		}
		if (equalCount != 1) {
			judge = false;
		}

		//ArrayListの重複チェック
		//LinkHashSetで並び替えずに重複する要素を削除する。
		//削除前と削除後で要素数が異なれば、false
		List<String> hashList = new ArrayList<String>(new LinkedHashSet<>(choAnswerList));

		if (hashList.size() != choAnswerList.size()) {
			judge = false;
		}
		return judge;
	}

	//⑧セッションの状態を確認するメソッド
	public boolean checkSession(GameData targetData) {
		boolean sessionTF = true;
		if (targetData == null) {
			sessionTF = false;
		}
		return sessionTF;
	}

	//⑨ランキング登録後のランキング確認画面にて、登録したデータが表示されているか確認するメソッド←用途不明
	//	public void searchAgreementRecord(RecordData recordData, ArrayList<RecordData> recordDataList) {
	//
	//		recordData.setMyDataFlag(recordDataList.contains(recordData));
	//
	//	}

	//⑩ゲームの種類からクイズ名を判別するメソッド
	public String showQuizName(int gameType) {
		String Qname = "";
		switch (gameType) {
		case 1:
			Qname = "日本地図あてクイズ  ～初級編～";
			break;
		case 2:
			Qname = "日本地図あてクイズ  ～中級編～";
			break;
		case 3:
			Qname = "日本地図あてクイズ  ～上級編～";
			break;
		case 4:
			Qname = "地域別クイズ  ～中国・四国地方編～";
			break;
		case 5:
			Qname = "地域別クイズ  ～九州・沖縄地方編～";
			break;
		case 6:
			Qname = "地域別クイズ  ～関東地方編～";
			break;
		case 7:
			Qname = "地域別クイズ  ～北海道・東北地方編～";
			break;
		case 8:
			Qname = "地域別クイズ  ～近畿地方編～";
			break;
		case 9:
			Qname = "地域別クイズ  ～中部地方編～";
			break;
		}
		return Qname;
	}
	//⑪ランキング表示時の順位を判別するメソッド

	public int showResultOrder(int index, ArrayList<RecordData> recordDataList) {
		int rank = 0;

		if (index == 0) {
			rank = 1;
			//スコアが前と同じなら前の人と同じ順位、違うならindex+1位
		} else if (recordDataList.get(index).getScore() == recordDataList.get(index - 1).getScore()) {
			rank = showResultOrder(index - 1, recordDataList);
		} else {
			rank = index + 1;
		}
		return rank;
	}
}
