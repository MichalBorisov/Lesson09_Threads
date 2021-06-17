package com.company;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static HashMap<Integer, Lock> forkList = new HashMap<Integer, Lock>(){};
    private static HashMap<Integer,Thread1> Philosophers = new HashMap<Integer,Thread1>();

    public static void main(String[] args) {
            setForkList();
            Philosophers.put(0,new Thread1("Don",0 ));
            Philosophers.put(1,new Thread1("James",1 ));
            Philosophers.put(2,new Thread1("Dio",2 ));
            Philosophers.put(3,new Thread1("Ozzy",3 ));
            Philosophers.put(4,new Thread1("Ian",4 ));
            Philosophers.put(5,new Thread1("Malcolm",5 ));
            Philosophers.put(6,new Thread1("Angus",6 ));
            Philosophers.put(7,new Thread1("Axel",7 ));
            Philosophers.put(8,new Thread1("Carmack",8 ));
            Philosophers.put(9,new Thread1("Romero",9));

            startFeast();

    }

    private static void setForkList()
    {
        for(int i = 0; i < 10; i++)
        {
            forkList.put(i,new ReentrantLock());
        }
    }
    private static void startFeast()
    {
        for(int i = 0; i < 10; i++)
        {
            Philosophers.get(i).start();
            Philosophers.get(i).setName(Philosophers.get(i).name);
        }
    }

}
