package com.rjm.io.file.rw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MemberInfo {

	// 메서드명 searchMember, Scanner, ArrayList
	// 이름을 입력해서 멥버 찾기

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
