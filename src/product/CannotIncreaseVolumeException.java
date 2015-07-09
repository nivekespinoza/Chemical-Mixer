/**
 * 
 */
package product;

/**
 * CannotIncreaseVolumeException is exception
 * thrown if user tries to scale volume past 100%
 * @author Patrick Michaelsen
 * @version "%I%, %G%"
 */
public class CannotIncreaseVolumeException extends RuntimeException {

	private static final long serialVersionUID = -5391884668313513365L;

	/**
	 * Constructs an IndexOutOfBoundsException with no detail message.
	 */
	public CannotIncreaseVolumeException() {
		
	}

	/**
	 * @param message	the scalar that caused the error
	 */
	public CannotIncreaseVolumeException(String message) {
		super(message);
	}

	
	
	/**
	 * @param cause
	 */
	public CannotIncreaseVolumeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CannotIncreaseVolumeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CannotIncreaseVolumeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
