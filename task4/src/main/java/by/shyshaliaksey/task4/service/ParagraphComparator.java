package by.shyshaliaksey.task4.service;

import java.util.Comparator;

import by.shyshaliaksey.task4.entity.AbstractComponent;

public class ParagraphComparator implements Comparator<AbstractComponent> {

	@Override
	public int compare(AbstractComponent paragraph1, AbstractComponent paragraph2) {
		TextSearchService textSearchService = new TextSearchService();
		int sentenceCount1 = textSearchService.findAllSentences(paragraph1).size();
		int sentenceCount2 = textSearchService.findAllSentences(paragraph2).size();
		return sentenceCount1 - sentenceCount2;
	}

}
