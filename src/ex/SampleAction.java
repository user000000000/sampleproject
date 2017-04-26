package ex;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import constant.Const;
import constant.Const.HOBBY;

/**
 * Hello画面を表示するActionクラス
 * @author answer
 *
 */
public class SampleAction extends Action {

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// ActionForm型の変数にstruts-configで指定したフォームクラスのインスタンスが格納されているので
		// 使用する際は、キャストして使う
		SampleActionForm sampleForm = (SampleActionForm) form;

		// メッセージの生成
		ActionMessages errors = new ActionMessages();

		// 相関チェック
		if (HOBBY.GOURMET.getCode().equals(sampleForm.getHobby()) &&
				(sampleForm.getFavoriteFood() == null || "".equals(sampleForm.getFavoriteFood()))) {
			// 趣味の選択値が01:グルメの場合に、好きな食べもに入力がない場合エラー
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.favoriteFood"));
		}

		// 入力値編集
		editParam(sampleForm);

		// 次画面へフォワード
		String resultForward = "";
		if (errors.isEmpty()) {
			// エラー無しの場合
			resultForward = "success";
		} else {
			// エラー有りの場合
			saveErrors(request, errors);
			resultForward = "failed";
		}
		return mapping.findForward(resultForward);
	}

	// 入力データの編集を行う
	private void editParam(SampleActionForm form) {

		// 趣味
		form.setHobbyLabel(getHobbyName(form.getHobby()));

	}

	// 趣味コードに対して、名称を返してくれるメソッド
	private String getHobbyName(String code) {
		if (Const.HOBBY.GOURMET.getCode().equals(code)) { // グルメ
			return Const.HOBBY.GOURMET.getLabel();
		} else if (Const.HOBBY.GAMBLING.getCode().equals(code)) { // ギャンブル
			return Const.HOBBY.GAMBLING.getLabel();
		} else if (Const.HOBBY.TRAVEL.getCode().equals(code)) { // 旅行
			return Const.HOBBY.TRAVEL.getLabel();
		} else if (Const.HOBBY.WATCHING_MOVIES.getCode().equals(code)) { // 映画鑑賞
			return Const.HOBBY.WATCHING_MOVIES.getLabel();
		} else {
			return null;
		}
	}

}
