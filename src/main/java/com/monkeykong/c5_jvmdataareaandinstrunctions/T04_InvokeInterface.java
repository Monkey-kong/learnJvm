package com.monkeykong.c5_jvmdataareaandinstrunctions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alvin
 * @date 2020-07-19 19:55
 */
public class T04_InvokeInterface {
    public static void main(String[] args) {
        // InvokeInterface
        List<String> list = new ArrayList<>();
        list.add("hello");

        // InvokeVirtual
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hello");
    }
}
