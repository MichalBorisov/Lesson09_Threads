package com.company;

public class Thread1 extends Thread {

    int leftForkId=0;
    int rightForkId=0;
    int foodAmount = 10000;
    int Id;
    String name = "";

    public Thread1(String name, int id)
    {
        this.name = name;

        this.Id = id;
        if(Id == 0)
        {
            leftForkId = Main.forkList.size()-1;
        }
        else
            leftForkId = Id-1;
        rightForkId = Id;
    }

    private void doAction(String action) {
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        try {
            Thread.sleep(((int) (Math.random())));
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    public void run()
    {
        Object Fork1 = Main.forkList.get(leftForkId);
        Object Fork2 =Main.forkList.get(rightForkId);
        if(this.Id == 9) {
            Fork1 = Main.forkList.get(rightForkId);
            Fork2 = Main.forkList.get(leftForkId);
        }
        while(foodAmount > 0) {


                synchronized (Fork1) {
                    doAction("pick up left fork");
                    synchronized (Fork2) {
                        doAction("pick up right fork");
                        System.out.println(name + "  " + foodAmount--);
                        foodAmount--;
                        doAction("put down right fork");
                    }
                    doAction("put down left fork. food left "+foodAmount);
                }

        }
        System.out.println(name + "  " + foodAmount);
    }
}
