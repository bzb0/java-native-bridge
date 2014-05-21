public class MethodCallTest {

  static {
    System.load(getLibraryPath());
  }

  private native void invokeMethods();

  private int powerOfTwo(int number) {
    return number * number;
  }

  private static String getHelloWorld() {
    return "Hello World!";
  }

  public static void main(String[] args) {
    new MethodCallTest().invokeMethods();
  }

  private static String getLibraryPath() {
    return HelloWorldJNI.class.getClassLoader().getResource("MethodCallTest.dll").getPath();
  }
}
