package com.rjm.io.file.rw;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {
	private Scanner sc;
	private MemberInfo mi;
	private MemberView mv;
	private ArrayList<Member> ar;
	private MemberAdd ma;

	public MemberController() {
		sc = new Scanner(System.in);
		mi = new MemberInfo();
		mv = new MemberView();
		ma = new MemberAdd();
	}

	// 메서드명 start

	public void start() {

		boolean check = true;

		while (check) {
			System.out.println("1. 멤버 정보 가져오기"); // info getMembers
			System.out.println("2. 멤버 정보 출력하기"); // MemberView
			System.out.println("3. 멤버 검색 출력하기");
			System.out.println("4. 그룹 검색 출력하기");
			System.out.println("5. 멤버 추가");
			System.out.println("6. 백     업");
			System.out.println("7. 종     료");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				ar = mi.getMembers();
				break;
			case 2:
				mv.view(ar);
				break;
			case 3:
				Member m = mi.searchMember(sc, ar);
				if (m != null) {

					mv.view(m);
				} else {
					mv.view("멤버가 존재하지 않습니다.");
				}
				break;
			case 4:
				ArrayList<Member> search = mi.searchGroup(sc, ar);
				if (search.size() > 0) {
					mv.view(search);
				} else {
					mv.view("해당 데이터가 없습니다.");
				}
				break;
			case 5:
				Member m1 = ma.addMember(sc, ar);
				ar.add(m1);
				break;
			case 6:
				ma.backUp(ar);
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
