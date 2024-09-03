package org.example.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class PerformanceComparison {

    public static void main(String[] args) {
        int numElements = 10000000;
        int numThreads = 10;

        // Comparing HashMap with ConcurrentHashMap
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        System.out.println("HashMap Performance:");
        measureMapPerformance(hashMap, numElements, numThreads);

        System.out.println("ConcurrentHashMap Performance:");
        measureMapPerformance(concurrentHashMap, numElements, numThreads);

        // Comparing ArrayList with CopyOnWriteArrayList
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        System.out.println("ArrayList Performance:");
        measureListPerformance(arrayList, numElements, numThreads);

        System.out.println("CopyOnWriteArrayList Performance:");
        measureListPerformance(copyOnWriteArrayList, numElements, numThreads);
    }

    private static void measureMapPerformance(Map<Integer, Integer> map, int numElements, int numThreads) {
        long startTime = System.nanoTime();

        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < numElements / numThreads; j++) {
                    map.put(j, j);
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("Time taken: " + duration + " ms");
    }

    private static void measureListPerformance(List<Integer> list, int numElements, int numThreads) {
        long startTime = System.nanoTime();

        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < numElements / numThreads; j++) {
                    list.add(j);
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("Time taken: " + duration + " ms");
    }
}
