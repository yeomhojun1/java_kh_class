package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music> list= new ArrayList<Music>();
	
	public MusicController() {
		list.add(new Music("aa","aaa"));
		list.add(new Music("bb","bbb"));
		list.add(new Music("cc","ccc"));
		list.add(new Music("dd","ddd"));
		list.add(new Music("aa","eee"));
		list.add(new Music("cc","fff"));
		list.add(new Music("dd","aaa"));
		list.add(new Music("ee","ccc"));
		list.add(new Music("ff","ddd"));
	}
	public int addList(Music music) {
		int result = 0;
		if(list.add(music)) {
			result =1;
			}
			return result;
		}
	
	public int addAtZero(Music music) {
		int result = 0;
		int cnt = list.size();
		((ArrayList<Music>)list).add(0, music); 
		int cntAfter = list.size();
		if(cnt < cntAfter) {
			result = cntAfter - cnt;
		}
		
		return result;
	}
	public List<Music> printAll(){
		return list;
	}
	public Music searchMusic(String title) {
		Music result = null;
		for(Music vo : list) {
			if(vo.getTitle().equals(title)){
				result= vo;
				break;
			}
		}
		return result;//return null;
	}
	public Music removeMusic(String title) {
		Music result = null;
		for(Music vo : list) {
			if(vo.getTitle().equals(title)){
				result= vo;
				break;
				}
		}return null;
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
