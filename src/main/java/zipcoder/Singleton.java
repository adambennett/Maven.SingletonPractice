package zipcoder;

import zipcoder.interfaces.Functional;

public final class Singleton {

    private static final Singleton instance;
    private static final Functional functional;

    private Singleton() {}

    public static Singleton getInstance() { return instance; }

    public void r(String message) {
        functional.p(message);
    }

    static {
        try {
            instance = new Singleton();
            functional = (String message) -> System.out.println(message);
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in static initialization of Singleton!");
        }
    }

}