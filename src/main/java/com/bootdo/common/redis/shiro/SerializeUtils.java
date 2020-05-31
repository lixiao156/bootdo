package com.bootdo.common.redis.shiro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huamu.com
 * @version V1.0
 */
public class SerializeUtils {

    private static Logger logger = LoggerFactory.getLogger(SerializeUtils.class);

    /**
     * 反序列化
     * @param bytes
     * @return
     */
    public static Object deserialize(byte[] bytes) {

        Object result = null;

        if (isEmpty(bytes)) {
            return null;
        }

        try {
            // 磁盘到内存中 就是 in
            ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
            try {
                // 对象输入流
                ObjectInputStream objectInputStream = new ObjectInputStream(byteStream);
                try {
                    result = objectInputStream.readObject();
                }
                catch (ClassNotFoundException ex) {
                    throw new Exception("Failed to deserialize object type", ex);
                }
            }
            catch (Throwable ex) {
                throw new Exception("Failed to deserialize", ex);
            }
        } catch (Exception e) {
            logger.error("Failed to deserialize",e);
        }
        return result;
    }

    public static boolean isEmpty(byte[] data) {
        return (data == null || data.length == 0);
    }

    /**
     * 序列化 将对象转化为字节数组
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {

        byte[] result = null;

        if (object == null) {
            return new byte[0];
        }
        try {
            // 数组的大小只有 128
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream(128);
            try  {
                // 如果对象不是可序列化的
                if (!(object instanceof Serializable)) {
                    throw new IllegalArgumentException(SerializeUtils.class.getSimpleName() + " requires a Serializable payload " +
                            "but received an object of type [" + object.getClass().getName() + "]");
                }
                // 序列化到设置一个数组对象
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteStream);
                // 将对象序列化到数组
                objectOutputStream.writeObject(object);
                // 强制将内存中的信息强制刷入目的地
                objectOutputStream.flush();
                // 将数组流中的信息转化为字节数组
                result =  byteStream.toByteArray();
            }
            catch (Throwable ex) {
                throw new Exception("Failed to serialize", ex);
            }
        } catch (Exception ex) {
            logger.error("Failed to serialize",ex);
        }
        return result;
    }
}