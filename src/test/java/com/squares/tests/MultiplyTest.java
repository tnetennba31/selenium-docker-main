package com.squares.tests;

import com.squares.pages.MultiplyPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiplyTest extends BaseTest {

    private MultiplyPage page;
    private String num;
    private int expected;

    @BeforeTest
    @Parameters({"num", "expected"})
    public void setupParameters(String num, String expected) {
        this.num = num;
        this.expected = Integer.parseInt(expected);
    }

    @Test
    public void test_1() {
        page = new MultiplyPage(num);
        Assert.assertNotNull(page);
    }

    @Test(dependsOnMethods = "test_1")
    public void test_2() {
        Assert.assertEquals(page.getSquare(), expected);
    }
}
