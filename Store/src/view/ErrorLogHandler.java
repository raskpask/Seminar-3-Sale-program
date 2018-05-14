package view;

/**
 * Makes a error log for what went wrong.
 * @author molin
 *
 */
public class ErrorLogHandler {
/**
 * 
 * @param message, makes a error message out of this. Could also be a file if it was a real program.
 */
	public static void makeLogMessage(String message) {
		StringBuilder errorMessageBuilder = new StringBuilder();
		errorMessageBuilder.append("This message is to the developer: \n"
				+ "-----------------------------------------------\n");
		errorMessageBuilder.append(ErrorMessageHandler.createTime());
		errorMessageBuilder.append(", ERROR:");
		errorMessageBuilder.append(message +"\n ------------------------------------------------ \n \n");
		
		System.out.println(errorMessageBuilder);// Could make a file out of this instead.
	}

}
