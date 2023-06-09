package com.kh.practice.file.controller;

import com.kh.practice.file.dao.FileDAO;

public class FileController {
	private FileDAO fd = new FileDAO();
	public boolean checkName(String file) {
		if(file != "ex끝it") {
			fileOpen(file);
		}
		return true;
	}
	public StringBuilder fileOpen(String file) {
		return null;
	}
	public void fileEdit(String file, StringBuilder sb) {}
	
}
