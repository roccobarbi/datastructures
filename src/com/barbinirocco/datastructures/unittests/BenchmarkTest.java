/**
 * 
 */
package com.barbinirocco.datastructures.unittests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.barbinirocco.datastructures.ResizingStack;
import com.barbinirocco.datastructures.exceptions.OverflowException;

/**
 * @author rocco barbini (roccobarbi@gmail.com)
 *
 */
public class BenchmarkTest {
	
	private static void individualBenchmarkPush(int testSize) throws OverflowException {
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
		System.out.print(">> ");
		System.out.print(testSize);
		System.out.println(" elements pushed <<");
		System.out.print("Min push time (ns): ");
		System.out.println(minTime);
		System.out.print("Average push time (ns): ");
		System.out.println(timeAccumulator / testSize);
		System.out.print("Max push time (ns): ");
		System.out.println(maxTime);
	}
	
	private static void benchmarkPush() {
		int testSizes[] = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
		try {
			for (int size: testSizes) {
				individualBenchmarkPush(size);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BenchmarkTest.benchmarkPush();
	}

}
