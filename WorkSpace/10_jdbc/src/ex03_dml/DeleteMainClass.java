package ex03_dml;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.DBconnection;

public class DeleteMainClass {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBconnection.getConnection();
			String sql = "DELETE FROM staff WHERE department = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, "영업");
			
			int result = ps.executeUpdate();
			
			if(result ==0) {
				System.out.println("삭제된 정보가 없습니다");
			}else {
				System.out.println(result+"행의 정보가 삭제되었습니다.");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) {con.close();}
				if(ps != null) {ps.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
