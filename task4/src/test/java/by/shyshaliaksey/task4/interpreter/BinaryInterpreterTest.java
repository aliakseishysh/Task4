package by.shyshaliaksey.task4.interpreter;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.shyshaliaksey.task4.interpreter.impl.BinaryInterpreterImpl;
import by.shyshaliaksey.task4.notation.NotationChanger;
import by.shyshaliaksey.task4.notation.impl.NotationChangerImpl;

public class BinaryInterpreterTest {

	@Test
	public void bigTest() {
		NotationChanger notationChangerImpl = new NotationChangerImpl();
		String normalNotation = "5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1)";
		String postfixNotation = notationChangerImpl.normalToPrefix(normalNotation);
		BinaryInterpreter interpreter = new BinaryInterpreterImpl(postfixNotation);
		Number actual = interpreter.calculate();
		Number expected = 5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1);
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void leftShiftTest() {
		NotationChanger notationChangerImpl = new NotationChangerImpl();
		String normalNotation = "5<<2";
		String postfixNotation = notationChangerImpl.normalToPrefix(normalNotation);
		BinaryInterpreter interpreter = new BinaryInterpreterImpl(postfixNotation);
		System.out.println(interpreter.calculate());
		
	}
	
	
	@Test
	public void simpleTest() {
		NotationChanger notationChangerImpl = new NotationChangerImpl();
		String normalNotation = "3|2&2";
		String postfixNotation = notationChangerImpl.normalToPrefix(normalNotation);
		System.out.println(postfixNotation);
		BinaryInterpreter interpreter = new BinaryInterpreterImpl(postfixNotation);
		Number actual = interpreter.calculate();
		Number expected = 3;
		System.out.println(interpreter.calculate());
		Assert.assertEquals(actual, expected);
	}
}
