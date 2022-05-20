package com.company;

import java.util.Comparator;
import java.util.Random;

public class Main {

    public static PriorityQueue<Client> clientQueueGenerator(int clientsAmount) {
        Random rand = new Random();
        Comparator<Client> comparator = Comparator.comparingInt(Client::getArrivalTime);
        PriorityQueue<Client> q = new PriorityQueue<>(comparator, clientsAmount);
        int randArrivalTime = 0;

        for(int i = 0; i<clientsAmount; i++) {
            randArrivalTime = randArrivalTime + rand.nextInt(1,2);
            q.enqueue(new Client(randArrivalTime, rand.nextInt(1,15)));
            //zakladamy ze sprawa zawsze zajmuje wiecej niz 0 jednostek czasu
        }

        return q;
    }

    public static void main(String[] args) throws EmptyQueueException {
        int amount = 1000;
        PriorityQueue<Client> queue = clientQueueGenerator(amount);
        OfficeQueue officeQueue = new OfficeQueue(queue);

        officeQueue.execute();
    }
}
