//package org.example.assignment;
//
//public class ConcurrencyExample {
//
//    // Instance method to start tasks
//    public void startTasks() {
//        // Task 1: Print numbers
//        Thread thread1 = new Thread(() -> {
//            for (int i = 1; i <= 5; i++) {
//                System.out.print(i);
//                try {
//                    Thread.sleep(1000); // Sleep for 100 milliseconds
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        // Task 2: Print letters
//        Thread thread2 = new Thread(() -> {
//            for (char c = 'A'; c <= 'E'; c++) {
//                System.out.print(c);
//                try {
//                    Thread.sleep(1000); // Sleep for 100 milliseconds
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        // Start both threads
//        thread1.start();
//        thread2.start();
//
//        // Wait for both threads to finish before exiting the main thread
//        try {
//            thread1.join();
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Print a newline for better output formatting
//        System.out.println();
//    }
//
//    // Main method to create an instance and call the instance method
//    public static void main(String[] args) {
//        // Create an instance of ConcurrencyExample
//        ConcurrencyExample example = new ConcurrencyExample();
//        // Call the instance method to start tasks
//        example.startTasks();
//    }
//}


package org.example.assignment;

public class ConcurrencyExample {

    // Instance method to start tasks
    public void startTasks() {
        // Task 1: Print numbers
        for (int i = 1; i <= 5; i++) {
            System.out.print(i);
            try {
                Thread.sleep(1000); // Sleep for 1000 milliseconds (1 second)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Task 2: Print letters
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.print(c);
            try {
                Thread.sleep(1000); // Sleep for 1000 milliseconds (1 second)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print a newline for better output formatting
        System.out.println();
    }

    // Main method to create an instance and call the instance method
    public static void main(String[] args) {
        // Create an instance of ConcurrencyExample
        ConcurrencyExample example = new ConcurrencyExample();
        // Call the instance method to start tasks
        example.startTasks();
    }
}

