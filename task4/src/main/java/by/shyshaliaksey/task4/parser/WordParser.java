package by.shyshaliaksey.task4.parser;

import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.Element;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class WordParser implements Chain {

	private static final String WORD = "^[A-Za-z]+$";
	private static final String EMPTY_LINE = "";
	private Chain nextChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void parse(AbstractComponent parentComponent, String contentToParse) throws TextException {
		if (parentComponent.getComponentName() == ComponentName.ELEMENT) {
			if (Pattern.matches(WORD, contentToParse)) {
				TextComposite wordComposite = new TextComposite(ComponentName.WORD);
				String[] stringArray = contentToParse.split(EMPTY_LINE);
				for (String symbol: stringArray) {
					wordComposite.add(new Element(ComponentName.SYMBOL, symbol));
				}
				parentComponent.add(wordComposite);
			} else {
				nextChain.parse(parentComponent, contentToParse);
			}
		} else {
			nextChain.parse(parentComponent, contentToParse);
		}
	}
	
}
