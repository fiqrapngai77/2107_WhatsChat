package whatschat;

import java.util.regex.Pattern;

public final class Register {

	public static boolean validation(String userID) {

		String noSpace = "\\S*";
		String firstCharNumeric = "\\d";
		if (userID.length() > 8) {
			Variables.setERROR("User ID have to be at most 8 characters. ");
			return false;
		} else if (Pattern.matches(noSpace, userID) == false) {
			Variables.setERROR("User ID cannot have spaces. ");
			return false;
		} else if (userID.substring(0, 1).matches(firstCharNumeric)) {
			Variables.setERROR("User ID cannot have first digit as numeric. ");
			return false;
		} else if (Variables.getUserIDList().contains(userID)) {
			Variables.setERROR("User ID is taken. ");
			return false;
		} else {
			Variables.setERROR("");
			return true;
		}

	}
}
