package com.learning;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorExample implements Runnable {

	@Override
	public void run() {
		System.out.println("running");
	}
	
	public static void main(String args[])
	{
		Executor ex=Executors.newSingleThreadExecutor();
		ex.execute(new ExecutorExample());
	}

}
