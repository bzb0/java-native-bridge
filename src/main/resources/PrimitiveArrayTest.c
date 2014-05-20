#include <jni.h>
#include <stdio.h>
#include "PrimitiveArrayTest.h"

JNIEXPORT jint JNICALL Java_PrimitiveArrayTest_calculateArraySum(JNIEnv *env,
    jobject thisObj, jintArray inputJniArray) {
    // Converting JNI jintArray to C jint[]
    jint* inputCArray = (*env)->GetIntArrayElements(env, inputJniArray, NULL);
    if (NULL == inputCArray) {
      return (jint) NULL;
    }

    // Calculating the sum
    int i;
    jint sum = 0;
    jsize length = (*env)->GetArrayLength(env, inputJniArray);
    for (i = 0; i < length; i++) {
      sum += inputCArray[i];
    }
    // Releasing resources
    (*env)->ReleaseIntArrayElements(env, inputJniArray, inputCArray, 0);

    return (jint) sum;
}
