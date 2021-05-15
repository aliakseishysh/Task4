package by.shyshaliaksey.task4.interpreter.impl;

import by.shyshaliaksey.task4.interpreter.Expression;

public class TerminalExpressionAnd implements Expression {

	@Override
	public void interpret(Context context) {
		Integer value1 = context.popValue();
		Integer value2 = context.popValue();
		context.pushValue(value2 & value1);
	}

	
}
