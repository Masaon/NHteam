package fw;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import wiki.WikiPage;

public class DBManager{
	public static Connection getConnection(){
		
		Connection cn = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			cn = DriverManager.getConnection(url, "scott", "tiger");
		}catch(Exception e){
			e.printStackTrace();
		}
		return cn;
	}
	public static int simpleUpdate(String sql)throws SQLException{
		Connection cn = null;
		Statement st = null;
		try{
			cn = DBManager.getConnection();
			st = cn.createStatement();
			return st.executeUpdate(sql);
		}finally{
			if(st != null){
				try{st.close();}catch(SQLException ex){}
			}
			if(cn != null){
				try{cn.close();}catch(SQLException ex){}
			}
		}
	}
	public static <WikiPageDAO> List<WikiPage> simpleFind(String sql, ResultSetBeanMapping<WikiPage> mapping)
	throws SQLException{
		Connection cn = null;
		Statement st = null;
		try{
			cn = cn = DBManager.getConnection();
			st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			List<WikiPage> list = new ArrayList<WikiPage>();
			
			while(rs.next()){
				WikiPage bean = mapping.createFromResultSet(rs);
				list.add(bean);
			}
			return list;
			}finally{
			if(st != null){
				try{st.close();}catch(SQLException ex){}
			}
			if(cn != null){
				try{cn.close();}catch(SQLException ex){}
			}
		}
	}
}