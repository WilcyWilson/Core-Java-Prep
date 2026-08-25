package javaprepfirstscope;

import java.util.Optional;

public class OptionalIntegerDemo {

    public static Optional<Integer> convertToOptionalInteger(String s) {
        return Optional
                .ofNullable(s) // Optional<String> (or Optional.empty() if null)
                .flatMap(str -> { // flatMap on empty Optional, skips lambda entirely, see flatMap implementation
                    try {
                        return Optional.of(Integer.valueOf(str));
                    } catch (NumberFormatException e) {
                        return Optional.empty();
                    }
                });
    }

    public static void main(String[] args) {
        convertToOptionalInteger(null).ifPresent(System.out::println);

        convertToOptionalInteger("42").ifPresentOrElse(System.out::println, () -> System.out.println("Cannot Parse"));
        convertToOptionalInteger("abc").ifPresentOrElse(System.out::println, () -> System.out.println("Cannot Parse"));

        convertToOptionalInteger("42").ifPresent(System.out::println);
        convertToOptionalInteger("abc").ifPresent(System.out::println);
    }
}
