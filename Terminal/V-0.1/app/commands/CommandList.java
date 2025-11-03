package app.commands;

import java.util.List;

public class CommandList {

	public static final List<String> commands = List.of(
			"help",
			"desc",
			"quit",
			"reset",
			"login",
			"change password",
			"isadmin",
			"select file",
			"unselect file",
			"current file",
			"encrypt file",
			"batch encrypt"
			);

	public static String describe(String cmd) {
		
		String r = "";
		
		switch(cmd.strip().toLowerCase()) {
			
		default:
			r += "Invaild Input";
			break;
		
		case "help":
			r += "Help command uses no additional inputs and it outputs all commands available";
			break;
			
		case "desc":
			r += "Desc command uses one additional input of the command the user wants more details about";
			break;
			
		case "quit":
			r += "Quit command uses no additional inputs and will exit the terminal if the user says yes in the next commmand";
			break;
			
		case "reset":
			r += "Reset command uses no additional inputs and will reset the terminal's output back to one line";
			break;
			
		case "login":
			r += "Login command uses one additional input of a password and if correct will allow admin commands to be used";
			break;
			
		case "change password":
			r += "Change Password command uses two additional inputs, the first is the old password"
					+ " and the second is the new password,\\nafterwards it will change the password given correct inputs";
			break;
			
		case "isadmin":
			r += "The isadmin command uses no additional inputs and will output whether or not the user is able to use admin commands";
			break;
			
		case "select file":
			r += "Select file command will prompt the user to pick an application in use for single file encryption";
			break;
			
		case "unselect file":
			r += "Unselect file will simply unsave the selected file";
			break;
			
		case "current file":
			r += "Current file command will simply output which file if any is currently selected";
			break;
			
		case "encrypt file":
			r += "Encrypt file command will take the current;y selected file, the one selected from the select file command"
					+ ", and uses one additional input as a key to either encrypt or decrypt the file";
			break;
			
		case "batch encrypt":
			r += "Batch encrypt uses one additional input as a key to either encrypt or decrypt a "
					+ "directory selected in a pop up window";
			break;
			
		}
		
		return r;
	}
	
}
