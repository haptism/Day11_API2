package com.rjm.io.file.rw;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {
	private Scanner sc;
	private MemberInfo mi;
	private MemberView mv;
	private ArrayList<Member> ar;

	public MemberController() {
		sc = new Scanner(System.in);
		mi = new MemberInfo();
		mv = new MemberView();
	}

	// 메서드명 start

	public void start() {

		boolean check = true;

		while (check) {
			System.out.println("1. 멤버 정보 가져오기"); // info getMembers
			System.out.println("2. 멤버 정보 출력하기"); // MemberView
			System.out.println("3. 멤버 검색 출력하기");
			System.out.println("4. 종 료");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				ar = mi.getMembers();
				break;
			case 2:
				mv.view(ar);
				break;
			default:
				check = !check;
				sc.close();
			}

//		MemberInfo mi = new MemberInfo();
//		ArrayList<Member> ar = mi.getMembers();
//
//		// 모든 이름을 출력
//
//		MemberView mv = new MemberView();
//		mv.view(ar);

			// 1. 멤버정보 가져오기
			// 2. 멤버정보 출력하기
			// 3. 종료
		}
	}
}
