package javaprepfirstscope;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;

public class ScopedValueExample {
    // Doesn't hold a value yet
    public final static ScopedValue<DateTimeFormatter> USER_FORMATTER = ScopedValue.newInstance();

    static void main() {
        // Request comes from European user
        DateTimeFormatter euFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Request comes from US user
        DateTimeFormatter usFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        System.out.println("requests concurrently processed:");

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() ->
                    ScopedValue.where(USER_FORMATTER, usFormatter)
                               .run(ScopedValueExample::performBusinessLogic));

            // Bind the formatter to the ScopedValue and run a block of code
            executor.submit(() ->
                    ScopedValue.where(USER_FORMATTER, euFormatter)
                               .run(ScopedValueExample::performBusinessLogic));
            // The moment the run block ends the value is destroyed
        } // Executor waits for both virtual thread to complete. join not required

    }

    private static void performBusinessLogic() {
        generateReport();
    }

    private static void generateReport() {
        // Retrieve the value deep in the call stack
        // We do not pass the formatter as a method argument
        // Both Virtual threads call this exact method at the same time

        // USER_FORMATTER knows which value belongs to the current thread's scope
        DateTimeFormatter formatter = USER_FORMATTER.get();
        String date = LocalDate.now().format(formatter);

        System.out.println("Report generated with Date: " + date);
    }
}
