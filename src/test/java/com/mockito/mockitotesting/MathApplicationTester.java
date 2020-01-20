package com.mockito.mockitotesting;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import com.mockito.mockitotesting.mathApp.MathApplication;
import com.mockito.mockitotesting.mathApp.interfaces.CalculatorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner ;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    CalculatorService calcService;

    @Test
    public void testAdd(){
        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(30.00);

        //test the add functionality
        Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);

        //verify the behavior
        verify(calcService).add(10.0, 20.0);
    }

    @Test
    //Just test what actually verify is returning when arguments are different as expected
    public void testAdd_WRONG(){
        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(30.00);

        //test the add functionality
        Assert.assertEquals(calcService.add(10.0, 20.0),30.0,0);

        //verify the behavior
        verify(calcService).add(20.0, 30.0);
    }
}
