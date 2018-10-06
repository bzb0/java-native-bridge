# Java Native Bridge

### Description

This project demonstrates the usage of various Java libraries/technologies for calling native code/libraries. The code examples are using JNI (Java
Native Interface), [JNA](https://github.com/java-native-access/jna) (Java Native Access). For compiling and building the C source code gcc and make (
MinGW) was used. The project tech stack is:

```
  Java                    7
  Maven                   3.2.1
  JNA                     4.1.0
  MinGW (gcc, make)       6.6
  Microsoft Windows       7
```

### Building the project

The example Java classes in the project can be compiled with the following Maven command:

```
mvn clean compile
```

### JNI

Most of the examples in the project use JNI in order to call native libraries. The C source code files and the ``makefile`` are located
under ``src/main/resources``. The following Java classes demonstrate the usage of JNI:

``src/main/java``<br/>
├─── HelloWorldJNI<br/>
├─── MemberFieldTest<br/>
├─── MethodCallTest<br/>
├─── NumberTest<br/>
├─── PrimitiveArrayTest<br/>
└─── StringTest

### JNA

The project also contains several examples that use JNA. JNA enables direct Java calls to native code without using JNI. The example classes are
located in the package ``com.bzb.jna``.
