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
        int q2_answer = 0;
        Double temp = 0.0;

        if (scanner != null) {
            while(scanner.hasNext()){
                temp = Double.parseDouble(scanner.next());
                q1_answer += calculateFuelRequiredForSanta(temp);
                q2_answer += calculateAllTheFuels(temp);
            }
        }

        System.out.println("This is all you need to run for now: " + q1_answer);
        System.out.println("ALL THE FUELS!: " + q2_answer);

    }

    private static int calculateFuelRequiredForSanta (double number){
        double result = Math.floor(number / 3) - 2;
        if (result<=0){
            return 0;
        } else {
            return (int) result;
        }
    }

    private static int calculateAllTheFuels (double number){
        double result = Math.floor(number / 3) - 2;
        if (result<=0){
            return 0;
        } else {
            return (int) result + calculateAllTheFuels((int) result);
        }
    }

}
