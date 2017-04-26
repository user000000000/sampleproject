package ex;

import org.apache.struts.validator.ValidatorForm;

/**
 * 入力情報を保持するクラス
 * @author answer
 *
 */
public class SampleActionForm extends ValidatorForm {

	/**
	 * 名前
	 */
	private String name;

	/**
	 * 年齢
	 */
	private String age;

	/**
	 * 趣味コード
	 */
	private String hobby;

	/**
	 * 趣味名称
	 */
	private String hobbyLabel;

	/**
	 * 好きな食べもの
	 */
	private String favoriteFood;

	private String aaa;


	/**
	 * 名前を返却する。
	 * @return 名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名前をセットする。
	 * @param name 名前
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 年齢を返却する。
	 * @return 年齢
	 */
	public String getAge() {
		return age;
	}

	/**
	 * 年齢をセットする。
	 * @param name 年齢
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * 趣味コードを返却する。
	 * @return 趣味コード
	 */
	public String getHobby() {
		return hobby;
	}

	/**
	 * 趣味コードをセットする。
	 * @param name 趣味コード
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	/**
	 * 趣味名称を返却する。
	 * @return 趣味名称
	 */
	public String getHobbyLabel() {
		return hobbyLabel;
	}

	/**
	 * 趣味名称をセットする。
	 * @param name 趣味名称
	 */
	public void setHobbyLabel(String hobbyLabel) {
		this.hobbyLabel = hobbyLabel;
	}

	/**
	 * 好きな食べ物を返却する。
	 * @return 好きな食べ物
	 */
	public String getFavoriteFood() {
		return favoriteFood;
	}

	/**
	 * 好きな食べ物をセットする。
	 * @param name 好きな食べ物
	 */
	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}


}
