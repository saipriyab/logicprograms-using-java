package com.learning;

public class DataRacePreventionUsingSynchronizedStatement extends Thread {

	static int counter = 0;

	public void run() {

		for (int i = 0; i < 5; i++) {
			synchronized (DataRacePreventionUsingSynchronizedStatement.class) {
				++counter;
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		DataRacePreventionUsingSynchronizedStatement d1 = new DataRacePreventionUsingSynchronizedStatement();
		DataRacePreventionUsingSynchronizedStatement d2 = new DataRacePreventionUsingSynchronizedStatement();
		d1.start();
		d2.start();
		d1.join();
		d2.join();
		System.out.println(DataRacePreventionUsingSynchronizedStatement.counter);
	}

}
