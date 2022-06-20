package com.concurrency;

import com.datastructureimpl.StackImpl;

import java.text.SimpleDateFormat;

public class ThreadSafeFormatter {

    public static ThreadLocal<SimpleDateFormat>  dateFormatter=new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd");
        }
        public SimpleDateFormat get(){
            return super.get();
        }


    };
}
