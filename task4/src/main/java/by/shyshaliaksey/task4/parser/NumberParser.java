package by.shyshaliaksey.task4.parser;

import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.Element;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class NumberParser implements Chain {

	private static final String NUMBER = "^[0-9]+$";
	private static final String EMPTY_LINE = "";
	private Chain nextChain;
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void parse(AbstractComponent parentComponent, String contentToParse) throws TextException {
		if (parentComponent.getComponentName() == ComponentName.ELEMENT) {
			if (Pattern.matches(NUMBER, contentToParse)) {
				TextComposite numberComposite = new TextComposite(ComponentName.NUMBER);
				char[] charArray = contentToParse.toCharArray();
				for (char symbol: charArray) {
					numberComposite.add(new Element(ComponentName.DIGIT, symbol));
				}
				parentComponent.add(numberComposite);
			} else {
				nextChain.parse(parentComponent, contentToParse);
			}
		} else {
			nextChain.parse(parentComponent, contentToParse);
		}
	}
	
}
