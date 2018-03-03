package top.adxiang.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.adxiang.miaosha.domain.OrderInfo;
import top.adxiang.miaosha.domain.User;
import top.adxiang.miaosha.result.CodeMsg;
import top.adxiang.miaosha.result.Result;
import top.adxiang.miaosha.service.GoodsService;
import top.adxiang.miaosha.service.OrderService;
import top.adxiang.miaosha.vo.GoodsVo;
import top.adxiang.miaosha.vo.OrderDetailVo;

/**
 * @author MaWenXiang
 * @date 2018/2/28
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/detail")
    @ResponseBody
    public Result<OrderDetailVo> orderDetail(Model model, User user, @RequestParam("orderId") long orderId) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        OrderInfo order = orderService.getOrderById(orderId);
        if (order == null) {
            return Result.error(CodeMsg.ORDER_NOT_EXIST);
        }
        long goodsId = order.getGoodsId();
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        OrderDetailVo vo = new OrderDetailVo();
        vo.setOrder(order);
        vo.setGoods(goods);
        return Result.success(vo);
    }

}
