package by.shyshaliaksey.task4.parser;

import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.Symbol;
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
				TextComposite wordComposite = new TextComposite(ComponentName.WORD, parentComponent);
				char[] charArray = contentToParse.toCharArray();
				for (char symbol: charArray) {
					wordComposite.add(new Symbol(ComponentName.SYMBOL, parentComponent, symbol));
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
