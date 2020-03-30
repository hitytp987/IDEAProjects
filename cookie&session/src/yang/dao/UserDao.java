package yang.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import yang.domain.User;
import yang.utils.JDBCUtils;

/**
 * 操作用户表的类
 * @author yang
 * @create 2020-03-22 23:11
 */
public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser
     * @return 有值返回user，没有值返回null
     */
    public User login(User loginUser){
        try {
            //1、创建sql语句
            String sql = "select * from user where name=? and password=? ";
            //2、调用query方法
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getName(), loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
