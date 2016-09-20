package javaExceptTemp;

public class TempException extends RuntimeException {
	public TempException() {
		super("la valeur de temperature est impossible");
	}

}
