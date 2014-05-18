#include <jni.h>
#include <stdio.h>
#include "StringTest.h"

JNIEXPORT jstring JNICALL Java_StringTest_printAndReturnInput(JNIEnv *env, jobject thisObj,
     jstring inputJString) {
     // Converting the JNI String (jstring) into a C-String (char*)
     const char *inputCString = (*env)->GetStringUTFChars(env, inputJString, NULL);
     if (NULL == inputCString) {
       return NULL;
     }

     printf("Input string: %s\n", inputCString);
     // Releasing resources
     (*env)->ReleaseStringUTFChars(env, inputJString, inputCString);

     // Prompting user for input
     char outputString[128];
     printf("Enter string: ");
     scanf("%s", outputString);

     // Converting the C-string (char*) into a JNI String (jstring)
     return (*env)->NewStringUTF(env, outputString);
}
