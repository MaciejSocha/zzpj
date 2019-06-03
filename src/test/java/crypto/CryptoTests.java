package crypto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import razdwatrzy.zzpj.crypto.Char32ICipher;
import razdwatrzy.zzpj.crypto.ICipher;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class CryptoTests {


    ICipher cipher = new Char32ICipher();

    @Test
    public void encodeTest() throws Exception {
        int x = 10;
        byte[] encode = cipher.encode(x);
        assertEquals(encode.length, 48);
        int out = cipher.decode(encode);
        assertEquals(out, x);

    }

}
