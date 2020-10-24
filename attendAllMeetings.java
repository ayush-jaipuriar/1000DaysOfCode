import java.util.*;
public class Main {
    public static class Interval {
        int start;
        int end;
        Interval () {
            start=0;
            end=0;
        }
        Interval(int s, int e) {
            start=s;
            end=e;
        }
    }
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Interval[] intervals = new Interval[n];
        for (int i=0; i<n; i++) {
            Interval interval = new Interval(sc.nextInt(), sc.nextInt());
            intervals[i] = interval;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {   
            @Override         
            public int compare(Interval a, Interval b) {
                return a.start-b.start;
            }
        });
        boolean canAttendAll = true;
        Interval previousInterval = intervals[0];
        for (int i=1; i<n; i++) {
            Interval currentInterval = intervals[i];
            if (previousInterval.end>currentInterval.start) {
                canAttendAll=false;
                break;
            }
            previousInterval = currentInterval;
        }
        System.out.println(canAttendAll);

    }
}
