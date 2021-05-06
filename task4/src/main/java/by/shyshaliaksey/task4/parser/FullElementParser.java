package by.shyshaliaksey.task4.parser;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.Element;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class FullElementParser implements Chain {

	private static final String EMPTY_LINE = "";
	private Chain nextChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void parse(AbstractComponent abstractComponent, String content) throws TextException {
		if (abstractComponent.getComponentName() == ComponentName.ELEMENT) {
			TextComposite element = new TextComposite(ComponentName.ELEMENT);
			for (String symbol: content.split(EMPTY_LINE)) {
				element.add(new Element(ComponentName.SYMBOL, symbol));
			}
			abstractComponent.add(element);
		} else {
			throw new TextException("Can't parse this element");
		}
	}
	
}
