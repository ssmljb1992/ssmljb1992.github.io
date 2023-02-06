package cn.itcast;

import java.sql.*;
import java.util.Scanner;

public class jdbcdemo4 {
    public static void main(String[] args) throws SQLException {
        //用户从键盘输入用户名和密码判断是否和数据库中的一致
        Scanner scanner = new Scanner(System.in);
        //提醒用户输入
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();



        //注册驱动

        //建立与数据库的连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_mysql","root","123456");
        //将SQL指令发给SQL服务器执行
        Statement statement = connection.createStatement();

        // 查询SQL
        //SQL 注入
        /*请输入用户名：
        zhangsan
        请输入密码：
        123 'or' 1=1
        该用户及密码正确*/
        String sql="select * from user where username = '"+username+"' and password = '"+password+"'";
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){
            System.out.println("该用户及密码正确");
        }else{
            System.out.println("该用户及密码错误");
        }


        //释放资源
        //resultSet.close();
        statement.close();
        connection.close();
    }
}
