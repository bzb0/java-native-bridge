# Define a variable for classpath
CLASS_PATH = ../../../target/classes

# Define a virtual path for .class in the bin directory
vpath %.class $(CLASS_PATH)

####################################################################################

all_HelloWorldJNI : HelloWorldJNI.dll

# $@ matches the target, $< matches the first dependency
HelloWorldJNI.dll : HelloWorldJNI.o
	gcc -Wl,--add-stdcall-alias -shared -o $@ $<

HelloWorldJNI.o : HelloWorldJNI.c HelloWorldJNI.h
	gcc -I"C:\Program Files (x86)\Java\jdk1.7.0_40\include" -I"C:\Program Files (x86)\Java\jdk1.7.0_40\include\win32" -c $< -o $@

# $* matches the target filename without the extension
HelloWorldJNI.h : HelloWorldJNI.class
	javah -classpath $(CLASS_PATH) $*

clean_HelloWorldJNI :
	del /f HelloWorldJNI.h HelloWorldJNI.o HelloWorldJNI.dll
