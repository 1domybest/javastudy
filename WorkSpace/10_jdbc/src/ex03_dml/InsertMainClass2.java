package ex03_dml;

import java.sql.*;

import connection.DBconnection;


public class InsertMainClass2 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBconnection.getConnection();
			String sql = "INSERT INTO staff (no,name,department,hireDate) VALUES (?,?,?,?)";
			ps = con.prepareStatement(sql);
			//변수 처리 (? 에 값을 전달하기)
			ps.setInt(1, 2); //1번째 ? 에 데이터 2 전달
			ps.setString(2, "emily"); //2번째 ? 에 데이터 emily 전달
			ps.setString(3, "인사"); //3번째 ? 에 데이터 인사 전달
			ps.setDate(4, new Date(System.currentTimeMillis())); //4번째 ? 데이터 new Date(System.currentTimeMillis()) 전달
			
			int result = ps.executeUpdate();
			
			if(result == 0) {
				System.out.println("행이 추가되지 않았습니다.");
			}else {
				System.out.println(result + "행이 추가되었습니다");
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
