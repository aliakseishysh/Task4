package by.shyshaliaksey.task4.interpreter.impl;

import by.shyshaliaksey.task4.interpreter.Expression;

public class TerminalExpressionUnaryNot implements Expression {

	@Override
	public void interpret(Context context) {
		Integer result = ~context.popValue();
		context.pushValue(result);
	}

	
}
