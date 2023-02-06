package cn.itcast;

import java.sql.*;

public class jdbcdemo2 {
    public static void main(String[] args) throws SQLException {
        //注册驱动

        //建立与数据库的连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_mysql","root","123456");
        //将SQL指令发给SQL服务器执行
        Statement statement = connection.createStatement();
        String sql="select * from emp";
        ResultSet resultSet = statement.executeQuery(sql);
        //获取表的列数
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        //处理服务器返回的结果
        while(resultSet.next()){ //获取每一行数据
            //获取每一列数据
            for(int i=1;i<=columnCount;i++){
                System.out.print(resultSet.getObject(i)+"\t");

            }
            System.out.println();

        }
        //释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
