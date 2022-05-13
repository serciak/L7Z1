package com.company;

public class OfficeQueue {
    private PriorityQueue<Client> queue;
    private Client first;
    private int time;

    public OfficeQueue(PriorityQueue<Client> queue) {
        this.queue = queue;
        first = null;
        time = 0;
    }

    private void getFirst() throws EmptyQueueException {
        if(first == null && queue.isEmpty()) {
            first = queue.dequeue();
        }
    }

    private boolean isReady() {
        if(first != null)
            return first.getArrivalTime() <= time;
        return false;
    }

    public void execute() throws EmptyQueueException {
        Client a = null;
        Client b = null;
        Client c = null;
        int clientsA = 0;
        int clientsB = 0;
        int clientsC = 0;
        boolean ready;

        while(queue.isEmpty() || first != null) {
            getFirst();
            ready = isReady();

            if (a == null && ready) {
                a = first;
                first = null;
                clientsA++;
            } else {
                if(a != null) {
                    a.setCaseTime(a.getCaseTime() - 1);
                    if (a.getCaseTime() == 0) {
                        a = null;
                    }
                }
            }

            getFirst();
            ready = isReady();

            if (b == null && ready) {
                b = first;
                first = null;
                clientsB++;
            } else {
                if(b != null) {
                    b.setCaseTime(b.getCaseTime() - 1);
                    if (b.getCaseTime() == 0) {
                        b = null;
                    }
                }
            }

            getFirst();
            ready = isReady();

            if (c == null && ready) {
                c = first;
                first = null;
                clientsC++;
            } else {
                if(c != null) {
                    c.setCaseTime(c.getCaseTime() - 1);
                    if (c.getCaseTime() == 0) {
                        c = null;
                    }
                }
            }
            time++;
        }

        if(a != null)
            time += a.getCaseTime();
        if(b != null)
            time += b.getCaseTime();
        if(c != null)
            time += c.getCaseTime();

        System.out.println("Ilosc obsluzonych klientow: " + (clientsA+clientsB+clientsC));
        System.out.println("Obsluzonych przez A: " + clientsA);
        System.out.println("Obsluzonych przez B: " + clientsB);
        System.out.println("Obsluzonych przez C: " + clientsC);
        System.out.println("Potrzebny czas: " + time);
    }
}
