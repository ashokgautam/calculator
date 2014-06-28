import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

public class CalculatorTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void shouldWorkForAllCondition()
    {
        Calculator calculator = new Calculator();
        Calculator.TestFacade testFacade = new Calculator.TestFacade();
        testFacade.clear(calculator);
        testFacade.addToTempArray(calculator,"10");
        testFacade.addToTempArray(calculator,"+");
        testFacade.addToTempArray(calculator,"2");
        testFacade.accessResult(calculator);
        JTextArea display = testFacade.accessDisplay(calculator);
        System.out.println("result--->"+display.getText());
    }

    @Test
    public void shouldWorkForAllButtons()
    {
        Calculator calculator = new Calculator();
        Calculator.TestFacade testFacade = new Calculator.TestFacade();
        testFacade.clear(calculator);
        testFacade.addToTempArray(calculator,"10");
        testFacade.addToTempArray(calculator,"*");
        testFacade.addToTempArray(calculator,"2");
        testFacade.accessResult(calculator);
        JTextArea display = testFacade.accessDisplay(calculator);
        System.out.println("result--->"+display.getText());    }
    //Todo add Remining test cases
	@Test
    public void shouldWorkForSubtract()
    {
        Calculator calculator = new Calculator();
        Calculator.TestFacade testFacade = new Calculator.TestFacade();
        testFacade.clear(calculator);
        testFacade.addToTempArray(calculator,"10");
        testFacade.addToTempArray(calculator,"-");
        testFacade.addToTempArray(calculator,"2");
        testFacade.accessResult(calculator);
        JTextArea display = testFacade.accessDisplay(calculator);
        System.out.println("result--->"+display.getText());    }
		
		@Test
        public void shouldWorkForDivide()
    	{
        Calculator calculator = new Calculator();
        Calculator.TestFacade testFacade = new Calculator.TestFacade();
        testFacade.clear(calculator);
        testFacade.addToTempArray(calculator,"10");
        testFacade.addToTempArray(calculator,"/");
        testFacade.addToTempArray(calculator,"2");
        testFacade.accessResult(calculator);
        JTextArea display = testFacade.accessDisplay(calculator);
        System.out.println("result--->"+display.getText());    }

		@Test
        public void ZeroDividebyNum()
    	{
        Calculator calculator = new Calculator();
        Calculator.TestFacade testFacade = new Calculator.TestFacade();
        testFacade.clear(calculator);
        testFacade.addToTempArray(calculator,"0");
        testFacade.addToTempArray(calculator,"/");
        testFacade.addToTempArray(calculator,"2");
        testFacade.accessResult(calculator);
        JTextArea display = testFacade.accessDisplay(calculator);
        System.out.println("result--->"+display.getText());    }

		@Test
        public void NumDividebyZero()
    	{
        Calculator calculator = new Calculator();
        Calculator.TestFacade testFacade = new Calculator.TestFacade();
        testFacade.clear(calculator);
        testFacade.addToTempArray(calculator,"2");
        testFacade.addToTempArray(calculator,"/");
        testFacade.addToTempArray(calculator,"0");
        testFacade.accessResult(calculator);
        JTextArea display = testFacade.accessDisplay(calculator);
        System.out.println("result--->"+display.getText());    }

		@Test
        public void follingcondition()
    	{
        Calculator calculator = new Calculator();
        Calculator.TestFacade testFacade = new Calculator.TestFacade();
        testFacade.clear(calculator);
        testFacade.addToTempArray(calculator,"3");
        testFacade.addToTempArray(calculator,"-");
        testFacade.addToTempArray(calculator,"99");
        testFacade.accessResult(calculator);
        JTextArea display = testFacade.accessDisplay(calculator);
        System.out.println("result--->"+display.getText());    }

		@Test
        public void floatvalue()
    	{
        Calculator calculator = new Calculator();
        Calculator.TestFacade testFacade = new Calculator.TestFacade();
        testFacade.clear(calculator);
        testFacade.addToTempArray(calculator,"3.5");
        testFacade.addToTempArray(calculator,"-");
        testFacade.addToTempArray(calculator,"1.0");
        testFacade.accessResult(calculator);
        JTextArea display = testFacade.accessDisplay(calculator);
        System.out.println("result--->"+display.getText());    }

}