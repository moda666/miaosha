package top.adxiang.miaosha.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.adxiang.miaosha.domain.MiaoshaOrder;
import top.adxiang.miaosha.domain.User;
import top.adxiang.miaosha.redis.RedisService;
import top.adxiang.miaosha.result.CodeMsg;
import top.adxiang.miaosha.result.Result;
import top.adxiang.miaosha.service.GoodsService;
import top.adxiang.miaosha.service.MiaoshaService;
import top.adxiang.miaosha.service.OrderService;
import top.adxiang.miaosha.util.JSONUtil;
import top.adxiang.miaosha.vo.GoodsVo;

/**
 * @author MaWenXiang
 * @date 2018/2/28
 */
@Service
public class MQReceiver {

    private static final Logger logger = LoggerFactory.getLogger(MQReceiver.class);

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoshaService miaoshaService;


    @RabbitListener(queues = MQConfig.MIAOSHA_QUEUE)
    public void receive(String message) {
        logger.info("receive message：" + message);
        MiaoshaMessage message1 = JSONUtil.stringToBean(message, MiaoshaMessage.class);
        User user = message1.getUser();
        long goodsId = message1.getGoodsId();

        //获取商品信息
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);


        int stock = goods.getStockCount();
        if(stock <= 0) {
            return;
        }

        //判断是否已经秒杀到了
        MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(), goodsId);
        if(order != null) {
            return;
        }

        //减库存 下订单 写入秒杀订单
        miaoshaService.miaosha(user, goods);
    }



//    @RabbitListener(queues = MQConfig.QUEUE)
//    public void receive(String message) {
//        logger.info("receive message：" + message);
//    }


   /* @RabbitListener(queues = MQConfig.QUEUE)
    public void receive(String message) {
        logger.info("receive message：" + message);
    }

    @RabbitListener(queues = MQConfig.TOPIC_QUEUE1)
    public void receiveTopic1(String message) {
        logger.info("topic queue1 message：" + message);
    }

    @RabbitListener(queues = MQConfig.TOPIC_QUEUE2)
    public void receiveTopic2(String message) {
        logger.info("topic queue2 message：" + message);
    }

    @RabbitListener(queues = MQConfig.HEADERS_QUEUE)
    public void receiveHeaders(byte[] message) {
        logger.info("headers queue message：" + new String(message));
    }*/

}
