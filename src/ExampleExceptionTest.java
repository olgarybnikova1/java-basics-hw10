import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class
ExampleExceptionTest {

  /**
   * Test data for positive test.
   *
   * @return test data array
   */
  @DataProvider(name = "data")
  public static Object[][] data() {
    return new Object[][]{
        {2, 2, 4},
        {2, 3, 6},
        {7, 7, 49},
        {0, 2, 0}
    };
  }

  /**
   * Test data for exception test.
   *
   * @return test data array
   */
  @DataProvider(name = "negativeData")
  public static Object[][] negativeData() {
    return new Object[][]{
        {-2, 2},
        {2, -2},
        {-3, -3},
        {1, -1}
    };
  }

  @Test(dataProvider = "data")
  public void testRectangleArea(int a, int b, int c) {
    int actualResult = ExampleException.rectangleArea(a, b);
    assertEquals(actualResult, c, "actualResult is incorrect");
  }
  
  @Test(dataProvider = "negativeData")
  public void testRectangleAreaNegative(int a, int b) {
    String expectedMessage = "input value is below zero!";
    String actualMessage = new String();

    try {
      ExampleException.rectangleArea(a, b);
    } catch (IllegalArgumentException exception) {
      actualMessage = exception.getMessage();
    }
    assertEquals(actualMessage, expectedMessage);
  }
}