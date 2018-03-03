package top.adxiang.miaosha.dao;

import org.apache.ibatis.annotations.*;
import top.adxiang.miaosha.domain.MiaoshaOrder;
import top.adxiang.miaosha.domain.OrderInfo;

/**
 * @author MaWenXiang
 * @date 2018/2/26
 */
@Mapper
public interface OrderDao {

    @Select("SELECT * FROM miaosha_order WHERE user_id=#{userId} AND goods_id=#{goodsId}")
    MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(@Param("userId") long userId, @Param("goodsId") long goodsId);

    @Insert("INSERT INTO order_info(user_id, goods_id, goods_name, goods_count, goods_price, order_channel, status, create_date)VALUES("
            + "#{userId}, #{goodsId}, #{goodsName}, #{goodsCount}, #{goodsPrice}, #{orderChannel},#{status},#{createDate} )")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = long.class, before = false, statement = "SELECT last_insert_id()")
    long insert(OrderInfo orderInfo);

    @Insert("INSERT INTO miaosha_order (user_id, order_id, goods_id)VALUES(#{userId}, #{orderId}, #{goodsId})")
    int insertMiaoshaOrder(MiaoshaOrder miaoshaOrder);

    @Select("SELECT * FROM order_info WHERE id=#{orderId}")
    OrderInfo getOrderById(@Param("orderId") long orderId);



    @Delete("delete from order_info")
    void deleteOrders();

    @Delete("delete from miaosha_order")
    void deleteMiaoshaOrders();
}
