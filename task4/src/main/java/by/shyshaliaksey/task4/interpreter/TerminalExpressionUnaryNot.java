package by.shyshaliaksey.task4.interpreter;

public class TerminalExpressionUnaryNot implements Expression {

	@Override
	public void interpret(Context context) {
		context.pushValue(-context.popValue());
	}

	
}
