package edu.onlinestock.tools;

import java.lang.reflect.Field;

/**
 * Created by kylin on 04/12/2016.
 * All rights reserved.
 */
public class CheckClass {

    private static final String modelPath = "edu.nju.model.";

    public static void checkObject(String className, Object object) {
        //使用反射技术完成对象属性的输出
        Class<?> aClass = null;
        try {
            aClass = Class.forName(modelPath+className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field [] fields = aClass.getDeclaredFields();

        //输出p1的所有属性
        for(Field field1:fields){
            field1.setAccessible(true);
            //取出属性名称
            String field = field1.toString().substring(field1.toString().lastIndexOf(".")+1);
            try {
                System.out.print(field+" --> ");
                System.out.println(field1.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
