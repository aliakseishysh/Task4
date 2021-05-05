package by.shyshaliaksey.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.Component;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.Element;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class ElementParser implements Chain {

	private static final String ELEMENT_WITH_WHITESPACES = "^(\\t| +|\\n)([\\w()<>|&^.\\,'~-]+)(\\t| +|\\n)$";
	private Chain nextChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void parse(Component component, String content) throws TextException {
		if (component.getComponentName() == ComponentName.ELEMENT) {
			Pattern pattern = Pattern.compile(ELEMENT_WITH_WHITESPACES);
			Matcher matcher = pattern.matcher(content);
			while (matcher.find()) {
				String spaceSymbolsBeforeElement = matcher.group(1);
				Element element = new Element(ComponentName.SYMBOL, spaceSymbolsBeforeElement);
				component.add(element);

				String newElement = matcher.group(2);
				nextChain.parse(component, newElement);
	
				String spaceSymbolsAfterElement = matcher.group(3);
				element = new Element(ComponentName.SYMBOL, spaceSymbolsAfterElement);
				component.add(element);
				//nextChain.parse(elementComposite, element);
			}
		} else {
			nextChain.parse(component, content);
		}
	}
	
}
