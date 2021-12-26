import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class DriverTest {

    @Test
    public void CorrectResultOfSimpleTerms() {

        LinkedList<Scalar> myTerms1 = new LinkedList<>();
        PolySimpleInterface p = new Poly(myTerms1);
        p.add(new SimpleTerm(1,5));
        p.add(new SimpleTerm(2,4));
        p.add(new SimpleTerm(5,3));

        assertEquals( 540.0, p.eval(3), 1);

    }

    @Test
    public void CorrectResultOfComplexTerms() {
        LinkedList<Scalar> myTerms1 = new LinkedList<>();
        PolySimpleInterface p = new Poly(myTerms1);
        p.add(new CosTerm(40));

        assertEquals( -40.0, p.eval(3), 1);

    }

    @Test
    public void CorrectResultOfSimpleAndComplexTerms() {
        LinkedList<Scalar> myTerms1 = new LinkedList<>();
        PolySimpleInterface p = new Poly(myTerms1);
        p.add(new SimpleTerm(5,3));
        p.add(new CosTerm(40));

        assertEquals( 95.0, p.eval(3), 1);

    }

    @Test
    public void CorrectResultOfMulTerms() {
        LinkedList<Scalar> myTerms1 = new LinkedList<>();
        PolySimpleInterface mul = new MultiplyTerm(myTerms1);

        mul.add(new SimpleTerm(2,4));
        mul.add(new SimpleTerm(5,3));

        assertEquals( 21870.0, mul.eval(3), 1);

    }

    @Test
    public void CorrectResultOfSimpleAndMulTerms() {
        LinkedList<Scalar> myTerms1 = new LinkedList<>();
        PolySimpleInterface p = new Poly(myTerms1);
        p.add(new SimpleTerm(1,5));
        p.add(new SimpleTerm(2,4));
        p.add(new SimpleTerm(5,3));
        p.add(new CosTerm(40));

        LinkedList<Scalar> myTerms2 = new LinkedList<>();
        PolySimpleInterface mul = new MultiplyTerm(myTerms2);

        mul.add(new SimpleTerm(2,4));
        mul.add(new SimpleTerm(5,3));
        p.add(mul);

        assertEquals( 22370, p.eval(3), 1);

    }

    @Test
    public void CorrectResultOfAddPolytoPolyTerms() {
        PolySimpleInterface p1 = new Poly(new LinkedList<>());
        p1.add(new SimpleTerm(1,5));
        p1.add(new SimpleTerm(2,4));
        p1.add(new SimpleTerm(5,3));
        p1.add(new CosTerm(40));
        assertEquals( 500, p1.eval(3), 1);
//        System.out.println(p1.eval(3));

        PolySimpleInterface p2 = new Poly(new LinkedList<>());

        p2.add(new SimpleTerm(2,4));
        p2.add(new SimpleTerm(5,3));
        assertEquals( 297, p2.eval(3), 1);

        p2.add(p1);
        assertEquals( 798, p2.eval(3), 1);

    }

    @Test
    public void CorrectResultOfDividedPolyTerms() {
        PolySimpleInterface p1 = new Poly(new LinkedList<>());
        p1.add(new SimpleTerm(1,5));
        p1.add(new SimpleTerm(2,4));
        p1.add(new SimpleTerm(5,3));
        p1.add(new CosTerm(40));
        assertEquals( 500, p1.eval(3), 1);

        LinkedList<Scalar> myTerms2 = new LinkedList<>();
        PolySimpleInterface p2 = new Poly(myTerms2);

        p2.add(new SimpleTerm(2,4));
        p2.add(new SimpleTerm(5,3));
        assertEquals( 297, p2.eval(3), 1);

        PolyComplexInterface p3 = new DivideTerm(new LinkedList<>(), new LinkedList<>());
        p3.addToDivider(p1);
        p3.addToDividend(p2);
        assertEquals( 1.6, p3.eval(3), 1);

    }

}
