package kh.test.jdbckh.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.department.service.DepartmentService;

/**
 * Servlet implementation class StudentInsertServlet
 */
@WebServlet("/student/insert")
public class StudentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DepartmentService serviceDept = new DepartmentService();   
    //private DepartmentService serviceProf = new DepartmentService();   
	
	
    public StudentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.전달받은 parameter읽어내기
		//2. 전달받은 데이터를 활용해 db정보 가져오기
		//학과번호,지도교수
		//3. db로부터 전달받은 데이터를 jsp에 전달함
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/student/insert.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("/WEB-INF/view/student/insert.jsp").forward(request, response);
//		
//		
//		
//		
//		
//	}

}
