package razdwatrzy.zzpj.crypto;

import org.springframework.stereotype.Service;


public interface ICipher {
    byte[] encode(int i) throws Exception;
    int decode(byte[] s) throws Exception;
}
