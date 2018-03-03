package top.adxiang.miaosha.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.adxiang.miaosha.domain.User;

/**
 * @author MaWenXiang
 * @date 2018/2/24
 */
@Mapper
public interface UserDao {

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    @Select("select * from miaosha_user where id = #{id}")
    User getById(@Param("id") long id);
}
