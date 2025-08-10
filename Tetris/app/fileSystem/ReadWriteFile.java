package app.fileSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadWriteFile {
	
	private String filePath = System.getProperty("user.dir") + "\\data";
	private String fileName = "data.txt";
	
	public void writeFile(int value) {
		
		try (FileWriter write = new FileWriter(filePath + "\\" + fileName)) {
			
			String t = "" + value;
			write.write(t);
			write.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int readFile() {
		
		try (Scanner scan = new Scanner(new File(filePath, fileName))) {
			
			String temp = scan.nextLine();
				
			return Integer.parseInt(temp);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			return 0;
		} catch (NoSuchElementException e) {
			return 0;
		}
		
		return 0;
		
	}
	
}
