package com.kh.practice.list.music.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.music.model.compare.AscTitle;
import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music> list = new ArrayList<Music>();
	
	public MusicController() {
		//music.txt 파일에서 읽어서 list에 추가하여 초기화 함
		
		
		list.add(new Music("aa", "aaa"));
		list.add(new Music("bb", "bbb"));
		list.add(new Music("cc", "ccc"));
		list.add(new Music("dd", "ddd"));
		list.add(new Music("aa", "eee"));
		list.add(new Music("cc", "fff"));
		list.add(new Music("dd", "aaa"));
		list.add(new Music("ee", "ccc"));
		list.add(new Music("ff", "ddd"));
		
	}

	public int addList(Music music) {
		int result = 0;
		if (list.add(music)) {
			result = 1;
		}
		return result;
	}

	public int addAtZero(Music music) {
		int result = 0;
		int cnt = list.size();
		((ArrayList<Music>) list).add(0, music);
		int cntAfter = list.size();
		if (cnt < cntAfter) {
			result = cntAfter - cnt;
		}

		return result;
	}

	public List<Music> printAll() {
		return list;
	}

	public Music searchMusic(String title) {
		Music result = null;
		for (Music vo : list) {
			if (vo.getTitle().equals(title)) {
				result = vo;
				break;
			}
		}
		return result;// return null;
	}

	public Music removeMusic(String title) {
		Music result = null;
		for (Music vo : list) {
			if (vo.getTitle().equals(title)) {
				list.remove(vo);
				result = vo;
				break;
			}
		}
		return result;
	}

	public Music setMusic1(String title, Music music) {
		Music result = null;
//		for(Music vo : list) {
//			if(vo.getTitle().equals(title)) {
//				result = vo;
//				int findIdx = list.indexOf(vo); 
//				list.set(findIdx, music);
//				break;
//			}
//			
//		}
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getTitle().equals(title)) {
				result= list.get(i);
				list.set(i, music);
				break;
			}

		return result;
	}

	public Music setMusic(String title, Music result) {
		
		for (Music vo : list) {
			if (vo.getTitle().equals(title)) {
				list.remove(vo);
				((ArrayList<Music>)list).add(result);
				list.add(result);
				
				}
			}
			return result;
		}


	public int ascTitle() {
		int result = 0;
		for(int i = 0; i <list.size()-1;i++) {
			for(int j = 0; j<list.size()-1-i;j++) {
				if(list.get(j).getTitle().compareTo(list.get(j+1).getTitle())>0) {
					Music temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
				}
			}
		}
		return result;
	}

	public int descSinger() {
//		list.get(0).getSinger();
		int result = 0;
		for (int i = 0; i<list.size()-1;i++) {
			for(int j = 0; j<list.size()-1-i; j++) {
				if(list.get(j).getSinger().compareTo(list.get(j+1).getSinger())<0) {
//			if(arr[j]<arr[j+1]) {//내림차순
				//swap
				Music temp = list.get(j);
				list.set(j, list.get(j+1));
				list.set(j+1, temp);
	}
			}
		}
		return result;
	}
	
	public int ascTitle2() {
		int result= 1;
		try {
		Collections.sort(list, new AscTitle());
		}catch(Exception e){
			e.printStackTrace();
			result = 0;
		}
			return result;
		
	}
	public int descSinger2() {
		int result = 0;
		try {
		Collections.sort(list, new AscTitle());
		}catch(Exception e){
			e.printStackTrace();
			result = 0;
		}
		return result;
			
	}
	public int saveFile(String filePath) {
		int result= 0;//0이 실패 1은 저장성공
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)));
		){
			oos.writeObject(list);
			oos.flush();
			result=1;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	return result;
	}
	public int loadFile(String filePath) {
		int result = 0;
		try(ObjectInputStream ois 
			= new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)));
			){
			list = (List<Music>)ois.readObject();
			System.out.println(list);
		}catch (FileNotFoundException e) {
		e.printStackTrace();
		}catch (IOException e) {
		e.printStackTrace();
		}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
		return result;
}
}
