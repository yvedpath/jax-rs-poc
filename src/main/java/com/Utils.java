package com;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
public final class Utils {

	public static byte[] readFileToBytes(String filePath) throws Exception{
		System.out.println("Inside Utils class");
		Path path = Paths.get(filePath);
		System.out.println(path);
		byte[] data=null;
		try
		{
	    data = Files.readAllBytes(path);  
		System.out.println(Arrays.toString(data));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    return data;

	}  
	
}


