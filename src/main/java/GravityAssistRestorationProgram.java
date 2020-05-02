import Helpers.FileHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static Helpers.Constants.FILE_NAME;

public class GravityAssistRestorationProgram {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = FileHelper.readFile(FILE_NAME);
        Scanner scanner = FileHelper.scanFile(inputFile);
        List<Integer> defaultOpCode = new ArrayList<Integer>();

        assert scanner != null;
        String[] inputArray = scanner.next().split(",");

        for (String inputNumber : Arrays.asList(inputArray)) {
            defaultOpCode.add(Integer.parseInt(inputNumber));
        }

        // Part 1
        List<Integer> opCode = new ArrayList<Integer>(defaultOpCode);
        calculateGravitationalOutput(opCode, 12, 2);
        System.out.println("Part 1 answer: " + opCode.get(0));

        // Part 2
        System.out.println("Part 2 answer: " + calculatePartTwoAnswer(defaultOpCode));
    }

    private static int calculatePartTwoAnswer(final List<Integer> defaultOpCode) {
        List<Integer> tempOpCode = new ArrayList<Integer>(defaultOpCode);
        for (int noun = 0; noun<=99; noun++){
            for (int verb = 0; verb<=99; verb++) {
                Collections.copy(tempOpCode, defaultOpCode);
                calculateGravitationalOutput(tempOpCode, verb, noun);
                if (tempOpCode.get(0) == 19690720){
                    return 100 * verb + noun ;
                }
            }
        }
        return 0;
    }

    private static void calculateGravitationalOutput(final List<Integer> opCode, int inputVerb, int inputNoun) {
        // Setup code
        opCode.set(1,inputVerb);
        opCode.set(2,inputNoun);

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
                break;
            }else {
                System.out.println("Something went wrong. Exiting...");
                break;
            }
        }
    }

}



