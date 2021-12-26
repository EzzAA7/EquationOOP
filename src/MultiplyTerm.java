import java.util.LinkedList;

public class MultiplyTerm extends SimplePoly implements PolySimpleInterface{
    public MultiplyTerm(LinkedList<TermInterface> terms) {

        super(terms);
    }

    @Override
    public void calculateEvaluation(int val) {
        float result = 1;
        for (TermInterface term: this.getTerms()) {
            result *= term.eval(val);
        }

        this.setEvaluation(result);
    }

    @Override
    public void add(TermInterface t1) {
        this.getTerms().add(t1);
    }

    @Override
    public float getResult() {

        return this.getEvaluation();
    }
}
