package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ISINGeneratorTest {
    @Test
    public void testCheckDigitCalculation() {
        String test1 = "DE123456789";
        int digit1 = ISINGenerator.getCheckedDigit(test1);
        assertEquals(6, digit1);

        String test2 = "VBX3EJASGFY9";
        int digit2 = ISINGenerator.getCheckedDigit(test2);
        assertEquals(5, digit2);
    }
    @Test
    public void testLengthOfISINnumber() {
        String ISINnumber = ISINGenerator.generateISIN();
        assertEquals(12, ISINnumber.length());
    }
    @Test
    public void isValidISINnumber(){
        String ISINnumber = ISINGenerator.generateISIN();
        boolean isValid = true;
        if (!((ISINnumber.charAt(0) >= 'A' && ISINnumber.charAt(0) <= 'Z' )
            && (ISINnumber.charAt(1) >= 'A' && ISINnumber.charAt(1) <= 'Z'))) {
            isValid = false;
        }
        if (!((ISINnumber.charAt(11) >= '0' && ISINnumber.charAt(11) <= '9'))) {
            isValid = false;
        }
        assertTrue(isValid);
    }


}
