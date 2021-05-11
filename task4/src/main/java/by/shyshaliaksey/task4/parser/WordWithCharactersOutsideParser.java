package by.shyshaliaksey.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.Symbol;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class WordWithCharactersOutsideParser implements Chain {

	private static final String WORD_WITH_CHARACTERS_OUTSIDE = "^([-(),:'\\\"]+)?([A-Za-z]+)([-(),:'\\\".?!]+)?$";
	private static final String EMPTY_LINE = "";
	private Chain nextChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void parse(AbstractComponent parentComponent, String contentToParse) throws TextException {
		if (parentComponent.getComponentName() == ComponentName.ELEMENT) {
			Pattern pattern = Pattern.compile(WORD_WITH_CHARACTERS_OUTSIDE);
			Matcher matcher = pattern.matcher(contentToParse);
			if (matcher.find()) {
				String symbolsBefore = matcher.group(1);
				if (symbolsBefore != null) {
					for (char symbol: symbolsBefore.toCharArray()) {
						parentComponent.add(new Symbol(ComponentName.SYMBOL, parentComponent, symbol));
					}
				}
				
				String word = matcher.group(2);
				TextComposite wordComposite = new TextComposite(ComponentName.WORD, parentComponent);
				for (char symbol: word.toCharArray()) {
					wordComposite.add(new Symbol(ComponentName.SYMBOL, parentComponent, symbol));
				}
				parentComponent.add(wordComposite);
				
				String symbolsAfter = matcher.group(3);
				if (symbolsAfter != null) {
					for (char symbol: symbolsAfter.toCharArray()) {
						parentComponent.add(new Symbol(ComponentName.SYMBOL, parentComponent, symbol));
					}
				}
				
			} else {
				nextChain.parse(parentComponent, contentToParse);
			}
		} else {
			nextChain.parse(parentComponent, contentToParse);
		}
	}

}
