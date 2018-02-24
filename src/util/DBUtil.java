package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	public static void main(String[] args) {
		String url = "jdbc:mysql://192.168.234.223:3306/zhc?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "zhc19950320";
		Connection conn = null;
		PreparedStatement sta = null;
		ResultSet rs = null;
		try {
			//创建连接，加载驱动类(反射机制)
			Class.forName("com.mysql.jdbc.Driver");
			//设置连接，主机IP 端口号 用户名 密码，选择要操作的数据库
			conn = DriverManager.getConnection(url, user, password);
			/*//新建查询，组装SQL语句
			sta = conn.prepareStatement("select * from student");
			
			 * 执行查询：
				1、查：调用executeQuery方法，返回resultSet结果集
				2、增删改：调用executeUpdate方法，返回受影响行数
			
			rs = sta.executeQuery();
			//显示查询结果
			while(rs.next()) {
				System.out.println(rs.getInt("sno")+"  "+rs.getString("sname")+"  "+rs.getString("ssex"));
			}*/
			//增删改，使用参数注入的方法
			sta = conn.prepareStatement("insert into course(cno,cname,tno) values(?,?,?)");
			sta.setString(1, "2-173");
			sta.setString(2, "数据库系统概论");
			sta.setString(3, "888");
			//会出现中文字符乱码，在传输时设置字符编码集
			System.out.println(sta.executeUpdate());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { //关闭资源
			//空指针调用任何一个方法都会报错
			try {
				if(rs!=null)
					rs.close();
				if(sta!=null)
					sta.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
