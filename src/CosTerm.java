public class CosTerm extends Term implements TermInterface{
    public CosTerm(int coeff) {
        super(coeff);
    }

    @Override
    public float eval(int val) {
        this.setEval((float) (this.getCoeff() * Math.cos(val)));
        return this.getEval();
    }
}
