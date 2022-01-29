package com.learning;

public class DataRacePreventionUsingSynchronizedMethod extends Thread {

	static int counter = 0;

	private static synchronized void increment() {
		++counter;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			increment();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		DataRacePreventionUsingSynchronizedMethod d1 = new DataRacePreventionUsingSynchronizedMethod();
		DataRacePreventionUsingSynchronizedMethod d2 = new DataRacePreventionUsingSynchronizedMethod();
		d1.start();
		d2.start();
		d1.join();
		d2.join();
		System.out.println(DataRacePreventionUsingSynchronizedMethod.counter);
	}

}
