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

####################################################################################

all_StringTest : StringTest.dll

StringTest.dll : StringTest.o
	gcc -Wl,--add-stdcall-alias -shared -o $@ $<

StringTest.o : StringTest.c StringTest.h
	gcc -I"C:\Program Files (x86)\Java\jdk1.7.0_40\include" -I"C:\Program Files (x86)\Java\jdk1.7.0_40\include\win32" -c $< -o $@

StringTest.h : StringTest.class
	javah -classpath $(CLASS_PATH) $*

clean_StringTest :
	del /f StringTest.h StringTest.o StringTest.dll

####################################################################################

all_NumberTest : NumberTest.dll

NumberTest.dll : NumberTest.o
	gcc -Wl,--add-stdcall-alias -shared -o $@ $<

NumberTest.o : NumberTest.c NumberTest.h
	gcc -I"C:\Program Files (x86)\Java\jdk1.7.0_40\include" -I"C:\Program Files (x86)\Java\jdk1.7.0_40\include\win32" -c $< -o $@

NumberTest.h : NumberTest.class
	javah -classpath $(CLASS_PATH) $*

clean_NumberTest :
	del /f NumberTest.h NumberTest.o NumberTest.dll

####################################################################################

all_PrimitiveArrayTest : PrimitiveArrayTest.dll

PrimitiveArrayTest.dll : PrimitiveArrayTest.o
	gcc -Wl,--add-stdcall-alias -shared -o $@ $<

PrimitiveArrayTest.o : PrimitiveArrayTest.c PrimitiveArrayTest.h
	gcc -I"C:\Program Files (x86)\Java\jdk1.7.0_40\include" -I"C:\Program Files (x86)\Java\jdk1.7.0_40\include\win32" -c $< -o $@

PrimitiveArrayTest.h : PrimitiveArrayTest.class
	javah -classpath $(CLASS_PATH) $*

clean_PrimitiveArrayTest :
	del /f PrimitiveArrayTest.h PrimitiveArrayTest.o PrimitiveArrayTest.dll
