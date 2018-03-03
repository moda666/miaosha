package top.adxiang.miaosha.vo;


import top.adxiang.miaosha.domain.OrderInfo;

/**
 * @author MaWenXiang
 * @date 2018/2/28
 */
public class OrderDetailVo {
    private GoodsVo goods;
    private OrderInfo order;

    public GoodsVo getGoods() {
        return goods;
    }

    public void setGoods(GoodsVo goods) {
        this.goods = goods;
    }

    public OrderInfo getOrder() {
        return order;
    }

    public void setOrder(OrderInfo order) {
        this.order = order;
    }
}
