package razdwatrzy.zzpj.crypto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class CryptoTests {


    private ICipher cipher = new Char32ICipher();

    @Test
    public void encodeTest() throws Exception {
        int x = 10;
        byte[] encode = cipher.encode(x);
        assertEquals(encode.length, 48);
        int out = cipher.decode(encode);
        assertEquals(out, x);

    }

}
