package com.rjm.io.file.rw;

import java.util.ArrayList;

public class HungryView {

	public void view(String h) {

		System.out.println(h);

	}

	public void view(Hungry h) {

		System.out.println("타임 : " + h.getTime() + "\t");
		System.out.println("메뉴 : " + h.getFood() + "\t");
	}

	public void view(ArrayList<Hungry> ar) {
		for (Hungry h : ar) {

			System.out.println("타임 : " + h.getTime() + "\t");
			System.out.println("메뉴 : " + h.getFood() + "\t");

		}

	}
}
