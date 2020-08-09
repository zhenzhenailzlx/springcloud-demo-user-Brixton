package com.zhenzhen.demo.admin.controller;

import java.util.concurrent.locks.ReentrantLock;

public class DemoAQSThread extends Thread{
	
	private static ReentrantLock reentrantLock = new ReentrantLock();
	

	public static void main(String[] args) {
		
		DemoAQSThread threadA = new DemoAQSThread();
		threadA.setName("ThreadA");
		threadA.start();
		
		DemoAQSThread threadB = new DemoAQSThread();
		threadB.setName("ThreadB");
		threadB.start();
		
	}

	@Override
	public void run() {
		System.out.println("hello"+Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
