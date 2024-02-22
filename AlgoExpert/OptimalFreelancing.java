import java.util.*;

class Program {
  public int optimalFreelancing(Map<String, Integer>[] jobs) {
    // Initialize a constant for max days in a week
    int MAX_DAYS_OF_WEEK = 7;
    int finalProfit = 0;

    // Sorting the jobs array of maps based on payments in descending order
    Arrays.sort(jobs, new Comparator<Map<String, Integer>>() {
      public int compare(final Map<String, Integer> job1, final Map<String, Integer> job2) {
        return job2.get("payment").compareTo(job1.get("payment"));
      }
    });

    // Initialize a boolean array representing the days of the week
    Boolean[] daysOfWeek = new Boolean[MAX_DAYS_OF_WEEK];
    // Fill the boolean array with false, representing that initially no job has been taken up on any day of the week
    Arrays.fill(daysOfWeek, false);

    // Now we iterate through the jobs array
    for (Map<String,Integer> job : jobs) {
      // The max time that can be taken by a job is the minimum of its deadline and the max days of the week
      int maxTime = Math.min(job.get("deadline"), MAX_DAYS_OF_WEEK);
      // We will try to put the job on the last possible day, starting from maxTime to the 0th day
      for (int i = maxTime - 1; i >= 0; i--) {
        // Checking if that particular day any other job has been scheduled or not from our daysOfWeek boolean array
        if (daysOfWeek[i] == false) {
          // Mark this day as used so that no other job can be scheduled on this day
          daysOfWeek[i] = true;
          // Adding that job's payment to our finalProfit sum variable
          finalProfit += job.get("payment");
          break;
        }
      }
    }

    return finalProfit;
  }
}
