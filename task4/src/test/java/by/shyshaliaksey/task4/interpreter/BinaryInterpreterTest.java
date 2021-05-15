package by.shyshaliaksey.task4.interpreter;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.shyshaliaksey.task4.interpreter.impl.BinaryInterpreterImpl;
import by.shyshaliaksey.task4.notation.NotationChanger;
import by.shyshaliaksey.task4.notation.impl.NotationChangerImpl;

public class BinaryInterpreterTest {

	@Test
	public void expression1Test() {
		NotationChanger notationChangerImpl = new NotationChangerImpl();
		String normalNotation = "13<<2";
		String postfixNotation = notationChangerImpl.normalToPrefix(normalNotation);
		BinaryInterpreter interpreter = new BinaryInterpreterImpl(postfixNotation);
		Number actual = interpreter.calculate();
		Number expected = 13<<2;
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void expression2Test() {
		NotationChanger notationChangerImpl = new NotationChangerImpl();
		String normalNotation = "3>>5";
		String postfixNotation = notationChangerImpl.normalToPrefix(normalNotation);
		BinaryInterpreter interpreter = new BinaryInterpreterImpl(postfixNotation);
		Number actual = interpreter.calculate();
		Number expected = 3>>5;
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void expression3Test() {
		NotationChanger notationChangerImpl = new NotationChangerImpl();
		String normalNotation = "~6&9|(3&4)";
		String postfixNotation = notationChangerImpl.normalToPrefix(normalNotation);
		BinaryInterpreter interpreter = new BinaryInterpreterImpl(postfixNotation);
		Number actual = interpreter.calculate();
		Number expected = ~6&9|(3&4);
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void expression4Test() {
		NotationChanger notationChangerImpl = new NotationChangerImpl();
		String normalNotation = "5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1)";
		String postfixNotation = notationChangerImpl.normalToPrefix(normalNotation);
		BinaryInterpreter interpreter = new BinaryInterpreterImpl(postfixNotation);
		Number actual = interpreter.calculate();
		Number expected = 5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1);
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void expression5Test() {
		NotationChanger notationChangerImpl = new NotationChangerImpl();
		String normalNotation = "(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78";
		String postfixNotation = notationChangerImpl.normalToPrefix(normalNotation);
		BinaryInterpreter interpreter = new BinaryInterpreterImpl(postfixNotation);
		Number actual = interpreter.calculate();
		Number expected =  (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78;
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void expression6Test() {
		NotationChanger notationChangerImpl = new NotationChangerImpl();
		String normalNotation = "(7^5|1&2<<(2|5>>2&71))|1200";
		String postfixNotation = notationChangerImpl.normalToPrefix(normalNotation);
		BinaryInterpreter interpreter = new BinaryInterpreterImpl(postfixNotation);
		Number actual = interpreter.calculate();
		Number expected = (7^5|1&2<<(2|5>>2&71))|1200;
		Assert.assertEquals(actual, expected);
	}
	

}
