package by.shyshaliaksey.task4.comparator;

import java.util.Comparator;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.service.TextSearchService;
import by.shyshaliaksey.task4.service.impl.TextSearchServiceImpl;

public class ParagraphBySentenceCountComparator implements Comparator<AbstractComponent> {

	@Override
	public int compare(AbstractComponent paragraph1, AbstractComponent paragraph2) {
		TextSearchService textSearchServiceImpl = new TextSearchServiceImpl();
		int sentenceCount1 = textSearchServiceImpl.findAllSentences(paragraph1).size();
		int sentenceCount2 = textSearchServiceImpl.findAllSentences(paragraph2).size();
		return sentenceCount1 - sentenceCount2;
	}

}
