package app.window.terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import app.commands.CommandList;
import app.commands.Commands;

public class TerminalManager {
	
	private static Terminal terminal = new Terminal();
	private static ExecuteFunction inputCommand = null;
	
	public static void addLine(String line) {
		terminal.addLine(line);
	}
	
	public static List<String> getLines() {
		return terminal.getLines();
	}
	
	public static void resetLines() {
		terminal.resetLines();
	}
	
	public static void parseForCommands(String line) {
		
		List<String> optionals = getOptionals(line.substring(2).strip().toLowerCase());
		
		String cmd = optionals.get(0);
		optionals.remove(0);
		
		if(Objects.nonNull(inputCommand)) {
			inputCommand.exec(cmd);
			inputCommand = null;
			return;
		}
		
		if(!validCommand(cmd)) {
			addLine("Invalid Command");
			return;
		}
		
		Commands.execute(cmd, optionals);
		
	}
	
	private static boolean validCommand(String cmd) {
		boolean r = false;
		
		for(String c : CommandList.commands) {
			
			if(c.hashCode() == cmd.hashCode()) {
				r = true;
				break;
			}
			
		}
		
		return r;
	}

	private static List<String> getOptionals(String inline) {
		
		List<String> r = new ArrayList<>();
		String line = inline;
		
		while(true) {
			
			int index = line.indexOf('-');
			
			if(index != -1) {
				
				r.add(line.substring(0, index).strip());
				line = line.substring(index+1);
				
			} else {
				
				r.add(line.strip());
				
				break;
				
			}
			
		}
		
		return r;
		
	}

	public static void addTerminalKey(char k) {
		terminal.key(k);
	}

	public static void setInputCommand(ExecuteFunction inputCommand2) {
		inputCommand = inputCommand2;
	}
	
}
