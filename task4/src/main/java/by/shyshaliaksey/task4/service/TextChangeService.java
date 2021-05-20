package by.shyshaliaksey.task4.service;

import by.shyshaliaksey.task4.entity.TextComposite;

public interface TextChangeService {

	public void deleteAllSentencesWithWordCountLessThen(TextComposite textComposite, int wordCount);

	public void sortParagraphsBySentences(TextComposite textComposite);

}