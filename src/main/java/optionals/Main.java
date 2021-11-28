package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");

        Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");
        Object value2 = Optional.ofNullable("Hello")
                .orElseThrow(exception);

        System.out.println(value);
        System.out.println();
        System.out.println(value2);

        Optional.ofNullable("geo@gmail.com")
                .ifPresent(email -> System.out.println("Send to: "+email));

        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Send to: "+email),
                        () ->{
                            System.out.println("Cannot send email");
                        });

    }
}
