package com.learning;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataRacePreventionUsingTryLock extends Thread{

	private static int counter = 0;
	Lock pencil = new ReentrantLock();

	public void run() {
		pencil.tryLock();
		for (int i = 0; i < 5; i++) {
			++counter;
		}
		pencil.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		DataRacePreventionUsingTryLock d1 = new DataRacePreventionUsingTryLock();
		DataRacePreventionUsingTryLock d2 = new DataRacePreventionUsingTryLock();
		d1.start();
		d2.start();
		d1.join();
		d2.join();
		System.out.println(DataRacePreventionUsingTryLock.counter);
	}

}
