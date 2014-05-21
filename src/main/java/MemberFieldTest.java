public class MemberFieldTest {

  private String name = "Member Field Test";

  static {
    System.load(getLibraryPath());
  }

  // Native method declaration
  private native void modifyNameField();

  public static void main(String[] args) {
    MemberFieldTest test = new MemberFieldTest();
    test.modifyNameField();
    System.out.println("The new value of the field 'name' is: " + test.name);
  }

  private static String getLibraryPath() {
    return HelloWorldJNI.class.getClassLoader().getResource("MemberFieldTest.dll").getPath();
  }
}
