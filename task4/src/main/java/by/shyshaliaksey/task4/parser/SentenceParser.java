package by.shyshaliaksey.task4.parser;

import by.shyshaliaksey.task4.entity.Component;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.exception.TextException;

public class SentenceParser implements Chain {

private Chain nextChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void parse(Component component) throws TextException {
		if (component.getComponentName() == ComponentName.SENTENCE) {
			// TODO parse sentence
			String content = component.getContent();
		} else {
			nextChain.parse(component);
		}
	}

}
