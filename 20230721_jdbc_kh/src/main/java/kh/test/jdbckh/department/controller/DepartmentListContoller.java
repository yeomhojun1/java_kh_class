package kh.test.jdbckh.department.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.department.model.dao.DeptDao;
import kh.test.jdbckh.department.model.service.DeptService;
import kh.test.jdbckh.department.model.vo.DeptVo;

/**
 * Servlet implementation class DepartmentListContoller
 */
@WebServlet("/dept/list")
public class DepartmentListContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartmentListContoller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/dept/list doGet() 진입");
		String searchword = request.getParameter("searchword");
		String pageNoStr = request.getParameter("pageNo");
		Map<String, Object> map =null;
		List<DeptVo> list = null;
		int currentPage =1;
		int pageSize =10;
		if(pageNoStr!= null) {
			currentPage= Integer.parseInt(pageNoStr);
		}
		
		
		
	DeptService service = new DeptService();
		if (searchword != null) {
			map = service.selectListDept(currentPage, pageSize, searchword);
		} else {
			map = service.selectListDept(currentPage, pageSize);
		}

		request.setAttribute("deptlist", map.get("DeptList"));
		int pageBlockSize = 5;
		int totalCnt = (Integer)map.get("totalCnt");
		int totalPageNum = totalCnt/pageSize + (totalCnt%pageSize ==0 ? 0 : 1);
		int startPageNum = 1;
		if((currentPage%pageBlockSize)==0) {
			startPageNum = ((currentPage/pageBlockSize)-1)*pageBlockSize +1;
		}else {
			startPageNum = ((currentPage/pageBlockSize))*pageBlockSize +1;
		}
		int endPageNum = (startPageNum+pageBlockSize > totalPageNum) ? totalPageNum : startPageNum + pageBlockSize -1;
		request.setAttribute("totalPageNum", totalPageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("currentPage", currentPage);
		if(searchword != null) {
			request.setAttribute("searchword", searchword);
		}
		request.getRequestDispatcher("/WEB-INF/view/dept/deptList.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
