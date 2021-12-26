import java.util.LinkedList;

public class Poly extends SimplePoly implements PolySimpleInterface{

    public Poly(LinkedList<TermInterface> terms) {
        super(terms);
    }

    @Override
    public void calculateEvaluation(int val) {
        float result = 0;
        for (TermInterface term: this.getTerms()) {
            result += term.eval(val);
        }

        this.setEvaluation(result);
    }

    @Override
    public void add(TermInterface term) {
        this.getTerms().add(term);
    }

    @Override
    public float getResult() {
        return this.getEvaluation();
    }
}
