package com.junit.learning;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class CalculatorTest {

    Calculator calculator = new Calculator();
    @Test
    public void testSum() {
        int actualResult=calculator.sum(1, 2);
        assertThat(actualResult).isEqualTo(3);
    }

    @Test
    public void compareTwoNum() {

        boolean isTrue = calculator.compareTwoNum(2, 2);
        assertThat(isTrue).isTrue();

    }

}