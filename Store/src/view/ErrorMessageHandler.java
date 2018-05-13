package view;

import java.time.LocalTime;
import java.time.format.FormatStyle;

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
	
	private static String createTime() {
		/*LocalTime now= LocalTime.now();
		TimeFormatter formatter = new TimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		return now.format(formatter);
		*/
		String randomTime="12:00";
		return randomTime;
	}
}
