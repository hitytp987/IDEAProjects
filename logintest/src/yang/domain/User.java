package yang.domain;

/**
 * @author yang
 * @create 2020-03-22 23:06
 *
 * 用户实体类
 */
public class User {
    /**
     * 用户ID
     */
    private int id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户密码
     */
    private String password;

    public User() {
    }

//    public User(int id, String name, String password) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
