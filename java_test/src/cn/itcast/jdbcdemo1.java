package cn.itcast;

import java.sql.*;

public class jdbcdemo1 {
    public static void main(String[] args) throws SQLException {
        //注册驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver()); -- 自动注册

        //建立与数据库的连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_mysql","root","123456");
        //将SQL指令发给SQL服务器执行
        Statement statement = connection.createStatement();
        String sql="select * from account";
        ResultSet resultSet = statement.executeQuery(sql);
        //处理服务器返回的结果
        while(resultSet.next()){ //获取每一行数据
            //获取每一列数据
            // 方法1：根据列名获取
           /* int id =resultSet.getInt("id");
            String name = resultSet.getString("name");
            double money= resultSet.getDouble("money");
            System.out.println(id+"\t"+name+"\t"+money);*/
            //方法2：根据列索引获取，从1开始
            int id =resultSet.getInt(1);
            String name = resultSet.getString(2);
            double money= resultSet.getDouble(3);
            System.out.println(id+"\t"+name+"\t"+money);
        }
        //释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
