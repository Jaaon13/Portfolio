package app.fileSystem;

import java.io.File;
import java.io.IOException;

public class createFile {
	
	private String filePath = System.getProperty("user.dir") + "\\data";
	private String fileName = "data.txt";
	
	public boolean findFile() {
		
		return makeFile();
		
	}
	
	private boolean makeFile() {
		
		try {
			
			File dir = new File(filePath);
			
			if(!dir.exists()) {
				
				dir.mkdirs();
				
			}
			
			File data = new File(filePath, fileName);
			data.setWritable(true);
			
			if(data.createNewFile()) {
				
				return true;
				
			} else if(data.exists()) {
				
				return true;
				
			}
			
			
			
		} catch (IOException e) {
			
			System.out.println(e);
			
		}
		
		return false;
		
	}
	
}
