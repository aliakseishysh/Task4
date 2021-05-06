package by.shyshaliaksey.task4.parser;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.exception.TextException;

public interface Chain {

	void setNextChain(Chain nextChain);

	void parse(AbstractComponent parentComponent, String contentToParse) throws TextException;

}
