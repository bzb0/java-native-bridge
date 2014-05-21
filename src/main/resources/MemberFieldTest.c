#include <jni.h>
#include <stdio.h>
#include "MemberFieldTest.h"

JNIEXPORT void JNICALL Java_MemberFieldTest_modifyNameField(JNIEnv *env, jobject thisObject) {
    // Fetching the class of the input object
    jclass clazz = (*env)->GetObjectClass(env, thisObject);

    // Getting the field id of the string member "name"
    jfieldID fieldId = (*env)->GetFieldID(env, clazz, "name", "Ljava/lang/String;");
    if (NULL == fieldId) {
      return;
    }

    // Fetching "name" field as string from the input object
    jstring nameJString = (*env)->GetObjectField(env, thisObject, fieldId);

    // Converting the JNI String (jstring) to a C-String (char*)
    const char *nameCString = (*env)->GetStringUTFChars(env, nameJString, NULL);
    if (NULL == nameCString) {
      return;
    }

    printf("The member 'name' has value: %s\n", nameCString);
    // Releasing resources
    (*env)->ReleaseStringUTFChars(env, nameJString, nameCString);

    // Creating a new UTF string and assigning it to the nameJString variable
    nameJString = (*env)->NewStringUTF(env, "New Name");
    if (NULL == nameJString) {
      return;
    }

    // Modifying the member field
    (*env)->SetObjectField(env, thisObject, fieldId, nameJString);
}
