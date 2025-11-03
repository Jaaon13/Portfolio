package app.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import app.commands.filesys.FileManager;

class Encrypt {

	public static void encryptFile(String FilePath, String key) {
		try {
			FileManager.write(FilePath, byteEncryption(Files.readAllBytes(Paths.get(FilePath)), key.getBytes()));
		} catch (IOException e) {System.out.println(e.getStackTrace());}
	}
	
	public static String encryptString(String Data, String Key) {
		return new String(byteEncryption(Data.getBytes(), Key.getBytes()));
	}

	private static byte[] byteEncryption(byte[] fileBytes, byte[] key) {
		
		byte[] output = new byte[fileBytes.length];
		
		int keyByte = 0;
		
		for(int x = 0; x < fileBytes.length; x++) {
			
			if(keyByte == key.length) {
				keyByte = 0;
			}
			
			byte b = fileBytes[x];
			
			byte temp = 0;
			
			for(int i = 0; i < 8; i++) {
				
				int bitCompared = getBit(b, i) + getBit(key[keyByte], i);
				if(bitCompared == 1) {
					temp = (byte) (temp | (1 << i));
				}
				
			}
			
			keyByte++;
			output[x] = temp;
			
		}
		
		return output;
		
	}
	
	@SuppressWarnings("unused")
	private static String byteToString(byte b) {
		String binary = Integer.toBinaryString((int) b & 0xFF);
		return String.format("%8s", binary).replace(' ', '0');
	}
	
	// starts at least significant bit == 0
	private static int getBit(byte b, int pos) {
		return (b >> pos) & 1;
	}
	
}
