package by.shyshaliaksey.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.exception.TextException;

public class ElementParser extends Chain {

	private static final String ELEMENT_WITH_WHITESPACES = "^(\\t+| +|\\n+)*([\\w()<>|&^\\\\,'~-]+)([\\t\\n \\.]*)$";

	@Override
	public void parse(AbstractComponent abstractComponent, String content) throws TextException {
		ComponentName componentName = abstractComponent.getComponentName();
		if (componentName == ComponentName.ELEMENT) {
			Pattern pattern = Pattern.compile(ELEMENT_WITH_WHITESPACES);
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
