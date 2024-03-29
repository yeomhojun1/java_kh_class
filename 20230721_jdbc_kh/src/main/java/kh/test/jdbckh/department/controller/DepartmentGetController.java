package kh.test.jdbckh.department.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.department.model.dao.DeptDao;
import kh.test.jdbckh.department.model.vo.DeptVo;
import kh.test.jdbckh.department.service.DepartmentService;
import kh.test.jdbckh.student.model.dao.StudentDao;
import kh.test.jdbckh.student.model.vo.StudentVo;

/**
 * Servlet implementation class DepartmentGetController
 */
@WebServlet("/dept/get")
public class DepartmentGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptNo = request.getParameter("deptno");
		System.out.println(deptNo);
		//2. 전달받은 데이터를 활용해 DB학생 상세정보 가져오기
		DepartmentService service= new DepartmentService();
		DeptVo vo = service.selectOneDept(deptNo);
		if(vo==null) {
			
		}else {
	request.setAttribute("deptno", vo);
		request.getRequestDispatcher("/WEB-INF/view/dept/deptGet.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}}
