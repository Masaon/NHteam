package wiki;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet{
	//記事一覧を見るためのクラス
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		try{
			String name = req.getParameter("name");
			String non = "見つかりませんでした。";
			List<WikiPageDAO> list = WikiPageDAO.getInstance().search(name);
			if(list.size() == 0){
				req.setAttribute("non", non);
			}else{
				req.setAttribute("list", list);
			}
			req.getRequestDispatcher("/search.jsp").forward(req,res);
		}catch(SQLException e){
			throw new ServletException(e);
		}
	}
}