/**
 * 
 */
package com.barbinirocco.datastructures.unittests;

import com.barbinirocco.datastructures.DoublyLinkedList;
import com.barbinirocco.datastructures.ResizingQueue;
import com.barbinirocco.datastructures.ResizingStack;
import com.barbinirocco.datastructures.exceptions.OverflowException;

/**
 * @author rocco barbini (roccobarbi@gmail.com)
 *
 */
public class BenchmarkTest {
	
	private static void printResultsSingleTestHead() {
		System.out.printf("%-15s%-10s%-10s%-10s\n", "elements", "min (ns)", "avg (ns)", "max (ns)");
	}
	
	private static void printResultsSingleTestLine(int testSize, long avgSize, long minTime, long maxTime) {
		System.out.printf("%-,15d%-,10d%-,10d%-,10d\n", testSize, minTime, avgSize, maxTime);
	}
	
	private static void resizingStackSingleSizeBenchmark(int testSize) throws OverflowException {
		long timeAccumulator = 0, startTime, minTime = Long.MAX_VALUE, maxTime = Long.MIN_VALUE, curTime;
		ResizingStack<Integer> stack =  new ResizingStack<Integer>(10, Integer.valueOf(1));
		boolean testError = false;
		for (int i = 0; i < testSize; i++) {
			try {
				startTime = System.nanoTime();
				stack.push(i);
				curTime = System.nanoTime() - startTime;
				timeAccumulator += curTime;
				minTime = Long.min(minTime, curTime);
				maxTime = Long.max(maxTime, curTime);
			} catch (Error e) {
				stack = null; // enable garbage collection
				System.out.println("Exception encountered: " + e.getMessage());
				System.out.printf("Exception caused by index: %,d\n", i);
				testError = true;
				break;
			}
		}
		if (!testError)
			printResultsSingleTestLine(testSize, timeAccumulator / testSize, minTime, maxTime);
	}
	
	private static void resizingStackBenchmark() {
		int testSizes[] = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
		try {
			System.out.println("\nResizingStack");
			printResultsSingleTestHead();
			for (int size: testSizes) {
				resizingStackSingleSizeBenchmark(size);
			}
		} catch (Exception e) {
			System.out.println("Exception encountered: " + e.getMessage());
		}
	}
	
	private static void resizingQueueSingleSizeBenchmark(int testSize) throws OverflowException {
		long timeAccumulator = 0, startTime, minTime = Long.MAX_VALUE, maxTime = Long.MIN_VALUE, curTime;
		ResizingQueue<Integer> queue =  new ResizingQueue<Integer>(10, Integer.valueOf(1));
		boolean testError = false;
		for (int i = 0; i < testSize; i++) {
			try {
				startTime = System.nanoTime();
				queue.enqueue(i);
				curTime = System.nanoTime() - startTime;
				timeAccumulator += curTime;
				minTime = Long.min(minTime, curTime);
				maxTime = Long.max(maxTime, curTime);
			}   catch (Error e) {
				queue = null; // enable garbage collection
				System.out.println("Exception encountered: " + e.getMessage());
				System.out.printf("Exception caused by index: %,d\n", i);
				testError = true;
				break;
			}
		}
		if (!testError)
			printResultsSingleTestLine(testSize, timeAccumulator / testSize, minTime, maxTime);
	}
	
	private static void resizingQueueBenchmark() {
		int testSizes[] = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
		try {
			System.out.println("\nResizingQueue");
			printResultsSingleTestHead();
			for (int size: testSizes) {
				resizingQueueSingleSizeBenchmark(size);
			}
		} catch (Exception e) {
			System.out.println("Exception encountered: " + e.getMessage());
		}
	}
	
	private static void DoublyLinkedListSingleSizeBenchmark(int testSize) throws OverflowException {
		long timeAccumulator = 0, startTime, minTime = Long.MAX_VALUE, maxTime = Long.MIN_VALUE, curTime;
		DoublyLinkedList<Integer, Integer> list =  new DoublyLinkedList<Integer, Integer>(Integer.valueOf(1), Integer.valueOf(1));
		boolean testError = false;
		for (int i = 0; i < testSize; i++) {
			try {
				startTime = System.nanoTime();
				list.insert(i, i);;
				curTime = System.nanoTime() - startTime;
				timeAccumulator += curTime;
				minTime = Long.min(minTime, curTime);
				maxTime = Long.max(maxTime, curTime);
			}  catch (Error e) {
				list = null;  // enable garbage collection
				System.out.println("Exception encountered: " + e.getMessage());
				System.out.printf("Exception caused by index: %,d\n", i);
				testError = true;
				break;
			}
		}
		if (!testError)
			printResultsSingleTestLine(testSize, timeAccumulator / testSize, minTime, maxTime);
	}
	
	private static void DoublyLinkedListBenchmark() {
		int testSizes[] = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
		try {
			System.out.println("\nDoublyLinkedList");
			printResultsSingleTestHead();
			for (int size: testSizes) {
				DoublyLinkedListSingleSizeBenchmark(size);
			}
		} catch (Exception e) {
			System.out.println("Exception encountered: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		BenchmarkTest.resizingStackBenchmark();
		BenchmarkTest.resizingQueueBenchmark();
		BenchmarkTest.DoublyLinkedListBenchmark();
	}

}
