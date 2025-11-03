package app.commands;

import java.io.File;
import java.util.List;

import app.commands.filesys.FileManager;
import app.window.terminal.TerminalManager;

public class Commands {
	
	private static boolean isAdmin = false;
	
	private static String selectedFile = "";
	
	private static void notAdmin() {
		TerminalManager.addLine("\\nInvalid Privilege\\n");
	}

	public static void execute(String com, List<String> optionals) {
		
		switch(com) {
		
		default:
			TerminalManager.addLine("\\nEXECUTE FAILURE\\n");
			break;
		
		case "help":
			help();
			break;
			
		case "desc":
			desc(optionals.get(0));
			break;
			
		case "quit":
			areYouSureQuit();
			break;
			
		case "reset":
			TerminalManager.resetLines();
			break;
			
		case "login":
			if(!hasEnoughOptionals(1, optionals)) {return;}
			login(optionals.get(0));
			break;
			
		case "change password":
			if(!hasEnoughOptionals(2, optionals)) {return;}
			changePassword(optionals.get(0), optionals.get(1));
			break;
			
		case "isadmin":
			TerminalManager.addLine("\\n" + isAdmin + "\\n");
			break;
			
		case "select file":
			selectfile();
			break;
			
		case "unselect file":
			unselectfile();
			break;
			
		case "current file":
			TerminalManager.addLine("\\n" + selectedFile + "\\n");
			break;
			
		case "encrypt file":
			if(!hasEnoughOptionals(1, optionals)) {return;}
			encryptFile(optionals.get(0));
			break;
			
		case "batch encrypt":
			if(!hasEnoughOptionals(1, optionals)) {return;}
			batchEncrypt(optionals.get(0));
			break;
			
		}
		
	}

	private static void desc(String cmd) {
		TerminalManager.addLine(CommandList.describe(cmd));
	}

	private static boolean areYouSureQuit() {
		
		boolean r = false;
		
		TerminalManager.addLine("Are You Sure?\\nY: yes | N: no");
		TerminalManager.setInputCommand((String in) -> quit(in));
		
		return r;
	}
	
	private static void quit(String in) {
		if(in.toLowerCase().trim().equals("y") || in.toLowerCase().trim().equals("yes")) {
			System.exit(0);
		}
	}

	private static boolean hasEnoughOptionals(int amount, List<String> optionals) {
		if(optionals.size() < amount) {
			TerminalManager.addLine("INVALID NUMBER OF OPTIONALS");
			return false;
		}
		
		return true;
	}

	private static void batchEncrypt(String key) {
		
		String directory = FileManager.selectFile(true);
		
		File f = new File(directory);
		File[] allFiles = f.listFiles();
		
		for(File t : allFiles) {
			if(t.getName().contains(".")) {
				Encrypt.encryptFile(t.getAbsolutePath(), key);
				TerminalManager.addLine(t.getName() + " Encrypted");
			}
		}
		
	}

	private static void changePassword(String oldPas, String newPas) {
		
		if(!isAdmin) {
			notAdmin();
			return;
		} else if(!checkPassword(oldPas)) {
			TerminalManager.addLine("Incorrect Password!");
			return;
		} else if(newPas.length() < 5) {
			TerminalManager.addLine("Password Must Be At Least 4 Characters!");
			return;
		}
		
		FileManager.write(System.getProperty("user.dir") + "\\data\\pswhash.data", ("" + newPas.hashCode()).getBytes());
		Encrypt.encryptFile(System.getProperty("user.dir") + "\\data\\pswhash.data", newPas.substring(0, 4));
		
	}

	private static void encryptFile(String key) {
	
		if(!selectedFile.isEmpty()) {
			Encrypt.encryptFile(selectedFile, key);
			TerminalManager.addLine("\\nEncrpyted\\n");
		} else {
			TerminalManager.addLine("\\nFailed\\n");
		}
		
	}
	
	private static void unselectfile() {
		selectedFile = "";
	}
	
	private static void selectfile() {
		
		String path = FileManager.selectFile(false);
		
		if(!path.isEmpty()) {
			selectedFile = path;
		}
		
	}

	private static void help() {
		TerminalManager.addLine("\\nUse \"desc -{name of command}\" to get a description of a command!"
				+ "\\nList of all commands:\\n");
		
		for(String l : CommandList.commands) {
			TerminalManager.addLine("    " + l);
		}
		
		TerminalManager.addLine("\\n");
	}
	
	private static boolean checkPassword(String pas) {
		boolean r = false;
		
		String filepath = System.getProperty("user.dir") + "\\data\\pswhash.data";
		TerminalManager.resetLines();
		
		Encrypt.encryptFile(filepath, pas.substring(0, 4));
		if(FileManager.readFile(filepath).get(0).equals(pas.hashCode() + "")) {
			r = true;
		} else {
			TerminalManager.addLine("Login Failed!");
		}
		Encrypt.encryptFile(filepath, pas.substring(0, 4));
		
		return r;
	}
	
	private static void login(String pass) {
		if(checkPassword(pass)) {
			isAdmin = true;
			TerminalManager.resetLines();
			TerminalManager.addLine("Login Successful!");
		} else {
			TerminalManager.resetLines();
			TerminalManager.addLine("Login Failed!");
		}
		
	}
	
}
