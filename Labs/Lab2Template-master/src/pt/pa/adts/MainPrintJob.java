package pt.pa.adts;

import com.sun.glass.ui.Window;

import java.util.ArrayList;

public class MainPrintJob {

    public static void main(String[] args) {
        PriorityQueueLinkedList<PrintJob> printJobs = new PriorityQueueLinkedList<>();
        printJobs.enqueue(new PrintJob("Job1", PrintJob.Level.MEDIUM, 3));
        printJobs.enqueue(new PrintJob("Job2", PrintJob.Level.MEDIUM, 5));
        printJobs.enqueue(new PrintJob("Job3", PrintJob.Level.LOW, 2));
        printJobs.enqueue(new PrintJob("Job4", PrintJob.Level.HIGH, 7));
        printJobs.enqueue(new PrintJob("Job5", PrintJob.Level.MEDIUM, 9));

        int size = printJobs.size();

        for (int i=0; i<size; i++)
            System.out.println(printJobs.dequeue());

        System.out.println(printJobs.isEmpty());
    }



}
