package com.kh.practice.list.music.view;

import java.util.List;
import java.util.Scanner;

import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();

	public void mainMenu() {

//		******* 메인 메뉴 *******
//		1. 마지막 위치에 곡 추가 // addList() 실행
//		2. 첫 위치에 곡 추가 // addAtZero()
//		3. 전체 곡 목록 출력 // printAll()
//		4. 특정 곡 검색 // searchMusic()
//		5. 특정 곡 삭제 // removeMusic()
//		6. 특정 곡 정보 수정 // setMusic()
//		7. 곡명 오름차순 정렬 // ascTitle()
//		8. 가수명 내림차순 정렬 // descSinger()
//		9. 종료 // “종료” 출력 후 main()으로 리턴
//		메뉴 번호 선택 : >> 입력 받음
//		메뉴 화면 반복 실행 처리
		int menu=0;
		do {
			System.out.println("*****메인 메뉴*****");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순으로 정렬");
			System.out.println("7. 곡명 오름차순으로 정렬");
			System.out.println("8. 가수명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : >>");
			String menuStr = sc.nextLine();

			menu = 0;
			// 비정상인 경우
			try {
				menu = Integer.parseInt(menuStr);
			} catch (NumberFormatException e) {
//			e.printStackTrace();
				System.out.println("문자는 안돼");
//			continue;
			}
//			if (menu < 1 || menu > 9) {
//				System.out.println("메뉴에 해당하는 1-9 숫자만 작성해주세요");
//				continue;
			
			switch (menu) {
			//정상입력
			case 1:
				addList();
				break;
			case 2:
				addAtZero();
				break;
			case 3:
				printAll();
				break;
			case 4:
				searchMusic();
				break;
			case 5:
				removeMusic();
				break;
			case 6:
				setMusic();
				break;
			case 7:
				ascTitle();
				break;
			case 8:
				desSinger();
				break;
			case 9:
				System.out.println("종료");
				return; //종료 경우 메소드 종료
			default :
				//비정상 입력 경우
				System.out.println("!!!!!!!!메뉴에 해당하는 1-9 숫자만 작성해주세요");
				continue;//다시 메뉴 입력이 보이도록함
			}
			//반복문 마지막에 더이상 어떤 코드도 없음
		}while (menu !=9);
		//생략가능 코드
		
	}

	public void addList() {
		System.out.println("****마지막 위치에 곡 추가");
		System.out.print("곡명 : ");
		String title= sc.nextLine();
		System.out.print("가수 명 : ");
		String singer= sc.nextLine();
		Music vo = new Music(title, singer);
		int result = mc.addList(vo);
		if(result > 0 ) {
			System.out.println("추가 성공");
		}else {
			System.out.println("추가 실패");
		}
	}

	public void addAtZero() {
		System.out.println("****첫번째 위치에 곡 추가");
		System.out.print("곡명 : ");
		String title= sc.nextLine();
		System.out.print("가수 명 : ");
		String singer= sc.nextLine();
		Music vo = new Music(title, singer);
		int result = mc.addAtZero(vo);
		if(result > 0 ) {
			System.out.println("추가 성공");
		}else {
			System.out.println("추가 실패");
		}
	
	}

	public void printAll() {
		System.out.println("*****전체 곡 목록 출력*****");
		List<Music> volist= mc.printAll();
		for(Music vo : volist) {
			System.out.println(vo);
		}
	
	
	}

	public void searchMusic() {
		System.out.println("*********특정 곡 검색******");
		System.out.print("검색할 곡명을 입력해주세요.");
		String title = sc.nextLine();
		Music result = mc.searchMusic(title);
		if(result == null) {
			System.out.println("검색한 곡이 없습니다");
		}else {
			System.out.printf("검색한 곡은000(%s,%s)입니다. \n",result.getTitle(), result.getSinger()	);
		}
		
	}

	public void removeMusic() {
		System.out.println("*********특정 곡 삭제******");
		System.out.print("삭제할 곡명을 입력해주세요.");
		String title = sc.nextLine();
		Music result = mc.removeMusic(title);
		if(result ==null) {
			System.out.println("삭제할 곡이 없습니다.");
		}else {
			System.out.printf("한 곡은000(%s,%s)입니다. \n",result.getTitle(), result.getSinger()	);
			System.out.printf("삭제됐음"	);
		}
		
	}

	public void setMusic() {
		System.out.println("********특정곡 수정*****");
		System.out.println("검색할 곡 명");
		String title= sc.nextLine();
		Music result = mc.searchMusic(title);
		System.out.println("수정할 곡 명");
		String title2= sc.nextLine();
		System.out.println("수정할 가수 명");
		String singer = sc.nextLine();
		
		System.out.printf("%s-%s가 값이 변경되었습니다. \n", result.getTitle(), result.getSinger());
	}

	public void ascTitle() {
		// todo
	}

	public void desSinger() {
		// todo
	}
}
