package com.concurrency;

public class UserCOntextHolder {
    public static ThreadLocal<User> holder= new ThreadLocal();


}
class User{
    int userid;
    int name;
}
class Servcie1{
    public void process(){
        User user=getUserFromRequest();
        UserCOntextHolder.holder.set(user);
    }

    private User getUserFromRequest() {
        return null;
    }
}

class Service2{
    public void process(){
        // get user for this thread;
        User user=UserCOntextHolder.holder.get();
    }
}
