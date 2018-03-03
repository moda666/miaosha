package top.adxiang.miaosha.rabbitmq;

import top.adxiang.miaosha.domain.User;

/**
 * @author MaWenXiang
 * @date 2018/3/1
 */
public class MiaoshaMessage {
    private User user;
    private long goodsId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }
}
