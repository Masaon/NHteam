package fw;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import wiki.WikiPage;

public class ResultSetBeanMapping<WikiPageDAO>{
	//�󂯎�������ʃZ�b�g���炷�ׂĂ̒l���󂯎��WikiPage�ɃZ�b�g���ĕԂ�
	public WikiPage createFromResultSet(ResultSet rs)throws SQLException{
		WikiPage wp = new WikiPage();
		wp.setName(rs.getString("name"));
		wp.setContent(rs.getString("content"));
		wp.setUpdateTime(rs.getString("update_time"));
		return wp;
	}
}