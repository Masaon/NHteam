package wiki;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import fw.DBManager;
import fw.ResultSetBeanMapping;

public class WikiPageDAO{
	//�����N���X���g���āA�󂯎�������ʃZ�b�g���炷�ׂĂ̒l���󂯎��WikiPage�ɃZ�b�g���ĕԂ�
	private ResultSetBeanMapping<WikiPage> allMapping = new ResultSetBeanMapping<WikiPage>(){
		public WikiPage creareFromResultSet(ResultSet rs)throws SQLException{
			WikiPage page = new WikiPage();
			page.setName(rs.getString("name"));
			page.setContent(rs.getString("content"));
			page.setUpdateTime(rs.getString("update_time"));
			return page;
		}
	};
	//WikiPageDAO�̃C���X�^���X�𑗂�Ԃ�
	public static WikiPageDAO getInstance(){
		return new WikiPageDAO();
	}
	//DBManager��simpleFind���\�b�h��
	//SQL���ƌ��ʃZ�b�g�𑗂�List�𑗂�Ԃ�
	public List findAll() throws SQLException{
		String sql = "SELECT * FROM wiki_page ORDER BY update_time DESC";
		return DBManager.simpleFind(sql,allMapping);
	}
	//�y�[�W�̖��O���󂯎���̃��\�b�h�Ɠ����悤�ɑ���
	//���ʂ�wikipage�𑗂�
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
	//�V�K���s��
	public void insert(WikiPage page)throws SQLException{
		String sql = "INSERT INTO wiki_page(name,content) VALUES('"
			+page.getName()+"','"+page.getContent()+"')";
		DBManager.simpleUpdate(sql);
	}
	//�X�V���s��
	public void update(WikiPage page)throws SQLException{
		String sql = "UPDATE wiki_page SET content='"+page.getContent()
			+"' WHERE name='"+page.getName()+"'";
		DBManager.simpleUpdate(sql);
	}
	//�폜���s��
	public void delete(WikiPage page)throws SQLException{
		String sql = "DELETE FROM wiki_page WHERE name='"+page.getName()+"'";
		DBManager.simpleUpdate(sql);
	}
	//�������s��
	public List search(String name)throws SQLException{
		String sql = "SELECT * FROM wiki_page where name like '%"
		+name+"%' ORDER BY update_time DESC";
		return DBManager.simpleFind(sql,allMapping);
	}
}