import java.util.LinkedList;

public class MultiplyTerm extends SimplePoly implements PolySimpleInterface{
    public MultiplyTerm(LinkedList<Scalar> terms) {

        super(terms);
    }

    @Override
    public void calculateEvaluation(int val) {
        float result = 1;
        for (Scalar term: this.getTerms()) {
            result *= term.eval(val);
        }

        this.setEvaluation(result);
    }

    @Override
    public void add(Scalar s1) {

        this.getTerms().add(s1);
    }

    @Override
    public float eval(int val) {
        this.calculateEvaluation(val);
        return this.getEvaluation();
    }
}
