import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import Structures.Position;

public class CalculatePathTest {

    @Test
    public void calculateSampleManhattanDistance(){
        String sampleInput = "R75,D30,R83,U83,L12,D49,R71,U7,L72\n" +
                "U62,R66,U55,R34,D71,R55,D58,R83";
        Scanner scanner = new Scanner(sampleInput);

        assert scanner != null;
        String[] inputArrayWireOne = scanner.next().split(",");
        String[] inputArrayWireTwo = scanner.next().split(",");
        List<Position<Integer, Integer>> wireOneCoordinates = CrossedWires.calculatePath(inputArrayWireOne);
        List<Position<Integer, Integer>> wireTwoCoordinates = CrossedWires.calculatePath(inputArrayWireTwo);

    }
}
