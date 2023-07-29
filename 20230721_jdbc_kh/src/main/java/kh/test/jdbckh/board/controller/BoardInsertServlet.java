package kh.test.jdbckh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.board.model.service.BoardService;
import kh.test.jdbckh.board.model.vo.BoardVo;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/board/insert doGet()");
		// 답글작성시 원본글 번호를 가져오기위해 만드는 코드
		String bnoStr = request.getParameter("bno");
		request.setAttribute("bno", bnoStr);

		request.getRequestDispatcher("/WEB-INF/view/board/insert.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/board/insert doPost!!!!!!!!!!!!!!!!!!!!()");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String mid = "kh1"; // todo 임시작성자 - 로그인한 아이디로 변경예정
		// 답글 작성시 참조 글번호
		String bnoStr = request.getParameter("bno");
		System.out.println("bnoStr = "+bnoStr);
		int bno = 0;
		if (bnoStr != null && !bnoStr.equals("")) {
			try {
				bno = Integer.parseInt(bnoStr);
			} catch (Exception e) {
				e.printStackTrace();
				//숫자로 못바꾸면 답글 작성에 실패한것으로 간주함
				//오류페이지로 이동함.
				//todo
			}
		}
		//bno가 0이면 원본글, 그외는 답글의 참조번호
		int result = service.insert(new BoardVo(bno, btitle, bcontent, mid));

		response.sendRedirect(request.getContextPath() + "/board/list");

	}

}
