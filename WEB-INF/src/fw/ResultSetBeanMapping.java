package fw;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import wiki.WikiPage;

public class ResultSetBeanMapping<WikiPageDAO>{
	//受け取った結果セットからすべての値を受け取りWikiPageにセットして返す
	public WikiPage createFromResultSet(ResultSet rs)throws SQLException{
		WikiPage wp = new WikiPage();
		wp.setName(rs.getString("name"));
		wp.setContent(rs.getString("content"));
		wp.setUpdateTime(rs.getString("update_time"));
		return wp;
	}
}