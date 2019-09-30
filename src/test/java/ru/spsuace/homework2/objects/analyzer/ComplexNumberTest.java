package ru.spsuace.homework2.objects.analyzer;

import org.junit.Test;
import ru.spsuace.homework2.objects.ComplexNumber;

import static org.junit.Assert.assertEquals;
public class ComplexNumberTest {

    ComplexNumber checkOut = new ComplexNumber(0,0).
            multiplication(new ComplexNumber(1,1));
    @Test
    public void ComplexNumberTest(){
        assertEquals("0",new ComplexNumber(0,0).toString());
        assertEquals("1.0 - i*1.0",new ComplexNumber(1,-1).toString());
        assertEquals("i1.0",new ComplexNumber(0,1).toString());
        assertEquals("1.0",new ComplexNumber(1,0).toString());
        assertEquals(0.0 ,new ComplexNumber(0,0).module(), 1e-3);
        assertEquals(55512,new ComplexNumber(1,2).hashCode());
        assertEquals(false,new ComplexNumber(1,2).equals(new ComplexNumber(0,0)));
        assertEquals( new ComplexNumber(0.0,0.0), checkOut);




    }

}
