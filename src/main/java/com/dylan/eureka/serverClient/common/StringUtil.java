package com.dylan.eureka.serverClient.common;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 12:03 2019/2/20
 * @Modified By:
 */
public class StringUtil {

    private static SnowflakeCommon idWorker = new SnowflakeCommon(0, 0);

    public static String UUID32(){
        Long id = idWorker.nextId();
        System.out.println(id);
        System.out.println(id.toString().length());
        return id.toString();
    }

}
