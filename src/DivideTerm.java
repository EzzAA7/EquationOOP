import java.util.LinkedList;

public class DivideTerm implements PolyComplexInterface{
    private LinkedList<Scalar> divider;
    private LinkedList<Scalar> dividend;
    private float evaluation;

    public DivideTerm(LinkedList<Scalar> divider, LinkedList<Scalar> dividend) {
        this.divider = divider;
        this.dividend = dividend;
        this.evaluation = 0;
    }

    public LinkedList<Scalar> getDivider() {
        return divider;
    }

    public void setDivider(LinkedList<Scalar> divider) {
        this.divider = divider;
    }

    public LinkedList<Scalar> getDividend() {
        return dividend;
    }

    public void setDividend(LinkedList<Scalar> dividend) {
        this.dividend = dividend;
    }

    public float getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(float evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public void calculateEvaluation(int val) {
        float resultDivider = 0, resultDividend = 0;
        for (Scalar term: this.divider) {
            resultDivider += term.eval(val);
        }
        for (Scalar term: this.dividend) {
            resultDividend += term.eval(val);
        }
        this.setEvaluation(resultDivider / resultDividend);
    }

    @Override
    public void addToDivider(Scalar s1) {

        this.getDivider().add(s1);
    }

    @Override
    public void addToDividend(Scalar s1) {

        this.getDividend().add(s1);
    }

    @Override
    public float eval(int val) {
        this.calculateEvaluation(val);
        return this.getEvaluation();
    }
}
