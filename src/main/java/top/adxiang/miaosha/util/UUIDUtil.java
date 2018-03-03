package top.adxiang.miaosha.util;

import java.util.UUID;

/**
 * @author MaWenXiang
 * @date 2018/2/25
 */
public class UUIDUtil {

    public static String uuid() {
        //去掉横杠
        return UUID.randomUUID().toString().replace("-", "");
    }


}
