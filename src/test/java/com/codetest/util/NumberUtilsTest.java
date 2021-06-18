package com.codetest.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberUtilsTest {

    @Test
    void shouldVerifyIfGivenNumberIsDivisibleByAnotherNumber() {
        Assertions.assertTrue(NumberUtils.isDivisibleByN(25, 5));
        Assertions.assertTrue(NumberUtils.isDivisibleByN(21, 3));
        Assertions.assertTrue(NumberUtils.isDivisibleByN(55, 11));

        Assertions.assertFalse(NumberUtils.isDivisibleByN(123, 4));
        Assertions.assertFalse(NumberUtils.isDivisibleByN(2, 3));
        Assertions.assertFalse(NumberUtils.isDivisibleByN(5, 3));
    }

    @Test
    void shouldVerifyIfGivenNumberHasAnotherNumber() {
        Assertions.assertTrue(NumberUtils.hasN(25, 5));
        Assertions.assertTrue(NumberUtils.hasN(13, 3));
        Assertions.assertTrue(NumberUtils.hasN(73, 7));
        Assertions.assertTrue(NumberUtils.hasN(123, 2));

        Assertions.assertFalse(NumberUtils.hasN(96, 5));
        Assertions.assertFalse(NumberUtils.hasN(135, 4));
        Assertions.assertFalse(NumberUtils.hasN(27, 3));
    }
}