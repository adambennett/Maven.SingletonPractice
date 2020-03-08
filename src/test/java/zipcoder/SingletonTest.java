package zipcoder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import zipcoder.interfaces.Functional;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class SingletonTest {

    private Singleton a;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUp() {
        a = Singleton.getInstance();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void getFields() {
        try {
            Class clazz = Singleton.class.getClass();
            Field function = Singleton.class.getDeclaredField("functional");
            function.setAccessible(true);
            Functional ref = (Functional) function.get("");
            ref.p("Adam's Singleton Lab");
            Assert.assertEquals("Adam's Singleton Lab", outContent.toString().trim());
        } catch (NoSuchFieldException | IllegalAccessException ex) { Assert.assertTrue(false); }
    }

    @Test
    public void getInstance() {
        Assert.assertNotNull(a);
    }

    @Test
    public void printInFewCharacters() {
        a.r("Adam's Singleton Lab");
        Assert.assertEquals("Adam's Singleton Lab", outContent.toString().trim());
    }

    @Test
    public void freebie() {
        System.out.println("Adam's Singleton Lab");
        Assert.assertEquals("Adam's Singleton Lab", outContent.toString().trim());
    }


}