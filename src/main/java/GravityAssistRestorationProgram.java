import Helpers.FileHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static Helpers.Constants.FILE_NAME;

public class GravityAssistRestorationProgram {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = FileHelper.readFile(FILE_NAME);
        Scanner scanner = FileHelper.scanFile(inputFile);
        List<Integer> opCode = new ArrayList<Integer>();

        assert scanner != null;
        String[] inputArray = scanner.next().split(",");

        for (String inputNumber : Arrays.asList(inputArray)) {
            opCode.add(Integer.parseInt(inputNumber));
        }

        // Setup code
        opCode.set(1,12);
        opCode.set(2,2);

        for (int position = 0; position < opCode.size(); position += 4 ){
            int firstPosition = opCode.get(position + 1);
            int secondPosition = opCode.get(position + 2);
            int targetPosition = opCode.get(position + 3);
            int result;

            if (opCode.get(position)==1){
                result = opCode.get(firstPosition) + opCode.get(secondPosition);
                opCode.set(targetPosition, result);
            }else if (opCode.get(position)==2){
                result = opCode.get(firstPosition) * opCode.get(secondPosition);
                opCode.set(targetPosition, result);
            }else if (opCode.get(position)==99){
                System.out.println("Opcode 99 identified. Exiting...");
                break;
            }else {
                System.out.println("Something went wrong. Exiting...");
                break;
            }
        }


        System.out.println("Part 1 answer: " + opCode.get(0));

    }

}



