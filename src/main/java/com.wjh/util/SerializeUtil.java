package com.wjh.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:   17976
 * Date:     2019/2/26 19:07
 * Description: 序列化工具类
 */
public class SerializeUtil {
    public static byte[] serializeListObject(List<?> object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            //oos.writeObject(object);
            for(Object obj : object){
                oos.writeObject(obj);
            }
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {

        }
        return null;
    }

    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {

        }
        return null;
    }

    public static Object unserialize( byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {

        }
        return null;
    }


    public static List<Object> deserialize(byte[] in) {
        List<Object> list = new ArrayList();
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if(in != null) {
                bis=new ByteArrayInputStream(in);
                is=new ObjectInputStream(bis);
                while (true) {
                    Object obj=(Object) is.readObject();

                    if(obj == null){
                        break;
                    }else{
                        list.add(obj);
                    }
                }
                is.close();
                bis.close();
            }
        } catch (IOException e) {

        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
        return list;
    }


}
