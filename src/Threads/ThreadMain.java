// Java. Полное руководство - Г.Шилдт
// Thread, ThreadGroup и Runnable
// стр. 629

package Threads;

class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (valueSet)
            try {
                System.out.println("GetWait");
                wait();
            } catch (Exception e) {
            }
        System.out.println("Get: " + n);
        valueSet = true;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet)
            try {
                System.out.println("PutWait");
                wait();
            } catch (Exception e) {
            }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }

    synchronized void asd() {
        while (!valueSet)
            try {
                System.out.println("AsdWait");
                wait();
            } catch (Exception e) {
            }
        System.out.println("Threads.Asd: " + n);
        valueSet = false;
        notify();
    }
}

class Producer implements Runnable {
    Q q;
    Thread t;

    Producer(Q q) {
        this.q = q;
        t = new Thread(this, "Threads.Producer");
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Q q;
    Thread t;

    Consumer(Q q) {
        this.q = q;
        t = new Thread(this, "Threads.Consumer");
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}

class Asd implements Runnable {
    Q q;
    Thread t;

    Asd(Q q) {
        this.q = q;
        t = new Thread(this, "Threads.Asd");
    }

    @Override
    public void run() {
        while (true) {
            q.asd();
        }
    }
}

public class ThreadMain {
    public static void main(String[] args) {
        Q q = new Q();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);
        Asd z = new Asd(q);

        p.t.start();
        c.t.start();
        z.t.start();
    }
}