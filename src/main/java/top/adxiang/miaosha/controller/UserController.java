package top.adxiang.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.adxiang.miaosha.domain.User;
import top.adxiang.miaosha.rabbitmq.MQReceiver;
import top.adxiang.miaosha.rabbitmq.MQSender;
import top.adxiang.miaosha.rabbitmq.MiaoshaMessage;
import top.adxiang.miaosha.redis.MiaoshaKey;
import top.adxiang.miaosha.redis.OrderKey;
import top.adxiang.miaosha.redis.RedisService;
import top.adxiang.miaosha.result.Result;

import java.util.Set;

/**
 * @author MaWenXiang
 * @date 2018/2/26
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    RedisService redisService;

    @Autowired
    MQSender mqSender;


    @RequestMapping("/info")
    @ResponseBody
    public Result<User> info(User user) {
        redisService.set(MiaoshaKey.isGoodsOver, "", true);
        return Result.success(user);
    }

//    @RequestMapping("/mq")
//    @ResponseBody
//    public Result<String> mq(User user) {
//        MiaoshaMessage message = new MiaoshaMessage();
//        message.setUser(user);
//        message.setGoodsId(1);
//        mqSender.sendMiaoshaMessage(message);
//        return Result.success("nihao");
//    }

    /*@RequestMapping("/mq/topic")
    @ResponseBody
    public Result<String> topic() {
        mqSender.sendTopic("hello topic");
        return Result.success("nihao aa");
    }

    @RequestMapping("/mq/fanout")
    @ResponseBody
    public Result<String> fanout() {
        mqSender.sendFanout("hello fanout");
        return Result.success("nihao fanout");
    }

    @RequestMapping("/mq/headers")
    @ResponseBody
    public Result<String> headers() {
        mqSender.sendHeaders("hello headers");
        return Result.success("nihao headers");
    }*/

    /*@RequestMapping("/list")
    @ResponseBody
    public Result<String> list() {
        Set<String> keys = redisService.keys("Order*");
        for (String key : keys) {
            System.out.println(redisService.delete(key));
        }
        return Result.success("成功");
    }*/
}
