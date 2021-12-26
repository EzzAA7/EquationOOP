public class SinTerm extends Term implements TermInterface{
    public SinTerm(int coeff) {
        super(coeff);
    }

    @Override
    public float eval(int val) {
        this.setEval((float) (this.getCoeff() * Math.sin(val)));
        return this.getEval();
    }
}
