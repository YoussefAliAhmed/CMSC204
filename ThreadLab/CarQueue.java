package Labs.ThreadLab;

import java.util.*;

public class CarQueue {
    private Queue<Integer> queue;

    public CarQueue() {
        queue = new LinkedList<Integer>();
        Random r = new Random();
        queue.add(r.nextInt(4));
        queue.add(r.nextInt(4));
        queue.add(r.nextInt(4));
        queue.add(r.nextInt(4));
        queue.add(r.nextInt(4));
        queue.add(r.nextInt(4));
    }

    public int deleteQueue() {
        return queue.remove();
    }

    public void addToQueue() {
        class Threader implements Runnable {
            @Override
            public void run() {
                try {
                    while (true) {
                        Random r = new Random();
                        queue.add(r.nextInt(4));
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Threader thread = new Threader();
        Thread t = new Thread(thread);
        t.start();
    }

}