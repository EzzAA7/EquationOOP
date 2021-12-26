public class SimpleTerm extends Term implements TermInterface{
    private int expo;

    public SimpleTerm(int coeff, int expo) {
        super(coeff);
        this.expo = expo;
    }

    public int getExpo() {
        return expo;
    }

    public void setExpo(int expo) {

        this.expo = expo;
    }

    @Override
    public float eval(int val) {
        this.setEval((float) (this.getCoeff() * Math.pow(val, this.getExpo())));
        return this.getEval();
    }
}
