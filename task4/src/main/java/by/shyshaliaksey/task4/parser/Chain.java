package by.shyshaliaksey.task4.parser;

import by.shyshaliaksey.task4.entity.Component;
import by.shyshaliaksey.task4.exception.TextException;

public interface Chain {

	void setNextChain(Chain nextChain);

	void parse(Component parentComponent, String contentToParse) throws TextException;

}
