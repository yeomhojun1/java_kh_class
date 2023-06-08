package com.kh.practice.list.music.model.compare;

import java.util.Comparator;

import com.kh.practice.list.music.model.vo.Music;

public class AscTitle implements Comparator<Music>{

	@Override
	public int compare(Music o1, Music o2) {
		int result= 0;
		result= o1.getTitle().compareTo(o2.getTitle());
		System.out.println("정렬확인: "+result+" - "+((Music)o1).getSinger());
		return 0;
	}
}
