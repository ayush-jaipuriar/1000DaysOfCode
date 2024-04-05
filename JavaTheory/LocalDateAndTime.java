package JavaTheory;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class LocalDateAndTime {
    public static void main(String[] args) {
        // LocalData immutablity
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate tommorow = today.plusDays(1);
        System.out.println(tommorow);

        System.out.println(today);

        // Different operations on the dates
        today = today.plusMonths(2).plusDays(2);
        System.out.println(today);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        localTime = LocalTime.of(10,30);        
        System.out.println(localTime);
        localTime = localTime.plusHours(12);
        System.out.println(localTime);

        Duration duration = Duration.between(localTime, LocalTime.now());
        System.out.println(duration);


    }
}
