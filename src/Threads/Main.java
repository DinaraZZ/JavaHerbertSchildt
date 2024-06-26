// Java. Полное руководство - Г.Шилдт
// Thread, ThreadGroup и Runnable
// стр. 629

package Threads;

class E {
    synchronized void q (int i) {
        System.out.println("q " + i);
        try {
            Thread.sleep(100);
        } catch (Exception e) {}
        System.out.println("q " + i);

        try {
            Thread.sleep(100);
        } catch (Exception e) {}
        System.out.println("q " + i);

    }

   synchronized void w () {
        System.out.println("w");
        try {
            Thread.sleep(100);
        } catch (Exception e) {}
        System.out.println("w");
        try {
            Thread.sleep(100);
        } catch (Exception e) {}
        System.out.println("w");
    }
}

class R implements Runnable {
    Thread t;
    int i = 1;
    E e;
    R (E e, int i) {
        this.i = i;
        this.e = e;
        t = new Thread(this);
    }

    @Override
    public void run() {
        e.q(i);
    }
}

class U implements Runnable {
    Thread t;
    E e;
    U (E e) {
        this.e = e;
        t = new Thread(this);
    }

    @Override
    public void run() {
        e.w();
    }
}
public class Main {
    public static void main(String[] args) {
        E e = new E();

        R r = new R(e, 1);
        R r2 = new R(e, 2);
        U u = new U(e);

        r.t.start();
        r2.t.start();
        u.t.start();
    }
}