package by.shyshaliaksey.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.Element;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class ExpressionParser implements Chain {

	private static final String EXPRESSION = "^([~0-9|&()<>^]+)$";
	private static final String TEST_PLACEHOLDER = "0";
	
	private Chain nextChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	// TODO convert expression to postfix notation -> use interpreter pattern to work with postfix expression
	@Override
	public void parse(AbstractComponent parentComponent, String contentToParse) throws TextException {
		if (parentComponent.getComponentName() == ComponentName.ELEMENT) {
			if (Pattern.matches(EXPRESSION, contentToParse)) {
				parentComponent.add(new Element(ComponentName.NUMBER, TEST_PLACEHOLDER));
			} else {
				nextChain.parse(parentComponent, contentToParse);
			}
		} else {
			nextChain.parse(parentComponent, contentToParse);
		}
	}
	
}
