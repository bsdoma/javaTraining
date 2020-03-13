package com.test;

class Scheduling implements Runnable {
    private static Thread [] jobs = new Thread[4];
    volatile  private int threadID;
    public Scheduling(int ID) {
        threadID = ID;
    }
    public void run() {
        synchronized(this) {
            System.out.println("hello " + threadID);
        }
    }
    public static void main(String [] args) {
        for(int i=0; i<jobs.length; i++) {
            jobs[i] = new Thread(new Scheduling(i));
            //jobs[i].setPriority(i);
            jobs[i].start();
        }
        try {
            for(int i=0; i<jobs.length; i++) {
                jobs[i].join();
            }
        } catch(InterruptedException e) { System.out.println(e); }
    }
}