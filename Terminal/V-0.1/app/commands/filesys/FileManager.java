package app.commands.filesys;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class FileManager {

	public static String selectFile(boolean dir) {
		
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Select A File");
		
		if(dir) {
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}
		
		int result = fc.showOpenDialog(null);
		
		if(result == JFileChooser.APPROVE_OPTION) {
			
			return fc.getSelectedFile().getAbsolutePath();
			
		} else {
			return "";
		}
		
	}
	
	public static List<String> readFile(String FilePath) {
		
		List<String> file = new ArrayList<>();
		
		try (Scanner s = new Scanner(new File(FilePath))) {
			
			while(s.hasNextLine()) {
				file.add(s.nextLine());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return file;
		
	}
	
	public static void write(String FilePath, byte[] data) {
		try {
			Files.write(Paths.get(FilePath), data, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
