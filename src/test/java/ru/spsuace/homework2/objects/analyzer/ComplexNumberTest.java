package ru.spsuace.homework2.objects.analyzer;

import org.junit.Test;
import ru.spsuace.homework2.objects.ComplexNumber;

import static org.junit.Assert.assertEquals;
public class ComplexNumberTest {

    @Test
    public void ComplexNumberTest(){
        assertEquals("0",new ComplexNumber(0,0).toString());
        assertEquals("1 - i*1",new ComplexNumber(1,-1).toString());
        assertEquals("i1",new ComplexNumber(0,1).toString());
        assertEquals("1",new ComplexNumber(1,0).toString());
        assertEquals(0.0 ,new ComplexNumber(0,0).module(), 1e-3);
        assertEquals(55512,new ComplexNumber(1,2).hashCode());
        assertEquals( "0",new ComplexNumber(0,0).multiplication(new ComplexNumber(1,1),new ComplexNumber(0,0)));




    }

}
