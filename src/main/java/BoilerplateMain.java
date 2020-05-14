import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Helpers.FileHelper;
import static Helpers.Constants.FILE_NAME;

public class BoilerplateMain {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = FileHelper.readFile(FILE_NAME);
        Scanner scanner = FileHelper.scanFile(inputFile);

        assert scanner != null;
    }


}
