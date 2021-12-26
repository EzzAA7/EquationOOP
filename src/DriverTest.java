import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class DriverTest {

    @Test
    public void CorrectResultOfSimpleTerms() {
        TermInterface t1 = new SimpleTerm(1,5);
        TermInterface t2 = new SimpleTerm(2,4);
        TermInterface t3 = new SimpleTerm(5,3);
        LinkedList<TermInterface> myTerms1 = new LinkedList<>();
        PolySimpleInterface p = new Poly(myTerms1);

        p.add(t1);
        p.add(t2);
        p.add(t3);

        p.calculateEvaluation(3);
        assertEquals( 540.0, p.getResult(), 1);

    }

    @Test
    public void CorrectResultOfComplexTerms() {
        TermInterface t4 = new CosTerm(40);
        LinkedList<TermInterface> myTerms1 = new LinkedList<>();
        PolySimpleInterface p = new Poly(myTerms1);

        p.add(t4);

        p.calculateEvaluation(3);
        assertEquals( -40.0, p.getResult(), 1);

    }

    @Test
    public void CorrectResultOfSimpleAndComplexTerms() {
        TermInterface t3 = new SimpleTerm(5,3);
        TermInterface t4 = new CosTerm(40);
        LinkedList<TermInterface> myTerms1 = new LinkedList<>();
        PolySimpleInterface p = new Poly(myTerms1);

        p.add(t3);
        p.add(t4);

        p.calculateEvaluation(3);
        assertEquals( 95.0, p.getResult(), 1);

    }

    @Test
    public void CorrectResultOfMulTerms() {
        TermInterface t5 = new SimpleTerm(2,4);
        TermInterface t6 = new SimpleTerm(5,3);
        LinkedList<TermInterface> myTerms2 = new LinkedList<>();
        PolySimpleInterface mul = new MultiplyTerm(myTerms2);

        mul.add(t5);
        mul.add(t6);

        mul.calculateEvaluation(3);
        assertEquals( 21870.0, mul.getResult(), 1);

    }

//    @Test
//    public void CorrectResultOfMixedTerms() {
//        TermInterface t1 = new SimpleTerm(1,5);
//        TermInterface t2 = new SimpleTerm(2,4);
//        TermInterface t3 = new SimpleTerm(5,3);
//        TermInterface t4 = new CosTerm(40);
//        LinkedList<TermInterface> myTerms1 = new LinkedList<>();
//        PolySimpleInterface p = new Poly(myTerms1);
//
//        p.add(t1);
//        p.add(t2);
//        p.add(t3);
//        p.add(t4);
//
//        TermInterface t5 = new SimpleTerm(2,4);
//        TermInterface t6 = new SimpleTerm(5,3);
//        LinkedList<TermInterface> myTerms2 = new LinkedList<>();
//        PolySimpleInterface mul = new MultiplyTerm(myTerms2);
//
//        mul.add(t5);
//        mul.add(t6);
//        p.add(mul);
//
//        mul.calculateEvaluation(3);
//        assertEquals( 21870.0, mul.getResult(), 1);
//
//    }

}
