package kh.test.jdbckh.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.student.model.dao.StudentDao;
import kh.test.jdbckh.student.model.vo.StudentVo;

/**
 * Servlet implementation class StudentListController
 */
@WebServlet({  "/student/list" })
public class StudentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//    C:\workspace\github\java_kh_class\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\jdbckh\org\apache\jsp\WEB_002dINF\view\student
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/student/list doGet() 진입");
		String searchword = request.getParameter("searchword");
		String pageNoStr = request.getParameter("pageNo");
		//String --> int
		int currentPage = 1;
		if(pageNoStr!=null) {
			try {
			currentPage= Integer.parseInt(pageNoStr);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}
		StudentDao dao = new StudentDao();
		List<StudentVo> list= null;
		if(searchword !=null) {
			//검색
			System.out.println(searchword);
			list = dao.selectListStudent(searchword);
		}else {
			//전체보기
//		list = dao.selectListStudent();
		//페이징처리
			list = dao.selectListStudent(currentPage, 5);
		}
		if(searchword !=null) {
			request.setAttribute("searchword", searchword);
		}
		request.setAttribute("studentlist", list);
		request.getRequestDispatcher("/WEB-INF/view/student/list.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
