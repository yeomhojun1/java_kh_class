package kh.test.jdbckh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.member.model.dto.Member;
import kh.test.jdbckh.member.model.service.MemberService;

/**
 * Servlet implementation class LoginDoServlet
 */
@WebServlet("/login.login")
public class LoginDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login.login post");
		
		String mid= request.getParameter("mid");
		String mpwd= request.getParameter("mpwd");
		Member vo = new Member(mid,mpwd);
		String sendUrl= request.getContextPath();
		String result = new MemberService().login(mid);
		if(mpwd == null) {
			//
		}else if(mpwd.equals(result)) {
			request.setAttribute("loginId", mid);
			request.getSession().setAttribute("successFailMsg", "로그인성공");
			request.getSession().setAttribute("SsLoginId", mid);
			sendUrl += "/board/list";
		}else {
			request.getSession().setAttribute("successFailMsg", "로그인 실패하였습니다.\n 아이디와 패스워드를 다시 확인하고 로그인 시도해주세요.");
			sendUrl += "/board/list";
		}
	response.sendRedirect(sendUrl);
	
	
	
	}

}
