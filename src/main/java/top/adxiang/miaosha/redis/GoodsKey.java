package top.adxiang.miaosha.redis;

/**
 * @author MaWenXiang
 * @date 2018/2/27
 */
public class GoodsKey extends BasePrefix {

    private static final int EXPIRE = 60;

    private GoodsKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static GoodsKey getGoodsList = new GoodsKey(EXPIRE, "gl");
    public static GoodsKey getGoodsDetail = new GoodsKey(EXPIRE, "gd");
    public static GoodsKey getMiaoshaGoodsStock = new GoodsKey(0, "gs");
}
