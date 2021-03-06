package wiki;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet{
	//記事一覧を見るためのクラス
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		try{
			List<WikiPageDAO> list = WikiPageDAO.getInstance().findAll();
			req.setAttribute("list", list);
			req.getRequestDispatcher("/list.jsp").forward(req,res);
		}catch(SQLException e){
			throw new ServletException(e);
		}
	}
}