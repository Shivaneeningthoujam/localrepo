package localrepo.greedyMethod;

import java.util.*;

class Process {
    int id; // Process ID
    int burstTime; // Burst time of the process
    int waitingTime; // Waiting time of the process
    int turnAroundTime; // Turnaround time of the process

    Process(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
    }
}

public class shortestJobFirst {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        Process[] processes = new Process[n];

        // Input burst times
        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            int burstTime = scanner.nextInt();
            processes[i] = new Process(i + 1, burstTime);
        }

        // Sort processes by burst time (Shortest Job First)
        Arrays.sort(processes, Comparator.comparingInt(p -> p.burstTime));

        // Calculate waiting time and turnaround time
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;

        processes[0].waitingTime = 0; // First process doesn't have to wait

        for (int i = 1; i < n; i++) {
            processes[i].waitingTime = processes[i - 1].waitingTime + processes[i - 1].burstTime;
            totalWaitingTime += processes[i].waitingTime;
        }

        for (int i = 0; i < n; i++) {
            processes[i].turnAroundTime = processes[i].waitingTime + processes[i].burstTime;
            totalTurnAroundTime += processes[i].turnAroundTime;
        }

        // Print process details
        System.out.println("\nProcess ID  Burst Time  Waiting Time  Turnaround Time");
        for (Process p : processes) {
            System.out.println("    " + p.id + "          " + p.burstTime + "            " + p.waitingTime
                    + "              " + p.turnAroundTime);
        }

        // Print average waiting time and turnaround time
        System.out.println("\nAverage Waiting Time: " + (float) totalWaitingTime / n);
        System.out.println("Average Turnaround Time: " + (float) totalTurnAroundTime / n);
        scanner.close();
    }
}
