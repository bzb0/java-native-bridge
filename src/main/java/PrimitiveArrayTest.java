public class PrimitiveArrayTest {

  static {
    System.load(getLibraryPath());
  }

  // Native method declaration (method that has a single array of integers as input parameter and returns double)
  private native int calculateArraySum(int[] numbers);

  public static void main(String[] args) {
    System.out.println("The array sum is: " + new PrimitiveArrayTest().calculateArraySum(new int[]{10, 20, 30}));
  }

  private static String getLibraryPath() {
    return HelloWorldJNI.class.getClassLoader().getResource("PrimitiveArrayTest.dll").getPath();
  }
}
