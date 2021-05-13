package by.shyshaliaksey.task4.service;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.exception.TextException;

public interface TextCalculationService {

	int calculateSentencesInParagraph(AbstractComponent paragraph) throws TextException;

	int calculateWordLength(AbstractComponent word) throws TextException;

	int calculateAllIdenticalWords(AbstractComponent textComposite, String wordToSearch);

	int calculateVowelCount(AbstractComponent component);

	int calculateConsonantCount(AbstractComponent component);

}