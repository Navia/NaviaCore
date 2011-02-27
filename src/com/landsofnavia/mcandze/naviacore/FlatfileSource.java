package com.landsofnavia.mcandze.naviacore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FlatfileSource {
	
	public static String directory = "plugins" + File.separator + "Navia" + File.separator + "CoreSettings";
	
	public static boolean commandIsDisabled(String command){
		File file = new File(directory, "disabledcommands.txt");
		if (!file.exists()){
			try {
				file.createNewFile();
				return false;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
			
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String curLine;
			while ((curLine = br.readLine()) != null){
				if (curLine.equalsIgnoreCase(command))
					return true;
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
