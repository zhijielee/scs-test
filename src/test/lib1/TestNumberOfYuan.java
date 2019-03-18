package test.lib1;

import main.lib1.NumberOfYuan;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestNumberOfYuan {
    private int money;
    private boolean expected;
    private NumberOfYuan numberOfYuan = null;

    public TestNumberOfYuan(int money, boolean expected) {
        this.money = money;
        this.expected = expected;
    }


    @Before
    public void setup() {
        numberOfYuan = new NumberOfYuan();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][] {
                {77, true},
                {8, true},
                {57,true},
                {26,true},
                {24,false},
                {83, true},
                {84, false},
                {10000, false},
                {-1, false}
        });
    }

    @Test
    public void testGiveMoney() {
        Assert.assertEquals(this.expected, numberOfYuan.giveMoney(this.money));
    }

}
