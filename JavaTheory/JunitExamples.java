package JavaTheory;

// Production code
class Calculator {
    public int add(int a, int b) { 
        return a + b; 
    }
 }
 
 // Test code
 import org.junit.Test;
 import static org.junit.Assert.assertEquals;
 
class CalculatorTest {
    @Test
    public void testAdd() {
       Calculator calc = new Calculator();
       assertEquals(5, calc.add(2, 3));
    }
 }
 