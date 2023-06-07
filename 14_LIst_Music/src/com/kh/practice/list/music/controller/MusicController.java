package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music> list= new ArrayList<Music>();
	
	public int addList(Music music) {
		//todo
		int result = 0;//0:추가 실패, 1:추가성공
		return result;
	}
	public int addAtZero(Music music) {
		//todo
		int result = 0;
		return result;
	}
	public List<Music> printAll(){
		//todo
		return list;
	}
	public Music searchMusic(String title) {
		Music result = null;
		return result;//return null;
	}
	public Music remoaveMusic(String title) {
		Music result = null;
		return result;
	}
	public Music setMusic(String title, Music music) {
		Music result = null;
		return result;
	}
	public int ascTitle() {
		int result = 0;
		return result;
	}
	public int descSinger()	{
		int result = 0;
		return result;
	}
}
