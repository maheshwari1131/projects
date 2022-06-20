package com.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private static ReentrantLock lock=new ReentrantLock();
    private static void accessResource(){
        lock.lock();
        lock.lock();
        try {

            //acess the Resources


            lock.getHoldCount();//number times locked
        }finally{
            lock.unlock();


        }
        boolean lockAcquired=lock.tryLock();
        if(lockAcquired){
            try{
                //access resources
            }finally {
                lock.unlock();
            }
        }else{
            //do something else
        }

    }
    public static void main(String[] args){
        Thread t1=new Thread(()->accessResource());
        t1.start();
        Thread t2=new Thread(()->accessResource());
        t2.start();
        Thread t3=new Thread(()->accessResource());
        t3.start();
    }
}
