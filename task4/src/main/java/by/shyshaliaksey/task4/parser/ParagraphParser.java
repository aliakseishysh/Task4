package by.shyshaliaksey.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class ParagraphParser extends Chain {

	private static final String SENTENCE = "\\s+[A-Za-z\\s-(),0-9<>~&|^']+\\.\\n?";

	@Override
	public void parse(AbstractComponent abstractComponent, String content) throws TextException {
		ComponentName name = abstractComponent.getComponentName();
		if (name == ComponentName.PARAGRAPH) {
			Pattern pattern = Pattern.compile(SENTENCE);
			Matcher matcher = pattern.matcher(content);
			while (matcher.find()) {
				String sentence = content.substring(matcher.start(), matcher.end());
				TextComposite sentenceComposite = new TextComposite(ComponentName.SENTENCE, abstractComponent);
				this.nextInChain.parse(sentenceComposite, sentence);
				abstractComponent.add(sentenceComposite);
			}
		} else {
			this.nextInChain.parse(abstractComponent, content);
		}
	}
	
}
