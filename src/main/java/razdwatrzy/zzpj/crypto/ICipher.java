package razdwatrzy.zzpj.crypto;

import org.springframework.stereotype.Service;


public interface ICipher {
    byte[] encode(long i) throws Exception;
    long decode(byte[] s) throws Exception;
}
