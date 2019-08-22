/**
 * 
 */
package com.barbinirocco.datastructures.unittests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

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
		for (int i = 0; i < testSize; i++) {
			startTime = System.nanoTime();
			stack.push(i);
			curTime = System.nanoTime() - startTime;
			timeAccumulator += curTime;
			minTime = Long.min(minTime, curTime);
			maxTime = Long.max(maxTime, curTime);
		}
		printResultsSingleTestLine(testSize, timeAccumulator / testSize, minTime, maxTime);
	}
	
	private static void resizingStackBenchmark() {
		int testSizes[] = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
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
		for (int i = 0; i < testSize; i++) {
			startTime = System.nanoTime();
			queue.enqueue(i);
			curTime = System.nanoTime() - startTime;
			timeAccumulator += curTime;
			minTime = Long.min(minTime, curTime);
			maxTime = Long.max(maxTime, curTime);
		}
		printResultsSingleTestLine(testSize, timeAccumulator / testSize, minTime, maxTime);
	}
	
	private static void resizingQueueBenchmark() {
		int testSizes[] = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
		try {
			System.out.println("\nResizingQueue");
			printResultsSingleTestHead();
			for (int size: testSizes) {
				resizingStackSingleSizeBenchmark(size);
			}
		} catch (Exception e) {
			System.out.println("Exception encountered: " + e.getMessage());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BenchmarkTest.resizingStackBenchmark();
		BenchmarkTest.resizingQueueBenchmark();
	}

}
