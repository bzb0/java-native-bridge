#include <jni.h>
#include <stdio.h>
#include "MethodCallTest.h"

JNIEXPORT void JNICALL Java_MethodCallTest_invokeMethods(JNIEnv *env, jobject thisObj) {
    // Fetching the class of the input object
    jclass clazz = (*env)->GetObjectClass(env, thisObj);

    // Getting the id of the method with the signature 'int powerOfTwo(int)'
    jmethodID powerOfTwoId = (*env)->GetMethodID(env, clazz, "powerOfTwo", "(I)I");
    if (NULL == powerOfTwoId) {
      return;
    }
    // Calling the method on 'thisObj' object
    jint result = (*env)->CallIntMethod(env, thisObj, powerOfTwoId, 10);
    printf("10 to the power of two: %d\n", result);


    // Getting the id of the static method with the signature 'String getHelloWorld()'
    jmethodID helloWorldId = (*env)->GetStaticMethodID(env, clazz, "getHelloWorld", "()Ljava/lang/String;");
    if (NULL == helloWorldId) {
      return;
    }

    // Calling the static method on the class object
    jstring helloWorldJString = (*env)->CallStaticObjectMethod(env, clazz, helloWorldId);
    const char *helloWorldCString = (*env)->GetStringUTFChars(env, helloWorldJString, NULL);
    if (NULL == helloWorldCString) {
      return;
    }
    printf("The static method output is: %s\n", helloWorldCString);

    // Releasing resources
    (*env)->ReleaseStringUTFChars(env, helloWorldJString, helloWorldCString);
}
