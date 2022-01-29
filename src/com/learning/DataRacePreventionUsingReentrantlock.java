package com.learning;

import java.util.concurrent.locks.ReentrantLock;

public class DataRacePreventionUsingReentrantlock extends Thread{

	private static int counter = 0;
	ReentrantLock pencil = new ReentrantLock();

	public void run() {
		pencil.lock();
		for (int i = 0; i < 5; i++) {
			++counter;
		}
		pencil.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		DataRacePreventionUsingReentrantlock d1 = new DataRacePreventionUsingReentrantlock();
		DataRacePreventionUsingReentrantlock d2 = new DataRacePreventionUsingReentrantlock();
		d1.start();
		d2.start();
		d1.join();
		d2.join();
		System.out.println(DataRacePreventionUsingReentrantlock.counter);
	}

}
