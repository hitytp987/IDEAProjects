package yang.test;

import org.junit.Test;
import yang.dao.UserDao;
import yang.domain.User;

/**
 * @author yang
 * @create 2020-03-23 0:00
 */
public class UserTest {


    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setName("yang");
        loginuser.setPassword("123");

        UserDao userDao = new UserDao();
        User login = userDao.login(loginuser);
        System.out.println(login);

    }

}
