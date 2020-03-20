package yang.bean;

import java.util.ArrayList;
import java.util.Arrays;

//测试单行注释
public class Customer {
    private String name;

    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i);
//        }
        System.out.println("args = " + Arrays.deepToString(args));
        new Customer().doThing("yang");
    }

    public void doThing(String name) {
        //soup带参数名的sout
        System.out.println("name = " + name);
        //soutm带方法名的sout
        System.out.println("Customer.doThing");

        //soutv输出参数信息
        int num = 1;
        System.out.println("num = " + num);

        //num.soutv
        System.out.println("num = " + num);

        String[] strs = new String[]{"A","B","C","D"};
        for (int i = 0; i < strs.length; i++) {
            System.out.println("i = " + i);
        }
        //iter
        for (String str : strs) {
            System.out.println(str);
        }
        //itar
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

        }

        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);
        //list.for
        for (Object o : list) {
            
        }
        //list.fori  小->大
        for (int i = 0; i < list.size(); i++) {

        }
        //list.forr  大->小
        for (int i = list.size() - 1; i >= 0; i--) {

        }
        //ifn  /  list.null
        if (list == null) {

        }
        //inn  /  list.nn
        if (list != null) {

        }
        //

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
