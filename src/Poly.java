import java.util.LinkedList;

public class Poly extends SimplePoly implements PolySimpleInterface{

    public Poly(LinkedList<Scalar> terms) {
        super(terms);
    }

    @Override
    public void calculateEvaluation(int val) {
        float result = 0;
        for (Scalar term: this.getTerms()) {
            result += term.eval(val);
        }

        this.setEvaluation(result);
    }

    @Override
    public void add(Scalar term) {
        this.getTerms().add(term);
    }

    @Override
    public float eval(int val) {
        this.calculateEvaluation(val);
        return this.getEvaluation();
    }
}
