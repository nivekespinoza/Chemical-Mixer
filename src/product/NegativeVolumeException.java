package product;

/**
 * NegativeVolumeException is exception
 * thrown if user tries to instantiate product
 * with negative volume
 * @author Patrick Michaelsen
 * @version "%I%, %G%"
 *
 */
public class NegativeVolumeException extends RuntimeException {
	
	private static final long serialVersionUID = 2521303212036553294L;

	/**
	 * Constructs a NegativeVolumeException with no detail message
	 */
	public NegativeVolumeException() {
	}

	/**
	 * @param message	the negative volume that caused the error
	 */
	public NegativeVolumeException(String message) {
		super(message);
	}

	public NegativeVolumeException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NegativeVolumeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public NegativeVolumeException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
