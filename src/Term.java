public class Term {
    private int coeff;
    private float eval;

    public Term(int coeff) {
        this.coeff = coeff;
        this.eval = 0;
    }

    public int getCoeff() {

        return coeff;
    }

    public void setCoeff(int coeff) {

        this.coeff = coeff;
    }

    public float getEval() {

        return eval;
    }

    public void setEval(float eval) {

        this.eval = eval;
    }
}
