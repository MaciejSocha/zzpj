package razdwatrzy.zzpj.crypto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class CryptoTests {


    private ICipher cipher = new Byte48Cipher();

    @Test
    public void encodeTest() throws Exception {
        long x = 10;
        byte[] encode = cipher.encode(x);
        assertEquals(encode.length, 48);
        long out = cipher.decode(encode);
        assertEquals(out, x);

    }

}
