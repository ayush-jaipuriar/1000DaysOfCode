import java.util.*;

class Program {
    public ArrayList<ArrayList<Integer>> taskAssignment(
            int k, ArrayList<Integer> tasks) {
        ArrayList<ArrayList<Integer>> pairedTasks = new ArrayList<>();
        // Creating a HashMap of values
        // Since we will sort the array and the question needs us to return pair of indices
        // Hence for each task we will store their indices in the hashmap as task time : value(s)
        HashMap<Integer, ArrayList<Integer>> taskDurationsToIndices = getTaskDurationsToIndices(tasks);
        ArrayList<Integer> sortedTasks = new ArrayList<>(tasks);
        Collections.sort(sortedTasks);

        for (int idx = 0; idx < k; idx++) {
            int task1Duration = sortedTasks.get(idx);
            ArrayList<Integer> indicesWithTask1Duration = taskDurationsToIndices.get(task1Duration);
            int task1Index = indicesWithTask1Duration.remove(indicesWithTask1Duration.size() - 1);

            int task2SortedIndex = tasks.size() - 1 - idx;
            int task2Duration = sortedTasks.get(task2SortedIndex);
            ArrayList<Integer> indicesWithTask2Duration = taskDurationsToIndices.get(task2Duration);
            int task2Index = indicesWithTask2Duration.remove(indicesWithTask2Duration.size() - 1);

            ArrayList<Integer> pairedTask = new ArrayList<>();
            pairedTask.add(task1Index);
            pairedTask.add(task2Index);
            pairedTasks.add(pairedTask);
        }

        return pairedTasks;
    }

    // Helper method to map task durations to their indices
    private static HashMap<Integer, ArrayList<Integer>> getTaskDurationsToIndices(ArrayList<Integer> tasks) {
        HashMap<Integer, ArrayList<Integer>> taskDurationsToIndices = new HashMap<>();
        for (int idx = 0; idx < tasks.size(); idx++) {
            int taskDuration = tasks.get(idx);
            if (!taskDurationsToIndices.containsKey(taskDuration)) {
                taskDurationsToIndices.put(taskDuration, new ArrayList<>());
            }
            taskDurationsToIndices.get(taskDuration).add(idx);
        }
        return taskDurationsToIndices;
    }
}
