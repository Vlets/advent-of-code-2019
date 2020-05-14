import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import Helpers.FileHelper;
import Structures.Position;
import static Helpers.Constants.FILE_NAME;

public class CrossedWires {

    private static Logger log = Logger.getLogger(CrossedWires.class.getName());

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = FileHelper.readFile(FILE_NAME);
        Scanner scanner = FileHelper.scanFile(inputFile);

        assert scanner != null;

//        int result = getPartOneResult(scanner);
//        System.out.println("Part 1 result: " + result);

        int result = getPartTwoResult(scanner);
        System.out.println("Part 2 result: " + result);

    }

    static int getPartOneResult(final Scanner scanner) {
        String[] inputArrayWireOne = scanner.next().split(",");
        String[] inputArrayWireTwo = scanner.next().split(",");
        List<Position<Integer, Integer>> wireOneCoordinates = calculatePath(inputArrayWireOne);
        List<Position<Integer, Integer>> wireTwoCoordinates = calculatePath(inputArrayWireTwo);

        wireOneCoordinates.retainAll(wireTwoCoordinates);
        wireOneCoordinates.remove(0);
        return Collections.min(getManhattanDistanceFromCollection(wireOneCoordinates));
    }

    static int getPartTwoResult(final Scanner scanner) {
        String[] inputArrayWireOne = scanner.next().split(",");
        String[] inputArrayWireTwo = scanner.next().split(",");
        List<Position<Integer, Integer>> wireOneCoordinates = calculatePath(inputArrayWireOne);
        List<Position<Integer, Integer>> wireTwoCoordinates = calculatePath(inputArrayWireTwo);

        List<Position<Integer, Integer>> intersections = new ArrayList<>(wireOneCoordinates);
        intersections.retainAll(wireTwoCoordinates);
        intersections.remove(0);

        List<Integer> results = new ArrayList<>();
        for (Position<Integer, Integer> intersection : intersections){
            results.add(wireOneCoordinates.indexOf(intersection) + wireTwoCoordinates.indexOf(intersection));
        }

        return Collections.min(results);
    }

    private static List<Position<Integer, Integer>> calculatePath(String[] inputArray) {
        List<Position<Integer, Integer>> wireCoordinates = new ArrayList<>();
        String direction;
        int distance;
        int currentX = 0;
        int currentY = 0;

        for (String instruction : inputArray) {
            direction = instruction.substring(0, 1);
            distance = Integer.parseInt(instruction.substring(1));

            if (direction.equals("L")) {
                for (int x = currentX; x>currentX-distance; x--){
                    wireCoordinates.add(new Position<>(x, currentY));
                }
                currentX -= distance;
            } else if (direction.equals("R")) {
                for (int x = currentX; x<currentX+distance; x++){
                    wireCoordinates.add(new Position<>(x, currentY));
                }
                currentX += distance;
            } else if (direction.equals("U")) {
                for (int y = currentY; y<currentY+distance; y++){
                    wireCoordinates.add(new Position<>(currentX, y));
                }
                currentY += distance;
            } else if (direction.equals("D")) {
                for (int y = currentY; y>currentY-distance; y--){
                    wireCoordinates.add(new Position<>(currentX, y));
                }
                currentY -= distance;
            } else {
                log.warning("Direction string not correct. Please check the input.");
            }

        }
        return wireCoordinates;
    }

    static int getManhattanDistance(Position<Integer, Integer> coordinates){
        return Math.abs(coordinates.getHorizontal()) + Math.abs(coordinates.getVertical());
    }

    private static List<Integer> getManhattanDistanceFromCollection(List<Position<Integer, Integer>> intersections){
        List<Integer> resultList = new ArrayList<>();
        for (Position<Integer,Integer> coord : intersections){
            resultList.add(CrossedWires.getManhattanDistance(coord));
        }
        return resultList;
    }


}
