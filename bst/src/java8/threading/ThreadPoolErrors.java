package java8.threading;

import java.util.concurrent.*;

public class ThreadPoolErrors extends ThreadPoolExecutor {
    public ThreadPoolErrors() {
        super(  1, // core threads
                1, // max threads
                1, // timeout
                TimeUnit.MINUTES, // timeout units
                new LinkedBlockingQueue() // work queue
        );
    }

//    protected void afterExecute(Runnable r, Throwable t) {
//        super.afterExecute(r, t);
//        if(t != null) {
//            System.out.println("Got an error: " + t);
//        } else {
//            System.out.println("Everything's fine--situation normal!");
//        }
//    }

    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t == null && r instanceof Future<?>) {
            try {
                Future<?> future = (Future<?>) r;
                if (future.isDone()) {
                    future.get();
                }
            } catch (CancellationException ce) {
                t = ce;
            } catch (ExecutionException ee) {
                t = ee.getCause();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt(); // ignore/reset
            }
        }
        if (t != null) {
            System.out.println(t);
        }
    }


    public static void main( String [] args) {
        ThreadPoolErrors threadPool = new ThreadPoolErrors();
        threadPool.submit( 
                new Runnable() {
                    public void run() {

                        throw new RuntimeException("Ouch! Got an error.");
                    }
                }
        );
        threadPool.shutdown();
    }
}