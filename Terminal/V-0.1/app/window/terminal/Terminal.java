package app.window.terminal;

import java.util.ArrayList;
import java.util.List;

import app.window.WindowManager;

class Terminal {

	public List<String> lines;
	
	Terminal() {
		lines = new ArrayList<>();
		lines.add("->");
	}
	
	void key(char k) {
		
		if(k == '\n') {
			TerminalManager.parseForCommands(lines.get(lines.size()-1));
			lines.add(new String("->"));
		} else if(k == '\b') {
			
			String s = lines.get(lines.size()-1);
			s = s.substring(0, s.length()-1);
			if(lines.get(lines.size()-1).length() > 2) {
				lines.set(lines.size()-1, s);
			}
			
		} else {
		
			
			if(lines.isEmpty()) {
				lines.add(new String("->"));
			}
			
			lines.set(lines.size()-1, lines.get(lines.size()-1)+k);
			
		}
		
		WindowManager.updateWindow();
		
	}
	
	void addLine(String n) {
		
		List<String> toAdd = new ArrayList<>();
		
		String line = n;
		
		while(true) {
			
			int index = line.indexOf('\\');
			if(index != -1) {
				switch(line.charAt(index+1)) {
				
				case 'n':
					toAdd.add(line.substring(0, index));
					line = line.substring(index+2);
					break;
				
				}
				
			} else {
				
				toAdd.add(line);
				break;
				
			}
			
		}
		
		lines.addAll(toAdd);
		
	}

	List<String> getLines() {
		return lines;
	}

	void resetLines() {
		this.lines = new ArrayList<>();
	}
	
}
