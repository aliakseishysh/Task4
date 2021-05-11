package by.shyshaliaksey.task4.service;

import java.util.List;


import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class TextChangeService {

	public void deleteAllSentencesWithWordCountLessThen(TextComposite textComposite, int wordCount) {
		TextSearchService textSearchService = new TextSearchService();
		List<AbstractComponent> sentences = textSearchService.findAllSentences(textComposite);
		
		for (AbstractComponent sentence: sentences) {
			List<AbstractComponent> words = textSearchService.findAllWords((TextComposite) sentence);
			if (words.size() < wordCount) {
				try {
					sentence.getParent().remove(sentence);
				} catch (TextException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void sortParagraphsBySentences(TextComposite textComposite) {
		List<AbstractComponent> paragraphs = textComposite.getComponents();
		paragraphs.sort(new ParagraphComparator());
	}
	
}
