package localrepo.greedyMethod;

import java.util.*;

class Job {
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class jobSequencing {
    // Function to find the maximum profit sequence of jobs
    static int[] jobSeq(Job[] jobs, int maxDeadline) {
        // Sort jobs by descending profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        // Initialise the result sequence
        int[] result = new int[maxDeadline];
        boolean[] slot = new boolean[maxDeadline];
        // initialise all slots to be free
        Arrays.fill(slot, false);
        // iterate thro all jobs
        for (int i = 0; i < jobs.length; i++) {
            // Find a free slot for this job, going backward from its deadline
            for (int j = Math.min(maxDeadline - 1, jobs[i].deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = jobs[i].id;
                    slot[j] = true; // Mark this slot as occupied
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job(1, 2, 100),
                new Job(2, 1, 19),
                new Job(3, 2, 27),
                new Job(4, 1, 25),
                new Job(5, 3, 15)
        };

        int maxDeadline = 3; // Maximum deadline in the jobs list
        int[] jobSequence = jobSeq(jobs, maxDeadline);

        System.out.println("Job Sequence for maximum profit:");
        for (int i = 0; i < maxDeadline; i++) {
            if (jobSequence[i] != 0) {
                System.out.print("Job " + jobSequence[i] + " ");
            }
        }
    }
}
