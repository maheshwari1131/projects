package com.apiratelimit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SimpleRateLimiter {
    private Semaphore semapore;
    private int maxpermits;
    private TimeUnit timePeroid;
    private ScheduledExecutorService scheduler;

    public SimpleRateLimiter(int permits, TimeUnit timePeriod) {
        this.semapore=new Semaphore(permits);
        this.maxpermits=permits;
        this.timePeroid=timePeriod;
    }

    public static SimpleRateLimiter create(int permits,TimeUnit timePeriod){
        SimpleRateLimiter limiter=new SimpleRateLimiter(permits,timePeriod);
        limiter.scheduleReplenishment();
        return limiter;
    }

    public boolean tryAcquire(){
        return semapore.tryAcquire();
    }

    public void stop(){
        scheduler.shutdownNow();
    }

    private void scheduleReplenishment() {
        scheduler= Executors.newScheduledThreadPool(1);
        //scheduler.schedule(()->semapore.release()(maxpermits))
    }

    ;
}
