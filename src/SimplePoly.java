import java.util.LinkedList;

public class SimplePoly {
    private LinkedList<TermInterface> terms;
    private float evaluation;

    public SimplePoly(LinkedList<TermInterface> terms) {
        this.terms = terms;
        this.evaluation = 0;
    }

    public float getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(float evaluation) {
        this.evaluation = evaluation;
    }

    public LinkedList<TermInterface> getTerms() {
        return terms;
    }

    public void setTerms(LinkedList<TermInterface> terms) {
        this.terms = terms;
    }


}
