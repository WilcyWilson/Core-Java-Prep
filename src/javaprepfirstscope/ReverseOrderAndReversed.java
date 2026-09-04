package javaprepfirstscope;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReverseOrderAndReversed implements Comparable<ReverseOrderAndReversed> {
    private final String userId;
    private final double billedAmount;

    public ReverseOrderAndReversed(String userId, double billedAmount) {
        this.userId = userId;
        this.billedAmount = billedAmount;
    }

    public double billedAmount() {
        return this.billedAmount;
    }

    @Override
    public int compareTo(ReverseOrderAndReversed other) {
        return this.userId.compareTo(other.userId);
    }

    @Override
    public String toString() {
        return userId + "($" + billedAmount + ")";
    }

    public static void main(String[] args) {
        List<ReverseOrderAndReversed> users = new ArrayList<>(List.of(
                new ReverseOrderAndReversed("SPP-004", 600.00),
                new ReverseOrderAndReversed("SPP-002", 500.00),
                new ReverseOrderAndReversed("SPP-008", 100.00)
        ));
        users.sort(Comparator.reverseOrder());
        System.out.println(users);

        users.sort(Comparator
                .comparingDouble(ReverseOrderAndReversed::billedAmount)
                .reversed());
        System.out.println(users);
    }

}
