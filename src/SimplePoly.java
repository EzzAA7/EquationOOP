import java.util.LinkedList;

public class SimplePoly {
    private LinkedList<Scalar> terms;
    private float evaluation;

    public SimplePoly(LinkedList<Scalar> terms) {
        this.terms = terms;
        this.evaluation = 0;
    }

    public float getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(float evaluation) {
        this.evaluation = evaluation;
    }

    public LinkedList<Scalar> getTerms() {
        return terms;
    }

    public void setTerms(LinkedList<Scalar> terms) {
        this.terms = terms;
    }


}
