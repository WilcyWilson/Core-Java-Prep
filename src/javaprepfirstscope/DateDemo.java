package javaprepfirstscope;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class DateDemo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1998, Month.DECEMBER, 23);
        LocalDate parsed = LocalDate.parse("2026-09-12");

        LocalDate nextWeek = today.plusWeeks(1);
        LocalDate lastMonth = today.minusMonths(1);
        boolean isAfter = today.isAfter(birthday);
        int year = today.getYear();
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        LocalTime now = LocalTime.now();
        LocalTime meeting = LocalTime.of(7, 30);
        LocalTime parse = LocalTime.parse("15:00");

        LocalTime later = meeting.plusHours(2);
        boolean isBefore = now.isBefore(LocalTime.NOON);

        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime appointment = LocalDateTime.of(2026, Month.SEPTEMBER, MonthDay.now().getDayOfMonth(), 8, 30);

        LocalDate date = appointment.toLocalDate();
        String basicIsoDate = date.format(DateTimeFormatter.BASIC_ISO_DATE); //20260930
        String isoLocalDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE); //2026-09-30
        LocalTime time = appointment.toLocalTime();

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        ZoneId systemDefault = ZoneId.systemDefault();
        ZonedDateTime now2 = ZonedDateTime.now(); // Automatically detects system time zone
        ZonedDateTime nowInKathmandu = ZonedDateTime.now(ZoneId.of("Asia/Kathmandu"));
        ZonedDateTime nowInNY = ZonedDateTime.now(ZoneId.of("America/New_York"));

        // Convert between zones
        ZonedDateTime sameInstantInLondon = nowInKathmandu.withZoneSameInstant(ZoneId.of("Europe/London"));
        // Create explicitly
        ZonedDateTime zonedMeetingTime = ZonedDateTime.of(LocalDateTime.of(2026, 9, 21, 12, 30), ZoneId.of("Asia/Tokyo"));

        Instant instantNow = Instant.now();
        long epochMilli = instantNow.toEpochMilli();

        Instant start = Instant.now();
        Instant end = Instant.now();
        Duration elapsed = Duration.between(start, end);

        OffsetDateTime offsetDateTime = OffsetDateTime.now(); // Detects system time zone, only saves offset

        LocalDate startDate = LocalDate.of(2026, Month.JULY, 26);
        LocalDate endDate = LocalDate.now();
        Period period = Period.between(startDate, endDate);

        // Both does the same thing
        LocalDate afterMonths = startDate.plus(Period.ofMonths(10).plusDays(15));
        LocalDate afterMonths1 = startDate.plusMonths(10).plusDays(15);

        Duration meetingLength = Duration.ofHours(1).plusMinutes(2);
        LocalTime endTime = LocalTime.of(11, 30).plus(meetingLength);

        //Custom Pattern DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, EEEE");
        String formattedDate = date.format(formatter);

        // Parsing custom format back to local date
        LocalDate parsing = LocalDate.parse("14 Aug 2026, Friday", formatter);

        // Formating ZonedDateTime
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z");
        String s = ZonedDateTime.now().format(f);

        LocalDate today2 = LocalDate.now();
        LocalDate lastDayOfMonth = today2.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate nextFriday = today2.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        LocalDate firstTuesdayOfNextMonth = today.plusMonths(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.TUESDAY));

    }
}
