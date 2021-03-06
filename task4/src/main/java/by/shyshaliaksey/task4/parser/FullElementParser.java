package by.shyshaliaksey.task4.parser;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentType;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class FullElementParser extends AbstractTextChain {

	@Override
	public void parse(AbstractComponent abstractComponent, String content) throws TextException {
		if (abstractComponent.getComponentName() == ComponentType.ELEMENT) {
			TextComposite unknownElement = new TextComposite(ComponentType.UNKNOWN_ELEMENT, abstractComponent);
			this.parseSymbols(unknownElement, content);
			abstractComponent.add(unknownElement);
		} else {
			throw new TextException("Can not parse this element: " + content);
		}
	}
	
}
