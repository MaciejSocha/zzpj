package razdwatrzy.zzpj.temp;

import lombok.Getter;
import lombok.Setter;

public class Calcs {

    @Getter
    @Setter
    private float a;

    @Getter
    @Setter
    private float b;

    public Calcs(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public float sum(float a, float b) {
        return a + b;
    }

    public float sum() {
        return a + b;
    }

    public float div() {
        return a - b;
    }

    public float div(float a, float b) {
        return a - b;
    }
}
