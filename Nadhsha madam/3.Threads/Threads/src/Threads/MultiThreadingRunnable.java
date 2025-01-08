package Threads;

public class MultiThreadingRunnable implements Runnable {

    private int threadId;

    public MultiThreadingRunnable(int threadId) {
        this.threadId = threadId;
    }

    public void run() {
        for(int i = 0; i <= 5; i++) {
            System.out.println("Thread: " + threadId + " Value: " + i);
//            if(threadId==2) {
//                throw new RuntimeException("Thread 2 is throwing an exception");
//            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
