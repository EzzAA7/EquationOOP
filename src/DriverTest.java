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
    public void CorrectResultOfMixedTerms() {
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

}
