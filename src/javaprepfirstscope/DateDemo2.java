package javaprepfirstscope;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateDemo2 {
    public static void main(String[] args) {
        String date1 = "2026-04-12";
        String date2 = "15/03/2024";
        String date3 = "Mar 15, 2026";
        LocalDate localDate = LocalDate.parse(date2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate localDate1 = LocalDate.parse(date3, DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        LocalDate localDate2 = LocalDate.parse(date1);

        LocalDate birthday = LocalDate.of(1998, Month.DECEMBER, 23);
        LocalDate now = LocalDate.now();

        Period period = Period.between(birthday, now);

        System.out.println("Age: " + period.getYears() + " Years " + period.getMonths() + " Months " + period.getDays() + " Days");

        DateTimeFormatter localUS = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.LONG)
                .withLocale(Locale.US);
        String usFormat = now.format(localUS);
        DateTimeFormatter localChina = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.TRADITIONAL_CHINESE);
        String chineseFormat = now.format(localChina);
        DateTimeFormatter localFrench = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.LONG)
                .withLocale(Locale.FRENCH);
        String frenchFormat = now.format(localFrench);

        LocalDateTime now2 = LocalDateTime.now();

        ZonedDateTime nepalTimeZone = ZonedDateTime.of(now2, ZoneId.of("Asia/Kathmandu"));
        ZonedDateTime americaTimeZone = nepalTimeZone.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime londonTimeZone = nepalTimeZone.withZoneSameInstant(ZoneId.of("Europe/London"));

        System.out.println("Nepal current time: " + nepalTimeZone);
        System.out.println("New York current time: " + americaTimeZone);
        System.out.println("London current time: " + londonTimeZone);


    }
}
