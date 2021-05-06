package by.shyshaliaksey.task4.interpreter;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryInterpreter {

	private ArrayList<Expression> listExpression;
	
	public BinaryInterpreter(String expression) {
		listExpression = new ArrayList<>();
		parse(expression);
	}
	
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
				Scanner scan = new Scanner(lexeme);
				if (scan.hasNextInt()) {
					int value = scan.nextInt();
					listExpression.add(new NonterminalExpression(value));
				}
			}
		}
	}
}
	 