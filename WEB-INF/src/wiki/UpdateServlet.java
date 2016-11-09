package wiki;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		String name = req.getParameter("name");
		String content = req.getParameter("content");
		String cmd = req.getParameter("cmd");
		try{
			WikiPage wp = new WikiPage();
			wp.setName(name);
			wp.setContent(content);
			if(cmd.equals("update")){
				WikiPageDAO.getInstance().update(wp);
				RequestUtils.setMessage(req, name + "更新しました。");
				req.getRequestDispatcher("/refer").forward(req, res);
			}else if(cmd.equals("delete")){
				WikiPageDAO.getInstance().delete(wp);
				RequestUtils.setMessage(req, name + "削除しました。");
				req.getRequestDispatcher("/list").forward(req , res);
			}else{
				req.getRequestDispatcher("/refer").forward(req, res);
			}
		}catch(SQLException e){
			throw new ServletException(e);
		}
	}
}