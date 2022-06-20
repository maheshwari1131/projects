package com.concurrency;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService {
    private static ExecutorService threadpool= Executors.newFixedThreadPool(10);

    public static void main(String args[]){
        for(int i=0;i<1000;i++){
            int id=i;
            threadpool.submit(()->{


            });
        }



    }

    public String birthDate(int userId){
        Date date=birthDateFromDb(userId);
        final SimpleDateFormat df=ThreadSafeFormatter.dateFormatter.get();
        return df.format(date);
    }

    private static Date birthDateFromDb(int userId) {
        return null;
    };


}
