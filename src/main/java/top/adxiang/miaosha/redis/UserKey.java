package top.adxiang.miaosha.redis;

/**
 * @author MaWenXiang
 * @date 2018/2/24
 */
public class UserKey extends BasePrefix {

    private static final int EXPIRE = 3600 * 24 * 2;

    private UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static UserKey token = new UserKey(EXPIRE, "tk");
    public static UserKey getById = new UserKey(0, "id");
}
