package top.adxiang.miaosha.redis;

/**
 * @author MaWenXiang
 * @date 2018/3/1
 */
public class AccessKey extends BasePrefix {

    public AccessKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static AccessKey withExpire(int expireSeconds) {
        return new AccessKey(expireSeconds, "access");
    }
}
