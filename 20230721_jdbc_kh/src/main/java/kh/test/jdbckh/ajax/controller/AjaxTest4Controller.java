package kh.test.jdbckh.ajax.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.test.jdbckh.member.model.dto.Member;

/**
 * Servlet implementation class AjaxTest4Controller
 */
@WebServlet("/ajax4")
public class AjaxTest4Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest4Controller() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax4 do Post");
		//요청받은 IO중에서 BufferedReader 객체부분을 꺼내옴
		BufferedReader br=  request.getReader();
		String reqData= br.readLine();
		Gson gson = new Gson();
		Member[] memberArray= gson.fromJson(reqData, Member[].class);
		List<Member> memberList= Arrays.asList(memberArray);
		System.out.println(memberList);
		for(Member vo: memberList) {
			System.out.println(vo.getMemail());
		}
		
	}

}
