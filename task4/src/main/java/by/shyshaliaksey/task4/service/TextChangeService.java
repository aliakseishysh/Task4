package by.shyshaliaksey.task4.service;

import by.shyshaliaksey.task4.entity.TextComposite;

public interface TextChangeService {

	void deleteAllSentencesWithWordCountLessThen(TextComposite textComposite, int wordCount);

	void sortParagraphsBySentences(TextComposite textComposite);

}