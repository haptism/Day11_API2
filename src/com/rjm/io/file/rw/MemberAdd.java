package com.rjm.io.file.rw;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MemberAdd {

	// backUp
	// 파일의저장경로 : 원래파일에 덮어쓰기.

	public void backUp(ArrayList<Member> ar) {

		File file = new File("C:\\test", "readTest.txt");
		FileWriter fw = null;

		try {
			fw = new FileWriter(file);
			fw.write("start\r\n");
			// 형태
			for (Member m : ar) {

//				String result = m.getTeam() + "-";
//				result = result + m.getName() + "-";
//				result = result + m.getAge() + "-";

				StringBuffer sb = new StringBuffer();
				sb.append(m.getTeam());
				sb.append("-");
				sb.append(m.getName());
				sb.append("-");
				sb.append(m.getAge());
				sb.append("-");
				sb.append(m.getPosition());
				sb.append("-");
				sb.append(m.getCompany());
				sb.append("\r\n");
				fw.write(sb.toString());
				fw.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				fw.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Backup 완료");
	}

	// addMember
	public Member addMember(Scanner sc, ArrayList<Member> ar) {
		Member member = new Member();
		System.out.println("그룹명 입력 ");
		member.setTeam(sc.next());
		System.out.println("이름 입력");
		member.setName(sc.next());
		System.out.println("나이 입력 ");
		member.setAge(sc.nextInt());
		System.out.println("역활 입력 ");
		member.setPosition(sc.next());
		System.out.println("소속사 입력");
		member.setCompany(sc.next());
		// ar.add(member);
		return member;

	}

}