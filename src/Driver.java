import java.util.LinkedList;

public class Driver {

    public static void main(String[] args) {
        TermInterface t1 = new SimpleTerm(1,5);
        TermInterface t2 = new SimpleTerm(2,4);
        TermInterface t3 = new SimpleTerm(5,3);
        TermInterface t4 = new CosTerm(40);
        LinkedList<TermInterface> myTerms1 = new LinkedList<>();
        PolySimpleInterface p = new Poly(myTerms1);

        TermInterface t5 = new SimpleTerm(2,4);
        TermInterface t6 = new SimpleTerm(5,3);
        LinkedList<TermInterface> myTerms2 = new LinkedList<>();
        TermInterface mul = new MultiplyTerm(myTerms2);

        p.add(t1);
        p.add(t2);
        p.add(t3);
        p.add(t4);

//        mul.add(t5);
//        mul.add(t6);
//        p.add(mul);

        p.calculateEvaluation(3);
        System.out.println(p.getResult());
    }
}
