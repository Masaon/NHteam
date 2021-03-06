package wiki;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReferServlet extends HttpServlet{
	//記事の中を見るためのクラス
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		String name = req.getParameter("name");
		try{
			if(name != null){
				WikiPage wikiPage = WikiPageDAO.getInstance().findByName(name);
				HttpSession hs = req.getSession();
				hs.setAttribute("wikiPage", wikiPage);
			}
			req.getRequestDispatcher("/refer.jsp").forward(req,res);
		}catch(SQLException e){
			throw new ServletException(e);
		}
	}
}