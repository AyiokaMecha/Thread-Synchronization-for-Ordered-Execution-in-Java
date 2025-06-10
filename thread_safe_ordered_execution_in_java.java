import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class CountDownLatch_synchronization {
    private CountDownLatch latch1 = new CountDownLatch(1);
    private CountDownLatch latch2 = new CountDownLatch(1);

    public Foo() {}

    public void first() {
        System.out.print("first");
        latch1.countDown();
    }

    public void second() throws InterruptedException {
        latch1.await();
        System.out.print("second");
        latch2.countDown();
    }

    public void third() throws InterruptedException {
        latch2.await();
        System.out.print("third");
    }
}

public class Synchronized_methods_with_flags {
    private boolean firstDone = false;
    private boolean secondDone = false;

    public Foo() {}

    public synchronized void first() {
        System.out.print("first");
        firstDone = true;
        notifyAll();
    }

    public synchronized void second() throws InterruptedException {
        while (!firstDone) {
            wait();
        }
        System.out.print("second");
        secondDone = true;
        notifyAll();
    }

    public synchronized void third() throws InterruptedException {
        while (!secondDone) {
            wait();
        }
        System.out.print("third");
    }
}



public class Semaphore_synchronization {
    private Semaphore sem2 = new Semaphore(0);
    private Semaphore sem3 = new Semaphore(0);

    public Foo() {}

    public void first() {
        System.out.print("first");
        sem2.release();
    }

    public void second() throws InterruptedException {
        sem2.acquire();
        System.out.print("second");
        sem3.release();
    }

    public void third() throws InterruptedException {
        sem3.acquire();
        System.out.print("third");
    }
}