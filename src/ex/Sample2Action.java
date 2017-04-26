package ex;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author answer
 *
 */
public class Sample2Action extends Action {

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 次画面へフォワード
		String resultForward = "";
		if(isCancelled(request)){//キャンセルボタン押下
			resultForward = "cancel";
		} else {
			resultForward = "finish";
		}
		return mapping.findForward(resultForward);
	}


}
