package ru.spsuace.homework2.objects;

import org.junit.Test;
import ru.spsuace.homework2.objects.ComplexNumber;
import static org.junit.Assert.assertEquals;

public class ComplexNumberTest {
    @Test
    public  void ComplexNumber(){
        assertEquals("1.0+1.0i",new ComplexNumber(1,1).toString());
    }
}
