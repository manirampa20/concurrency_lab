package org.example.assignment.collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class WordFrequencyCounter {
    private ConcurrentHashMap<String, AtomicInteger> wordCounts = new ConcurrentHashMap<>();

    // Method to count words in a chunk of text
    public void countWords(String[] words) {
        for (String word : words) {
            wordCounts.computeIfAbsent(word, k -> new AtomicInteger()).incrementAndGet();
        }
    }

    public void printWordCounts() {
        wordCounts.forEach((word, count) -> System.out.println(word + ": " + count));
    }

    // The main method to run the application
    public static void main(String[] args) {
        WordFrequencyCounter counter = new WordFrequencyCounter();

        // Example text split into chunks for multiple threads
        String[] text1 = "this is a sample text with several words this is".split(" ");
        String[] text2 = "another sample text with different words and different counts".split(" ");
        String[] text3 = "more text with some repeated words text text text".split(" ");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to count words in each chunk
        executor.submit(() -> counter.countWords(text1));
        executor.submit(() -> counter.countWords(text2));
        executor.submit(() -> counter.countWords(text3));

        // Shut down the executor and wait for tasks to finish
        executor.shutdown();
        while (!executor.isTerminated()) {}

        // Print the final word counts
        counter.printWordCounts();
    }
}
