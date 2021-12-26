import java.util.LinkedList;

public class MultiplyTerm extends SimplePoly implements TermInterface{
    public MultiplyTerm(LinkedList<TermInterface> terms) {
        super(terms);
    }

    @Override
    public float eval(int val) {
        float result = 0;
        for (TermInterface term: this.getTerms()) {
            result *= term.eval(val);
        }

        this.setEvaluation(result);
        return this.getEvaluation();
    }
}
