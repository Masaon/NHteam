package wiki;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import fw.DBManager;
import fw.ResultSetBeanMapping;

public class WikiPageDAO{
	//無名クラスを使って、受け取った結果セットからすべての値を受け取りWikiPageにセットして返す
	private ResultSetBeanMapping<WikiPage> allMapping = new ResultSetBeanMapping<WikiPage>(){
		public WikiPage creareFromResultSet(ResultSet rs)throws SQLException{
			WikiPage page = new WikiPage();
			page.setName(rs.getString("name"));
			page.setContent(rs.getString("content"));
			page.setUpdateTime(rs.getString("update_time"));
			return page;
		}
	};
	//WikiPageDAOのインスタンスを送り返す
	public static WikiPageDAO getInstance(){
		return new WikiPageDAO();
	}
	//DBManagerのsimpleFindメソッドに
	//SQL文と結果セットを送りListを送り返す
	public List findAll() throws SQLException{
		String sql = "SELECT * FROM wiki_page ORDER BY update_time DESC";
		return DBManager.simpleFind(sql,allMapping);
	}
	//ページの名前を受け取り上のメソッドと同じように送り
	//結果のwikipageを送る
	public WikiPage findByName(String name)throws SQLException{
		String sql = "SELECT * FROM wiki_page WHERE name='"+name+"'";
		List list = DBManager.simpleFind(sql, allMapping);
		if(list.size() == 0){
			return null;
		}else if(list.size() > 1){
			throw new IllegalArgumentException("recode > 1");
		}
		return (WikiPage)list.get(0);
	}
	//新規を行う
	public void insert(WikiPage page)throws SQLException{
		String sql = "INSERT INTO wiki_page(name,content) VALUES('"
			+page.getName()+"','"+page.getContent()+"')";
		DBManager.simpleUpdate(sql);
	}
	//更新を行う
	public void update(WikiPage page)throws SQLException{
		String sql = "UPDATE wiki_page SET content='"+page.getContent()
			+"' WHERE name='"+page.getName()+"'";
		DBManager.simpleUpdate(sql);
	}
	//削除を行う
	public void delete(WikiPage page)throws SQLException{
		String sql = "DELETE FROM wiki_page WHERE name='"+page.getName()+"'";
		DBManager.simpleUpdate(sql);
	}
	//検索を行う
	public List search(String name)throws SQLException{
		String sql = "SELECT * FROM wiki_page where name like '%"
		+name+"%' ORDER BY update_time DESC";
		return DBManager.simpleFind(sql,allMapping);
	}
}