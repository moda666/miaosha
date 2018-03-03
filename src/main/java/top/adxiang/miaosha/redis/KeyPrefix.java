package top.adxiang.miaosha.redis;

/**
 * @author MaWenXiang
 * @date 2018/2/24
 */
public interface KeyPrefix {

    /**
     * 过期时间
     * @return
     */
    int expireSeconds();

    /**
     * 获取前缀
     * @return
     */
    String getPrefix();

}
