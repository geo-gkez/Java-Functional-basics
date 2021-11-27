package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        //Supplier<T>
        //Represents a supplier of results.

        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
        System.out.println(getDBConnectionUrlSupplierList.get());

    }

    static String getDBConnectionUrl(){
        return "jdbc://loclhost:5432/users";
    }

    static Supplier<String> getDBConnectionUrlSupplier =
            () -> "jdbc://loclhost:5432/users";

    static Supplier<List<String>> getDBConnectionUrlSupplierList =
            () -> List.of(
                    "jdbc://loclhost:5432/users",
                    "jdbc://loclhost:5432/users");

}
