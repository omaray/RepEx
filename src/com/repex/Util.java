package com.repex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.repex.Util;

public class Util {
    private static final Logger logger = Logger.getLogger(Util.class.getName());
    
    // Read the content from the specified file
    public static String readFromFile(String fileName) {
        String line = null;
        StringBuilder sb = new StringBuilder();
        
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            
            bufferedReader.close();
            
        } catch(FileNotFoundException ex) {
            logger.log(Level.SEVERE, "Unable to find the file" + fileName, ex);
        } catch(IOException ex) {
            logger.log(Level.SEVERE, "Error reading the file" + fileName, ex);
        }
        
        return sb.toString();
    }
}
