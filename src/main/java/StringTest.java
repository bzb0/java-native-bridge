public class StringTest {

  static {
    System.load(getLibraryPath());
  }

  // Native method declaration (method that has a single string parameter and returns a string)
  private native String printAndReturnInput(String input);

  public static void main(String[] args) {
    String result = new StringTest().printAndReturnInput("Test1234");
    System.out.println("The native method output is: " + result);
  }

  private static String getLibraryPath() {
    return HelloWorldJNI.class.getClassLoader().getResource("StringTest.dll").getPath();
  }
}
