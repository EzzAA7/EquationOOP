import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class DriverTest {

    @Test
    public void CorrectResultOfSimpleTerms() {

        LinkedList<Scalar> myTerms1 = new LinkedList<>();
        PolySimpleInterface p = new Poly();
        p.add(new SimpleTerm(1,5));
        p.add(new SimpleTerm(2,4));
        p.add(new SimpleTerm(5,3));

        assertEquals( 540.0, p.eval(3), 1);

    }

    @Test
    public void CorrectResultOfComplexTerms() {
        PolySimpleInterface p = new Poly();
        p.add(new CosTerm(40));

        assertEquals( -40.0, p.eval(3), 1);

    }

    @Test
    public void CorrectResultOfSimpleAndComplexTerms() {
        PolySimpleInterface p = new Poly();
        p.add(new SimpleTerm(5,3));
        p.add(new CosTerm(40));

        assertEquals( 95.0, p.eval(3), 1);

    }

    @Test
    public void CorrectResultOfMulTerms() {
        PolySimpleInterface mul = new MultiplyTerm();

        mul.add(new SimpleTerm(2,4));
        mul.add(new SimpleTerm(5,3));

        assertEquals( 21870.0, mul.eval(3), 1);

    }

    @Test
    public void CorrectResultOfSimpleAndMulTerms() {
        PolySimpleInterface p = new Poly();
        p.add(new SimpleTerm(1,5));
        p.add(new SimpleTerm(2,4));
        p.add(new SimpleTerm(5,3));
        p.add(new CosTerm(40));

        PolySimpleInterface mul = new MultiplyTerm();

        mul.add(new SimpleTerm(2,4));
        mul.add(new SimpleTerm(5,3));
        p.add(mul);

        assertEquals( 22370, p.eval(3), 1);

    }

    @Test
    public void CorrectResultOfAddPolyToPolyTerms() {
        PolySimpleInterface p1 = new Poly();
        p1.add(new SimpleTerm(1,5));
        p1.add(new SimpleTerm(2,4));
        p1.add(new SimpleTerm(5,3));
        p1.add(new CosTerm(40));
        assertEquals( 500, p1.eval(3), 1);
//        System.out.println(p1.eval(3));

        PolySimpleInterface p2 = new Poly();

        p2.add(new SimpleTerm(2,4));
        p2.add(new SimpleTerm(5,3));
        assertEquals( 297, p2.eval(3), 1);

        p2.add(p1);
        assertEquals( 798, p2.eval(3), 1);

    }

    @Test
    public void CorrectResultOfDividedPolyTerms() {
        PolySimpleInterface p1 = new Poly();
        p1.add(new SimpleTerm(1,5));
        p1.add(new SimpleTerm(2,4));
        p1.add(new SimpleTerm(5,3));
        p1.add(new CosTerm(40));
        assertEquals( 500, p1.eval(3), 1);

        PolySimpleInterface p2 = new Poly();

        p2.add(new SimpleTerm(2,4));
        p2.add(new SimpleTerm(5,3));
        assertEquals( 297, p2.eval(3), 1);

        PolyComplexInterface p3 = new DivideTerm();
        p3.addToDivider(p1);
        p3.addToDividend(p2);
        assertEquals( 1.6, p3.eval(3), 1);

    }

    @Test
    public void CorrectResultOfAllTerms() {
        PolySimpleInterface p1 = new Poly();
        p1.add(new SimpleTerm(1,5));
        p1.add(new SimpleTerm(2,4));
        p1.add(new SimpleTerm(5,3));
        p1.add(new CosTerm(40));
        assertEquals( 500, p1.eval(3), 1);

        PolySimpleInterface mul = new MultiplyTerm();
        mul.add(new SimpleTerm(2,4));
        mul.add(new SimpleTerm(5,3));
        assertEquals( 21870.0, mul.eval(3), 1);

        p1.add(mul);

        PolySimpleInterface p2 = new Poly();
        p2.add(new SimpleTerm(2,4));
        p2.add(new SinTerm(50));
        assertEquals( 169.0, p2.eval(3), 1);

        PolyComplexInterface p3 = new DivideTerm();
        p3.addToDivider(p1);
        p3.addToDividend(p2);
        assertEquals( 129, p3.eval(3), 5);

        PolySimpleInterface p4 = new Poly();
        p4.add(new SimpleTerm(1,5));
        p4.add(p3);
        assertEquals( 375, p4.eval(3), 1);

    }


}
