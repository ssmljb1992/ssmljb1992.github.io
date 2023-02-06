package cn.itcast;

import java.sql.*;

public class jdbcdemo3 {
    public static void main(String[] args) throws SQLException {
        //注册驱动

        //建立与数据库的连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_mysql","root","123456");
        //将SQL指令发给SQL服务器执行
        Statement statement = connection.createStatement();

        // 查询SQL
        //String sql="select * from emp";
        //ResultSet resultSet = statement.executeQuery(sql);

        //增加
        //String sql="insert into account values(4,'wangwu',300)";

        //删除
       /* String sql="delete from account where id =4";*/
        //修改
        String sql="update account set money = 2000 where id =3";
        int row_num = statement.executeUpdate(sql);
        System.out.println(row_num);
        //释放资源
        //resultSet.close();
        statement.close();
        connection.close();
    }
}
