public class ExpTerm extends Term implements TermInterface{
    public ExpTerm(int coeff) {
        super(coeff);
    }

    @Override
    public float eval(int val) {
        this.setEval((float) (this.getCoeff() * Math.exp(val)));
        return this.getEval();    }
}
