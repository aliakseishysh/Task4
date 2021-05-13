package by.shyshaliaksey.task4.interpreter.impl;

import java.util.ArrayList;
import java.util.Scanner;

import by.shyshaliaksey.task4.interpreter.BinaryInterpreter;
import by.shyshaliaksey.task4.interpreter.Expression;

public class BinaryInterpreterImpl implements BinaryInterpreter {

	private ArrayList<Expression> listExpression;
	
	public BinaryInterpreterImpl(String expression) {
		listExpression = new ArrayList<>();
		parse(expression);
	}
	
	@Override
	public Number calculate() {
		Context context = new Context();
		for (Expression expression: listExpression) {
			expression.interpret(context);
		}
		return context.popValue();
	}
	
	private void parse(String expression) {
		for (String lexeme: expression.split("\\p{Blank}+")) {
			if (lexeme.isEmpty()) {
				continue;
			}
			char temp = lexeme.charAt(0);
			switch (temp) {
			case 'L':
				listExpression.add(new TerminalExpressionLeftShift());
				break;
			case 'R':
				listExpression.add(new TerminalExpressionRightShift());
				break;
			case 'U':
				listExpression.add(new TerminalExpressionUnsignedRightShift());
				break;
			case '~':
				listExpression.add(new TerminalExpressionUnaryNot());
				break;
			case '|':
				listExpression.add(new TerminalExpressionOr());
				break;
			case '&':
				listExpression.add(new TerminalExpressionAnd());
				break;
			case '^':
				listExpression.add(new TerminalExpressionXor());
				break;
			default:
				try (Scanner scanner = new Scanner(lexeme)) {
					if (scanner.hasNextInt()) {
						int value = scanner.nextInt();
						listExpression.add(new NonterminalExpression(value));
					}
				}
			}
		}
	}
}
	 