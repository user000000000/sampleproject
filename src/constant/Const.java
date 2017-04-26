package constant;

public class Const {

	// 趣味
	public enum HOBBY{
		GOURMET("01","グルメ"),
		GAMBLING("02","ギャンブル"),
		TRAVEL("03","旅行"),
		WATCHING_MOVIES("04","映画鑑賞");

		private final String code;
		private final String label;

		private HOBBY(final String code, final String label) {
			this.code = code;
			this.label = label;
		}

		public String getCode() {
			return code;
		}

		public String getLabel() {
			return label;
		}
	}














}
