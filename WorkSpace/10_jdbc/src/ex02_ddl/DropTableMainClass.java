package ex02_ddl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.DBconnection;

public class DropTableMainClass {
	public static void main(String[] args) {
		//try {} 블록과 finally {} 블록에서 모두 사용하기 위해서 전역변수로 선언합니다.
		Connection con =null;
		PreparedStatement ps=null;
		try {
			con = DBconnection.getConnection(); 
			String sql ="DROP TABLE staff";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("staff 테이블이 삭제 되었습니다");
		
		
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			try {
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	} 
}
