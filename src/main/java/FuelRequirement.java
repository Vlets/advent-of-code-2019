import Helpers.FileHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static Helpers.Constants.FILE_NAME_DAY_1;

public class FuelRequirement {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = FileHelper.readFile(FILE_NAME_DAY_1);
        Scanner scanner = FileHelper.scanFile(inputFile);

        int q1_answer = 0;

        while(scanner.hasNext()){
            q1_answer += calculateFuelRequiredForSanta(Integer.parseInt(scanner.next()));
        }

        System.out.println(q1_answer);

    }

    private static int calculateFuelRequiredForSanta (int number){
        double result = Math.floor(number / 3);
        if (result<=1){
            return 0;
        } else {
            return (int) result - 2;
        }
    }

}
