#include <jni.h>
#include <stdio.h>
#include "NumberTest.h"

JNIEXPORT jdouble JNICALL Java_NumberTest_calculateAverage(JNIEnv *env, jobject thisObj,
     jint number1, jint number2) {
     jdouble result;
     result = ((jdouble) number1 + number2) / 2.0;
     return result;
}
