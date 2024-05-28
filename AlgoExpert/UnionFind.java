import java.util.*;

// Do not edit the class below except for
// the constructor and the createSet, find,
// and union methods. Feel free to add new
// properties and methods to the class.
class Program {
    static class UnionFind {
        private Map<Integer, Integer> parents = new HashMap<>();
        private Map<Integer, Integer> ranks = new HashMap<>();

        // TC:O(1), SC:O(1)
        public void createSet(int value) {
            // Creating a set with its parent as itself (i.e root)
            parents.put(value, value);

            // Initializing the rank of the value as 0
            ranks.put(value, 0);
        }

        // TC:O(1), SC:O(1) approx
        public Integer find(int value) {
            // Case : Value is not present in any of the parents i.e in any of the sets, so
            // we return null in this case
            if (!parents.containsKey(value)) {
                return null;
            }

            // Checking if the parent of the value is a root node or not, if not,
            // recursively call and set it by calling the the find() method until it is
            // To check if the parent of the value is root or not, we can check its
            // recursive parent case since during createSet() we initially set all nodes
            // parents to itself
            if (parents.get(value) != value) {
                parents.put(value, find(parents.get(value)));
            }

            // By now the parent of the value has been set as the root of the set i.e its
            // representative, which is what we wanted to find
            return parents.get(value);
        }

        // TC:O(1), SC:O(1) approx
        public void union(int valueOne, int valueTwo) {
            // Case : Either of the two values dont exist in the set
            if (!parents.containsKey(valueOne) || !parents.containsKey(valueTwo)) {
                return;
            }

            // Finding the roots of the two values to check to which subset they belong to
            int valueOneRoot = find(valueOne);
            int valueTwoRoot = find(valueTwo);

            // Now there can be 3 cases
            // Case 1 : Rank of valueOne > Rank of valueTwo, which means valueOne has more
            // height than valueTwo
            // In this case we will set the parent of valueTwo as valueOne
            if (ranks.get(valueOneRoot) > ranks.get(valueTwoRoot)) {
                parents.put(valueTwoRoot, valueOneRoot);
            } else if (ranks.get(valueTwoRoot) > ranks.get(valueOneRoot)) {
                // Case 2 : Rank of valueTwo > Rank of valueOne, which means valueTwo has more
                // height than valueOne
                // In this case, we will set the parent of valueOne as valueTwo
                parents.put(valueTwoRoot, valueOneRoot);
            } else {
                // Case 3: Rank of valueOne == Rank of valueTwo, in this case we can set either
                // as the parent of the other
                // We will assume and set valueOne as the parent of valueTwo, and since we are
                // now adding an extra height to valueOne, so we will increase its rank as well
                // by 1
                parents.put(valueTwoRoot, valueOneRoot);
                ranks.put(valueOneRoot, ranks.get(valueOneRoot) + 1);
            }
        }
    }
}
