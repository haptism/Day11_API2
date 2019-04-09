package com.rjm.io.file.rw;

import java.util.ArrayList;

public class MemberView {
	public void view(String s) {
		System.out.println(s);

	}

	// member 하나를 출력하는 메서드
	public void view(Member s) {
		System.out.print("그룹명 : " + s.getTeam() + "\t");
		System.out.print("이   름 : " + s.getName() + "\t");
		System.out.print("나   이 : " + s.getAge() + "\t");
		System.out.print("역   활 : " + s.getPosition() + "\t");
		System.out.println("소속사 : " + s.getCompany());

	}

	// view 메서드명

	public void view(ArrayList<Member> ar) {
		for (Member s : ar) {
			// 그룹명 이름 나이 역활 소속사
			System.out.print("그룹명 : " + s.getTeam() + "\t");
			System.out.print("이   름 : " + s.getName() + "\t");
			System.out.print("나   이 : " + s.getAge() + "\t");
			System.out.print("역   활 : " + s.getPosition() + "\t");
			System.out.println("소속사 : " + s.getCompany());
		}
	}
}