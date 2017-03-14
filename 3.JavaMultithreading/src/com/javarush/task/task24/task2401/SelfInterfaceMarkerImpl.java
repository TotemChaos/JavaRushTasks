package com.javarush.task.task24.task2401;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    public void print() {
        System.out.println("SelfInterfaceMarkerImpl");
    }
    public void getNameClazz()  {
        System.out.println(this.getClass());
    }
}
