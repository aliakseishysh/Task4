package by.shyshaliaksey.task4.service;

import java.util.List;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.TextComposite;

public interface TextChangeService {

	public void deleteAllSentencesWithWordCountLessThen(TextComposite textComposite, int wordCount);

	public List<AbstractComponent> sortParagraphsBySentences(TextComposite textComposite);

}