package by.shyshaliaksey.task4.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.shyshaliaksey.task4.comparator.ParagraphBySentenceCountComparator;
import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.service.TextChangeService;
import by.shyshaliaksey.task4.service.TextSearchService;

public class TextChangeServiceImpl implements TextChangeService {

	@Override
	public void deleteAllSentencesWithWordCountLessThen(TextComposite textComposite, int wordCount) {
		TextSearchService textSearchServiceImpl = new TextSearchServiceImpl();
		List<AbstractComponent> sentences = textSearchServiceImpl.findAllSentences(textComposite);
		
		for (AbstractComponent sentence: sentences) {
			List<AbstractComponent> words = textSearchServiceImpl.findAllWords(sentence);
			if (words.size() < wordCount) {
				sentence.getParent().remove(sentence);
			}
		}
	}
	
	@Override
	public void sortParagraphsBySentences(TextComposite textComposite) {
		List<AbstractComponent> paragraphs = new ArrayList<>();
		for (int i = 0; i < textComposite.getComponentsSize(); i++) {
			paragraphs.add(textComposite.getChild(i));
		}
		paragraphs.sort(new ParagraphBySentenceCountComparator());
	}
	
}
