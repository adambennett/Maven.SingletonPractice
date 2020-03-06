package zipcoder;

import zipcoder.interfaces.Functional;

public final class Singleton {

    private static Singleton instance;
    private static Functional functional;

    private Singleton() {}

    public static Singleton getInstance() { return instance; }

    public static void r(String message) {
        functional.p(message);
    }

    static {
        try {
            instance = new Singleton();
            instance.functional = (String message) -> System.out.println(message);
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in static initialization of Singleton!");
        }
    }

}