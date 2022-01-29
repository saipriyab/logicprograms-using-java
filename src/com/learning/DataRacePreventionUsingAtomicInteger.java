package com.learning;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataRacePreventionUsingAtomicInteger extends Thread {

	static AtomicInteger counter = new AtomicInteger();

	public void run() {

		for (int i = 0; i < 5; i++) {
			counter.getAndIncrement();

		}

	}

	public static void main(String[] args) throws InterruptedException {
		DataRacePreventionUsingAtomicInteger d1 = new DataRacePreventionUsingAtomicInteger();
		DataRacePreventionUsingAtomicInteger d2 = new DataRacePreventionUsingAtomicInteger();
		d1.start();
		d2.start();
		d1.join();
		d2.join();
		System.out.println(DataRacePreventionUsingAtomicInteger.counter);
	}

}
