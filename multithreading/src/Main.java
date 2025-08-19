import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static ReentrantLock lock = new ReentrantLock();
    private static void accessResource() {
//        System.out.println("Trying to access the resource " + Thread.currentThread().getName());
        lock.lock();
        try {
//            System.out.println("locking the resource " + Thread.currentThread().getName());
            System.out.println("Acquired the resource Thread " + Thread.currentThread().getName());
        } finally {
//            System.out.println("unlocking the resource " + Thread.currentThread().getName());
            lock.unlock();

        }
    }

    public static void main(String[] args) {
        System.out.println("Main is starting");
        Thread thread1 = new Thread(()-> {accessResource();
        accessResource();});
        Thread thread2 = new Thread(()-> {accessResource();
            accessResource();});
        Thread thread3 = new Thread(()-> {accessResource();
            accessResource();});
        Thread thread4 = new Thread(()-> {accessResource();
            accessResource();});
        Thread thread5 = new Thread(()-> {accessResource();
            accessResource();});
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
//        Thread1 thread1= new Thread1("thread class");
//        Thread thread2 = new Thread(()->{
//        try {
//            Thread.sleep(10);
//            for(int i=1;i<5;i++){
//
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        });
//
//        thread1.start();
//        thread2.start();
//        while(true){
//            Thread.State state = thread2.getState();
//            System.out.println(state);
//            if(state== Thread.State.TERMINATED){
//                break;
//            }
//        }

        Thread thr1 = new Thread(()->
            System.out.println("thread")
        );
        thr1.start();
        Thread thread= new Thread();
        thread.start();
        // deadlock
        String lock1="lock1";
        String lock2="lock2";

//        Thread thread1 = new Thread(()->{
//            synchronized (lock1){
//                System.out.println("lock 1 is acquired by "+Thread.currentThread().getName());
//                synchronized (lock2){
//                    System.out.println("lock 2 is acquired by "+Thread.currentThread().getName());
//                }
//            }
//        },"thread 1");
//        Thread thread2 = new Thread(()->{
//            synchronized (lock2){
//                System.out.println("lock 2 is acquired by "+Thread.currentThread().getName());
//                synchronized (lock1){
//                    System.out.println("lock 1 is acquired by "+Thread.currentThread().getName());
//                }
//            }
//        },"thread 2");
//        thread1.start();
//        thread2.start();
//        System.out.println("Main is exiting");
    }
}