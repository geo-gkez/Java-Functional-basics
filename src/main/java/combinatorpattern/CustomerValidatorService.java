package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isEPhoneNumberValid(String phoneNumber){
        return phoneNumber.contains("+30");
    }

    private boolean isAdult(LocalDate dob){
        return Period.between(dob,LocalDate.now()).getYears() > 16;
    }

    public boolean isValid(Customer customer){
        return isEmailValid(customer.getEmail()) &&
                isEPhoneNumberValid(customer.getPhoneNumber()) &&
                isAdult(customer.getDob());
    }


}
