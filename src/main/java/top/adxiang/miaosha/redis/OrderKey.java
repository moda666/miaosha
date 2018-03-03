package top.adxiang.miaosha.redis;

/**
 * @author MaWenXiang
 * @date 2018/2/24
 */
public class OrderKey extends BasePrefix {

    private OrderKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static OrderKey getMiaoshaOrderByUidGid = new OrderKey(0, "moug");
}
