package com.fsabino.javacodingtips.javaconcurrent.maincomponents.producer_consumer;

import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Logger;

public class ProducerConsumer {
    private static Vector<Object> data = new Vector<>();
    private final static Logger LOGGER = Logger.getLogger(ProducerConsumer.class.getName());

    public static void main(String[] args) {
        new Producer().start();
        new Consumer().start();
    }

    public static class Consumer extends Thread {
        Consumer() {
            super("Consumer");
        }
        @Override
        public void run() {
            for (;;) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (data) {
                    @SuppressWarnings("rawtypes")
                    Iterator it = data.iterator();
                    LOGGER.info("Getting an object");
                    while (it.hasNext())
                        it.next();
                }
            }
        }
    }

    public static class Producer extends Thread {
        Producer() {
            super("Producer");
        }

        @Override
        public void run() {
            for (;;) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                LOGGER.info("Adding an object");
                data.add(new Object());
                if (data.size() > 1000)
                    LOGGER.info("Removing an object");
                    data.remove(data.size() - 1);
            }
        }
    }
}
