import java.util.Scanner;

public class ExampleException {

  public static int rectangleArea(int a, int b) throws IllegalArgumentException {
    if ( a < 0 || b < 0 ) throw new IllegalArgumentException("input value is below zero!");

    return a * b;
  }
}