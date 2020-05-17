
public class InvalidAnswerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -486767339094813177L;
	InvalidAnswerException(int answer){
		super("Answers must be between 1-5. Your answer: "+answer);
	}
}
