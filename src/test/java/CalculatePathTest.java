import java.util.Scanner;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Structures.Position;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatePathTest {

    @Test
    public void partOneSampleTest(){
        String sampleInput = "R8,U5,L5,D3\n" +
                "U7,R6,D4,L4";
        Scanner scanner = new Scanner(sampleInput);
        int result = CrossedWires.getPartOneResult(scanner);
        assertEquals(result, 6);
    }

    @Test
    public void partOneSample2Test(){
        String sampleInput = "R75,D30,R83,U83,L12,D49,R71,U7,L72\n" +
                "U62,R66,U55,R34,D71,R55,D58,R83";
        Scanner scanner = new Scanner(sampleInput);
        int result = CrossedWires.getPartOneResult(scanner);
        assertEquals(result, 159);
    }

    @Test
    public void partOneSample3Test(){
        String sampleInput = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\n" +
                "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7";
        Scanner scanner = new Scanner(sampleInput);
        int result = CrossedWires.getPartOneResult(scanner);
        assertEquals(result, 135);

    }

    @Test
    public void calculateManhattanDistanceTest(){
        Assertions.assertEquals(CrossedWires.getManhattanDistance(new Position<>(-2,-3)), 5);
        Assertions.assertEquals(CrossedWires.getManhattanDistance(new Position<>(2,-3)), 5);
        Assertions.assertEquals(CrossedWires.getManhattanDistance(new Position<>(-2,3)), 5);
        Assertions.assertEquals(CrossedWires.getManhattanDistance(new Position<>(2,3)), 5);
    }
}
