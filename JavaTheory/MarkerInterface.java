package JavaTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class MarkerInterface {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        if (list instanceof RandomAccess) {
            Collections.shuffle(list); // Direct shuffle on RandomAccess list
        } else {
             // Alternative shuffle algorithm for non-RandomAccess lists
        }
        System.out.println(list.toString());
    }

}
