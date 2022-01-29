package com.learning;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataRacePreventionUsingMutualExclusion extends Thread{

	private static int counter = 0;
	Lock pencil = new ReentrantLock();

	public void run() {
		pencil.lock();
		for (int i = 0; i < 5; i++) {
			++counter;
			System.out.println(Thread.currentThread().getName() + "thinking");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		pencil.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		DataRacePreventionUsingMutualExclusion d1 = new DataRacePreventionUsingMutualExclusion();
		DataRacePreventionUsingMutualExclusion d2 = new DataRacePreventionUsingMutualExclusion();
		d1.start();
		d2.start();
		d1.join();
		d2.join();
		System.out.println(DataRacePreventionUsingMutualExclusion.counter);
	}

}
