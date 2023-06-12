package com.kh.practice.student.controller;

import com.kh.practice.student.model.vo.Student;

public class StudentController {
	private Student[] sArr= new Student[5];
	public final int CUT_LINE = 60;
	public StudentController() {
		for(int i = 0;i< sArr.length;i++) {
			sArr[i]= new Student();}
		}
	public Student[] printStudent() {
	
		return null;
	}
	public int sumScore() {
		
		return 0;
	}
	public double[] avgScore() {
		return null;
	}
	
	
	
}
