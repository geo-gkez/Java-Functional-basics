package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Tonia",
                "tonia@gmail.com",
                "+306985264",
                LocalDate.of(2001,1,5)
        );
//        System.out.println(new CustomerValidatorService().isValid(customer));

        // Using combinator pattern

        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if(result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }

    }
}
