package wiki;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils{
	//メッセージをセットするためだけのメソッド
	public static void setMessage(HttpServletRequest req,String mes){
		req.setAttribute("message",mes);
	}
}