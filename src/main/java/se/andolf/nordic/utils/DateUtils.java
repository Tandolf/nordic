package se.andolf.nordic.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class DateUtils {

    public static int getCurrentWeek() {
        return LocalDate.now().get(WeekFields.ISO.weekOfWeekBasedYear());
    }

    public static List<LocalDate> getDatesForWeek(long calendarWeek) {
        LocalDate start = LocalDate.ofYearDay(LocalDate.now().getYear(),LocalDate.now().getDayOfYear())
                .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        return IntStream.range(0, 7).mapToObj(start::plusDays).collect(toList());
    }
}
