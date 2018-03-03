package top.adxiang.miaosha.redis;

import top.adxiang.miaosha.domain.MiaoshaOrder;

/**
 * @author MaWenXiang
 * @date 2018/3/1
 */
public class MiaoshaKey extends BasePrefix {

    private static final int EXPIRE = 300;

    public MiaoshaKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static MiaoshaKey isGoodsOver = new MiaoshaKey(0, "go");
    public static MiaoshaKey getMiaoshaPath = new MiaoshaKey(EXPIRE, "mp");
    public static MiaoshaKey getMiaoshaVerifyCode = new MiaoshaKey(EXPIRE, "vc");

}
