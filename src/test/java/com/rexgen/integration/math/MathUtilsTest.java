package com.rexgen.integration.math;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilsTest {

    @Test
    public void testAdd() {
        // 준비
        int a = 5;
        int b = 3;
        int expected = 8;

        // 실행
        int result = MathUtils.add(a, b);

        // 검증
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testMultiply() {
        // 준비
        int a = 5;
        int b = 3;
        int expected = 15;

        // 실행
        int result = MathUtils.multiply(a, b);

        // 검증
        Assert.assertEquals(expected, result);
    }
}
