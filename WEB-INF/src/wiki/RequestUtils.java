package wiki;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils{
	//���b�Z�[�W���Z�b�g���邽�߂����̃��\�b�h
	public static void setMessage(HttpServletRequest req,String mes){
		req.setAttribute("message",mes);
	}
}