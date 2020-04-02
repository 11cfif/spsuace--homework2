package ru.spsuace.homework2.objects.simple;

import org.junit.Assert;
import org.junit.Test;

public class ComplexNumberTest {
    @Test
    public void sumComplexNumberTest() {
        Assert.assertEquals(new ComplexNumber(5, 8),
                new ComplexNumber(3, 5).sum(new ComplexNumber(2, 3)));
        Assert.assertEquals(null, new ComplexNumber(3, 5).sum(null));
    }

    @Test
    public void multiplyComplexNumberTest() {
        Assert.assertEquals(new ComplexNumber(4,17),
                ComplexNumber.multiply(new ComplexNumber(5, 6), new ComplexNumber(2, 1)));
        Assert.assertEquals(null, ComplexNumber.multiply(new ComplexNumber(5, 6), null));
    }
}
