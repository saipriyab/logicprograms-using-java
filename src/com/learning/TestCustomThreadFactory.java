package com.learning;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class CustomThreadFactory implements ThreadFactory {

	private int counter = 0;

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName("Custom Thread " + (++counter));
		return null;
	}

}

class ExecutorEx implements Runnable {

	@Override
	public void run() {
		System.out.println("running");
	}

}

public class TestCustomThreadFactory {
	public static void main(String args[]) {
		Executor ex = Executors.newFixedThreadPool(1, new CustomThreadFactory());
		ex.execute(new ExecutorExample());
	}
}
