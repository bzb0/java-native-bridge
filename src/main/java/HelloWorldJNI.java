public class HelloWorldJNI {
	
	static {
		// Loading HelloWorldJNI library (HelloWorldJNI.dll (Windows) / libhelloworldjni.so (Unix))
		System.load(getLibraryPath());
	}

	// Native method declaration
	private native void printHelloWorld();

	public static void main(String[] args) {
		 // Native method invocation
		 new HelloWorldJNI().printHelloWorld();
	}

	private static String getLibraryPath() {
		return HelloWorldJNI.class.getClassLoader().getResource("HelloWorldJNI.dll").getPath();
	}
}
