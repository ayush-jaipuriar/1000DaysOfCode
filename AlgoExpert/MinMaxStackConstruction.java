import java.util.*;

class Program {
    // Time Complexity : O(1) time
    // Space Complexity : O(1) space
    static class MinMaxStack {
        List<Map<String, Integer>> minMaxMapList = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();

        public int peek() {
            return stack.get(stack.size() - 1);
        }

        public int pop() {
            minMaxMapList.remove(minMaxMapList.size() - 1);
            return stack.remove(stack.size() - 1);
        }

        public void push(Integer number) {
            Map<String, Integer> newMinMaxMap = new HashMap<>();
            newMinMaxMap.put("min", number);
            newMinMaxMap.put("max", number);

            if (minMaxMapList.size() > 0) {
                // Getting last min and max values
                Map<String, Integer> oldMinMaxMap = new HashMap<>(minMaxMapList.get(minMaxMapList.size() - 1));
                int oldMinValue = oldMinMaxMap.get("min");
                int oldMaxValue = oldMinMaxMap.get("max");

                newMinMaxMap.replace("min", Math.min(oldMinValue, number));
                newMinMaxMap.replace("max", Math.max(oldMaxValue, number));
            }

            minMaxMapList.add(newMinMaxMap);
            stack.add(number);
        }

        public int getMin() {
            return minMaxMapList.get(minMaxMapList.size() - 1).get("min");
        }

        public int getMax() {
            return minMaxMapList.get(minMaxMapList.size() - 1).get("max");
        }
    }
}
