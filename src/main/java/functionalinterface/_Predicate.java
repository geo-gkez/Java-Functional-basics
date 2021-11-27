package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValid("0700004605"));
        System.out.println(isPhoneNumberValid("0900004605"));
        System.out.println(isPhoneNumberValid("070000460"));

        System.out.println("With Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("0700004605"));
        System.out.println(isPhoneNumberValidPredicate.test("0900004605"));
        System.out.println(isPhoneNumberValidPredicate.test("070000460"));

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.and(containsNumber3).test("0903004605")
        );

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("0735004605")
        );

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.or(containsNumber3).test("0535004605")
        );
    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 10;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 10;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");

}
