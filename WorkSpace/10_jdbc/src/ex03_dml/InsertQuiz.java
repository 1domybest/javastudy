package ex03_dml;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import connection.DBconnection;

public class InsertQuiz {
	public static void main(String[] args) {
		Connection con =null;
		PreparedStatement ps =null;
		//임의의 3명 스텝을 삽입하세요.
		//반복문과 베열을 사용하세요.
	
		int [] no = {3,4,5,6};
		String [] name = {"david","james","jack"};
		String [] department = {"총무","영업","고객"};
		String [] hiredate = {"21/03/18","21/03/15","21/03/20"};
				
		String sql ="INSERT INTO staff VALUES (?,?,?,?)";
		
		try {	
			con = DBconnection.getConnection();
			
			ps = con.prepareStatement(sql);
			
			int result = 0;
			for (int i = 0; i < name.length; i++) {
				
				ps.setInt(1, no[i]);
				ps.setString(2, name[i]);
				ps.setString(3, department[i]);
				ps.setString(4,hiredate[i]);
				result += ps.executeUpdate();
				
			}
			
			if(result == 0) {
				System.out.println("행 추가에 실패하였습니다");
			}else {
				System.out.println(result+"행이 삽입 되었습니다.");
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
