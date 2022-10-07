package effort_2022;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Simulation {

    static AtomicBoolean ab = new AtomicBoolean(false);

    static class Server {
        public synchronized int rcv(int id) {
            System.out.println(id);
            if (ab.get()) {
                if (id == totalCustomer) error.compute("Canary", (k, v) -> v == null ? 1 : v + 1);
                else error.compute("Customer", (k, v) -> v == null ? 1 : v + 1);
            }
            ab.set(false);
            map.compute(id, (k, v) -> v == null ? 1 : v + 1);
            return id;
        }
    }

    static ConcurrentHashMap<Integer, Integer> map;
    static ConcurrentHashMap<String, Integer> error = new ConcurrentHashMap<>();
    static final int totalNumberOfRequest = 10000;
    static final int totalCustomer = 100;// we will consider 50th as our canary

    static class CustomerThread implements Runnable {
        int id;
        Server server;

        CustomerThread(int id, Server server) {
            this.id = id;
            this.server = server;
        }

        @Override
        public void run() {
            for (int i = 0; i < totalNumberOfRequest; i++) {
                int res = server.rcv(id);
               // System.out.println("Result: " + res);
            }
        }
    }


    public static void main(String[] args) {
        long start = System.nanoTime();
        map = new ConcurrentHashMap();
        ExecutorService executor = Executors.newFixedThreadPool(totalCustomer);
        Server s=new Server();
        for (int i = 1; i <= totalCustomer; i++) {
            Thread worker = new Thread(new CustomerThread(i, s));
            executor.execute(worker);
        }


        int x = 0;
        while (x < 10) {
            try {
                ab.set(true);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            x++;
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        long end = System.nanoTime();
        System.out.println("total: "+(end - start) / 1000000);
        System.out.println(map);
        System.out.println(error);
    }
}
