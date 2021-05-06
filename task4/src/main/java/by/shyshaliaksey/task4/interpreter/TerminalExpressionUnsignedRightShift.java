package by.shyshaliaksey.task4.interpreter;

public class TerminalExpressionUnsignedRightShift implements Expression {

	@Override
	public void interpret(Context context) {
		context.pushValue(context.popValue() >>> context.popValue());
	}

	
}
