package com.rjm.thread;

public class ThreadEat extends Thread {

	@Override
	public void run() {
		// 동시 진행하고싶은 코드
		eat();
	}

	public void eat() {

		for (int i = 0; i < 10; i++) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("쫩 쫩 쩝 쩝 쩝 쩝 쩝");
		}
	}
}
