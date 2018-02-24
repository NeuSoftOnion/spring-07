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
			//�������ӣ�����������(�������)
			Class.forName("com.mysql.jdbc.Driver");
			//�������ӣ�����IP �˿ں� �û��� ���룬ѡ��Ҫ���������ݿ�
			conn = DriverManager.getConnection(url, user, password);
			/*//�½���ѯ����װSQL���
			sta = conn.prepareStatement("select * from student");
			
			 * ִ�в�ѯ��
				1���飺����executeQuery����������resultSet�����
				2����ɾ�ģ�����executeUpdate������������Ӱ������
			
			rs = sta.executeQuery();
			//��ʾ��ѯ���
			while(rs.next()) {
				System.out.println(rs.getInt("sno")+"  "+rs.getString("sname")+"  "+rs.getString("ssex"));
			}*/
			//��ɾ�ģ�ʹ�ò���ע��ķ���
			sta = conn.prepareStatement("insert into course(cno,cname,tno) values(?,?,?)");
			sta.setString(1, "2-173");
			sta.setString(2, "���ݿ�ϵͳ����");
			sta.setString(3, "888");
			//����������ַ����룬�ڴ���ʱ�����ַ����뼯
			System.out.println(sta.executeUpdate());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { //�ر���Դ
			//��ָ������κ�һ���������ᱨ��
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
