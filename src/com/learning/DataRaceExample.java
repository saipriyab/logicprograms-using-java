package com.learning;

public class DataRaceExample extends Thread{
	
	private static int counter=0;
	
	public void run()
	{
		for(int i=0;i<2000000;i++)
			++counter;
	}

	public static void main(String[] args) throws InterruptedException {
		DataRaceExample d1=new DataRaceExample();
		DataRaceExample d2=new DataRaceExample();
		d1.start();
		d2.start();
		d1.join();
		d2.join();
		System.out.println(DataRaceExample.counter);
	}

}
