package razdwatrzy.zzpj.temp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcsTest {

    private static float x = 8;
    private static float y = 3;
    private static Calcs calcs = new Calcs(10, 7);

    /*@BeforeAll
    static void init() {
        calcs = new Calcs(10, 7);
        x = 8;
        y = 3;
    }*/

    @Test
    void sum() {
        float ret = calcs.sum();
        assertEquals(17, ret);
    }

    @Test
    void sum1() {
        float ret = calcs.sum(x, y);
        assertEquals(11, ret);
    }

    @Test
    void div() {
    }

    @Test
    void div1() {
    }
}