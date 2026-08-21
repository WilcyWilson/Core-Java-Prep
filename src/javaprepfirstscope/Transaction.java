package javaprepfirstscope;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public record Transaction ( int amount, int id, LocalDate date) {

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(100,1, LocalDate.of(2026, Month.DECEMBER, 1)));

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 2; i <= 10; i++){
            int randomamount = threadLocalRandom.nextInt(100, 2000);
            int randomDayOfYear = threadLocalRandom.nextInt(1, 366);
            LocalDate randomDate = LocalDate.ofYearDay(2026, randomDayOfYear);
            transactions.add(new Transaction(randomamount, randomDayOfYear, randomDate));
        }
        List<Transaction> transactionList = transactions.stream().filter(t -> t.amount > 1000).toList();
        transactionList.forEach(System.out::println);

        System.out.println();
        transactions.forEach(System.out::println);
    }
}
