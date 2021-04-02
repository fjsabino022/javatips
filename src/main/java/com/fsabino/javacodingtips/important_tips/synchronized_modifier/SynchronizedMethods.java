package com.fsabino.javacodingtips.important_tips.synchronized_modifier;

public class SynchronizedMethods {

    private int sum = 0;

    public void calculate() {
        setSum(getSum() + 1);
    }
    
    // synchronized
    public synchronized void synchronisedCalculate() {
        setSum(getSum() + 1);
    }
    
    public void performSynchronisedTask() {
        synchronized (this) {
            setSum(getSum()+1);
        }
    }
    
    public int getSum() {
    	return sum;
    }
    
    public void setSum(int sum) {
    	this.sum = sum;
    }
}
