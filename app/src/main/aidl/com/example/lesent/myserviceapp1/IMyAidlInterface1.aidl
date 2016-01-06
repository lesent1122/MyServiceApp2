// IMyAidlInterface1.aidl
package com.example.lesent.myserviceapp1;

// Declare any non-default types here with import statements

interface IMyAidlInterface1 {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    void setData(String str);
    MyService1 getMyService();
}
