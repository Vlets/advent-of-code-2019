package Helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHelper {

    public static File readFile (String fileName){
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }


    public static Scanner scanFile (File input) throws FileNotFoundException {
        try {
            return new Scanner(input);
        }catch (FileNotFoundException e){
            System.out.println("Error scanning file: " + e);
        }
        return null;
    }

}
