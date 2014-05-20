public class NumberTest {

  static {
    System.load(getLibraryPath());
  }

  // Native method declaration (method with two integer parameters and returns double)
  private native double calculateAverage(int number1, int number2);

  public static void main(String[] args) {
    System.out.println("The average is: " + new NumberTest().calculateAverage(10, 50));
  }

  private static String getLibraryPath() {
    return HelloWorldJNI.class.getClassLoader().getResource("NumberTest.dll").getPath();
  }
}
