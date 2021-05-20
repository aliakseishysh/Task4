package by.shyshaliaksey.task4.service;

import java.util.List;
import java.util.Map;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.exception.TextException;

public interface TextSearchService {

	List<AbstractComponent> findAllSentences(AbstractComponent textComposite);

	List<Integer> findSentencesWithLongestWord(AbstractComponent textComposite) throws TextException;

	List<AbstractComponent> findAllWords(AbstractComponent textComposite);

	List<AbstractComponent> findAllLetters(AbstractComponent textComposite);

	Map<AbstractComponent, Integer> findAllWordsWithSentencesNumbers(AbstractComponent textComposite);

}