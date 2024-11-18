package dao;


import beans.User;
import cn.hutool.crypto.digest.DigestUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JDBCUtils;

public class UserDao {
    public User login(User user) {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        User existUser = null;
        try {
            existUser = qr.query("SELECT * FROM `user` WHERE `username`=? AND `password`=?",
                    new BeanHandler<>(User.class),
                    user.getUsername(),    DigestUtil.md5Hex(user.getPassword())   );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return existUser;
    }
}
