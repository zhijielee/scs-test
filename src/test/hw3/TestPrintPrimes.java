package test.hw3;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Collection;

import main.hw3.PrintPrimes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestPrintPrimes {
    private int n;
    private String expected;
    private PrintPrimes printPrimes;
    private PrintStream printStream = null;
    private ByteArrayOutputStream byteArrayOutputStream = null;

    public TestPrintPrimes(int n, String expected) {
        this.n = n;
        this.expected = expected;
    }

    @Before
    public void setUp(){
        printPrimes = new PrintPrimes();
        byteArrayOutputStream = new ByteArrayOutputStream();
        printStream = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void tearDown(){
        System.setOut(printStream);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData(){
        return Arrays.asList(new Object[][]{
                {1, "Prime: 2\r\n"},
                {3, "Prime: 2\r\nPrime: 3\r\nPrime: 5\r\n"},
                {5, "Prime: 2\r\nPrime: 3\r\nPrime: 5\r\nPrime: 7\r\nPrime: 11\r\n"}
        });
    }

    @Test
    public void testPrintPrimes(){
        printPrimes.printPrimes(n);
        assertEquals(expected , byteArrayOutputStream.toString());
    }
}