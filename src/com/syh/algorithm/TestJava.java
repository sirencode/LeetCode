package com.syh.algorithm;

import java.util.ArrayList;

/**
 * Author: shenyonghe
 * Date: 2/19/21
 * Version: v1.0
 * Description:
 * Modification History:
 * Date Author Version Description
 * ------------------------------------
 * 2/19/21 shenyonghe v1.0
 * Why & What is modified:
 **/
class TestJava {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer
        try {
            list.getClass().getMethod("add", Object.class).invoke(list, "asd");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
