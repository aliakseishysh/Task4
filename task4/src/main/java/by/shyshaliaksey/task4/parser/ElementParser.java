package by.shyshaliaksey.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentType;
import by.shyshaliaksey.task4.exception.TextException;

public class ElementParser extends AbstractTextChain {

	private static final String ELEMENT = "^(\\t+| +|\\n+)*([\\w()<>|&^\\\\,'~-]+)([\\t\\n \\.…!?]*)$";

	@Override
	public void parse(AbstractComponent abstractComponent, String content) throws TextException {
		ComponentType componentType = abstractComponent.getComponentName();
		if (componentType == ComponentType.ELEMENT) {
			Pattern pattern = Pattern.compile(ELEMENT);
			Matcher matcher = pattern.matcher(content);
			while (matcher.find()) {
				this.parseSymbols(abstractComponent, matcher.group(1));
				this.nextInChain.parse(abstractComponent, matcher.group(2));
				this.parseSymbols(abstractComponent, matcher.group(3));
			}
		} else {
			this.nextInChain.parse(abstractComponent, content);
		}
	}

}
