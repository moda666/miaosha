package top.adxiang.miaosha.access;

import top.adxiang.miaosha.domain.User;

/**
 * @author MaWenXiang
 * @date 2018/3/1
 */
public class UserContext {

    private static ThreadLocal<User> userHolder = new ThreadLocal<User>();

    public static void setUser(User user) {
        userHolder.set(user);
    }

    public static User getUser() {
        return userHolder.get();
    }
}
