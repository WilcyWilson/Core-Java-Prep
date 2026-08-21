package javaprepfirstscope;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public record Transaction(int amount, int id, LocalDate date) {

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(100, 1, LocalDate.of(2026, Month.DECEMBER, 1)));

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 2; i <= 10; i++) {
            int randomamount = threadLocalRandom.nextInt(100, 2000);
            int randomDayOfYear = threadLocalRandom.nextInt(1, 366);
            LocalDate randomDate = LocalDate.ofYearDay(2026, randomDayOfYear);
            transactions.add(new Transaction(randomamount, randomDayOfYear, randomDate));
        }

        System.out.println("\nOriginal List:");
        transactions.forEach(System.out::println);

        // Using Streams
        System.out.println("\nUsing Streams:");
        int[] transactionList = transactions
                .stream()
                .filter(t -> t.amount > 1000)
                .sorted(Comparator.comparingInt(Transaction::amount))
                .mapToInt(Transaction::id)
                .toArray();
        for (int num : transactionList) {
            System.out.println(num);
        }

        System.out.println("\nUsing Loops:");
        // Using for loops
        List<Transaction> transactionArrayList = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.amount > 1000) {
                transactionArrayList.add(t);
            }
        }

        transactionArrayList.sort(Comparator.comparingInt(Transaction::amount));

        for (Transaction t : transactionArrayList) {
            System.out.println(t.id);
        }
    }
}
