package by.shyshaliaksey.task4.parser;

import org.testng.annotations.Test;

import by.shyshaliaksey.task4.interpreter.BinaryInterpreter;

public class NotationChangerTest {

	@Test
	public void bigTest() {
		NotationChanger notationChanger = new NotationChanger();
		String normalNotation = "5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1)";
		String postfixNotation = notationChanger.normalToPrefix(normalNotation);
		BinaryInterpreter interpreter = new BinaryInterpreter(postfixNotation);
		System.out.println(interpreter.calculate());
	}
	
	@Test
	public void leftShiftTest() {
		NotationChanger notationChanger = new NotationChanger();
		String normalNotation = "5<<2";
		String postfixNotation = notationChanger.normalToPrefix(normalNotation);
		BinaryInterpreter interpreter = new BinaryInterpreter(postfixNotation);
		System.out.println(interpreter.calculate());
		
	}
	
	
	@Test
	public void unaryNotTest() {
		NotationChanger notationChanger = new NotationChanger();
		String normalNotation = "~5&~8";
		String postfixNotation = notationChanger.normalToPrefix(normalNotation);
		System.out.println(postfixNotation);
		BinaryInterpreter interpreter = new BinaryInterpreter(postfixNotation);
		System.out.println(interpreter.calculate());
		
	}
}
