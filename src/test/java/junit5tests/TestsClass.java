package junit5tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsClass {
    @Test
    public void method1() {
        Assertions.assertEquals(3,1);
    }

    @Test
    public void method2() {
        Assertions.assertEquals(3,3);
    }
}
