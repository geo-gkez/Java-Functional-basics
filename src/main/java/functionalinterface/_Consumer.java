package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    //Consumer<T>
    //Represents an operation that accepts a single input argument and returns no result.

    public static void main(String[] args) {
        // Normal Java
        Customer tonia = new Customer("Tonia", "90100503");
        greetCustomer(tonia);

        // Consumer Functional interface
        greetCustomerConsumer.accept(tonia);

        greetCustomerConsumerV2.accept(tonia,false);

    }

    static BiConsumer<Customer,Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello "+ customer.customerName +
                    ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "************"));

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello "+ customer.customerName +
                    ", thanks for registering phone number "
                    + customer.customerPhoneNumber);

    static void greetCustomer(Customer customer){
        System.out.println("Hello "+ customer.customerName +
                ", thanks for registering phone number "
                + customer.customerPhoneNumber);
    }
    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
