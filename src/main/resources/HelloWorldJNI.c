#include <jni.h>
#include <stdio.h>
#include "HelloWorldJNI.h"

JNIEXPORT void JNICALL Java_HelloWorldJNI_printHelloWorld(JNIEnv *env, jobject thisObj) {
     printf("Hello World!\n");
     return;
}
