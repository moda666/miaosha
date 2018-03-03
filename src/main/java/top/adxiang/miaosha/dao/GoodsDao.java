package top.adxiang.miaosha.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.adxiang.miaosha.domain.MiaoshaGoods;
import top.adxiang.miaosha.vo.GoodsVo;

import java.util.List;

/**
 * @author MaWenXiang
 * @date 2018/2/25
 */
@Mapper
public interface GoodsDao {

    /**
     * 查询所有商品
     *
     * @return
     */
    @Select("SELECT g.*, mg.stock_count, mg.start_date, mg.end_date, mg.miaosha_price FROM miaosha_goods mg LEFT JOIN goods g ON mg.goods_id = g.id")
    List<GoodsVo> listGoodsVo();

    /**
     * 通过id查询商品信息
     *
     * @param goodsId
     * @return
     */
    @Select("SELECT g.*, mg.stock_count, mg.start_date, mg.end_date, mg.miaosha_price FROM miaosha_goods mg LEFT JOIN goods g ON mg.goods_id = g.id WHERE g.id = #{goodsId}")
    GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

    /**
     * 将商品库存减1
     *
     * @param g
     * @return
     */
    @Update("UPDATE miaosha_goods SET stock_count = stock_count - 1 WHERE goods_id = #{goodsId} and stock_count > 0")
    int reduceStock(MiaoshaGoods g);



    @Update("update miaosha_goods set stock_count = #{stockCount} where goods_id = #{goodsId}")
    public int resetStock(MiaoshaGoods g);
}
