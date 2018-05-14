package view;

import java.util.Date;

/**
 * This unit is responsible for showing the error to the user.
 * @author molin
 *
 */
public class ErrorMessageHandler {
/**
 * Display specific message.
 */
	
	public static void showErrorMessage(String message) {
		StringBuilder errorMessageBuilder = new StringBuilder();
		errorMessageBuilder.append("This message is to the user: \n"
				+ "-----------------------------------------------\n");
		errorMessageBuilder.append(createTime());
		errorMessageBuilder.append(", ERROR:");
		errorMessageBuilder.append(message +"\n ------------------------------------------------ \n \n");
		
		System.out.println(errorMessageBuilder);
	}
	
/**
 * 
 * @return current time is returned
 */
	static String createTime() {
		return new Date().toString();
	}
}
