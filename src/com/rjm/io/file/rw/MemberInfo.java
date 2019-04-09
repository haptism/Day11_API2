package com.rjm.io.file.rw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberInfo {
	// searchGroup Scanner, ArrayList
	// 1. 그룹명, 2. 소속사

	private ArrayList<Member> searchCompany(Scanner sc, ArrayList<Member> ar) {
		ArrayList<Member> search = new ArrayList<Member>();
		System.out.println("소속사 입력");
		String name = sc.next();
		for (Member m : ar) {
			if (name.equals(m.getCompany())) {
				search.add(m);
			}
		}
		return search;
	}

	private ArrayList<Member> searchTeam(Scanner sc, ArrayList<Member> ar) {
		ArrayList<Member> search = new ArrayList<Member>();
		System.out.println("그룹명 입력");
		String name = sc.next();
		for (Member m : ar) {
			if (name.equals(m.getTeam())) {
				search.add(m);
			}
		}
		return search;
	}

	public ArrayList<Member> searchGroup(Scanner sc, ArrayList<Member> ar) {
		ArrayList<Member> search = null;
		System.out.println("1. 그룹명");
		System.out.println("2. 소속사");
		int select = sc.nextInt();
		if (select == 1) {
			search = this.searchTeam(sc, ar);
		} else {
			search = this.searchCompany(sc, ar);
		}
		return search;
	}

	// 메서드명 searchMember, Scanner, Arr.
	// 이름을 입력해서 멤버찾기
	
	public Member searchMember(Scanner sc, ArrayList<Member> ar) {
		System.out.println("검색할 이름 입력");
		String name = sc.next();
		Member member = null;
		for (Member m : ar) {
			if (name.equals(m.getName())) {
				member = m;
				break;
			}
		}
		return member;
	}

	// 메서드명 getMembers
	public ArrayList<Member> getMembers() {
		File file = new File("c:\\test", "readTest.txt");
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<Member> ar = new ArrayList<Member>();
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			// \n 개행문자
			String str = null;
			br.readLine();
			while (true) {
				str = br.readLine();

				if (str == null) {
					break;
				}
				String[] names = str.split("-");
				Member member = new Member();
				member.setTeam(names[0]);
				member.setName(names[1]);
				member.setAge(Integer.parseInt(names[2].trim()));
				member.setPosition(names[3]);
				member.setCompany(names[4]);
				ar.add(member);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ar;
	}
}