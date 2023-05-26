import java.util.Objects;

class ComplexNumber {

    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ComplexNumber) {
            ComplexNumber other = (ComplexNumber) obj;
            return Double.compare(re, other.re) == 0 && Double.compare(im, other.im) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(1,2,3);
    }


    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }
}
