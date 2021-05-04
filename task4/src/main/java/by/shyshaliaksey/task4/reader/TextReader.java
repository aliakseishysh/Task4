package by.shyshaliaksey.task4.reader;

import java.util.List;

import by.shyshaliaksey.task4.exception.TextException;

public interface TextReader {

	public List<String> readAllLines(String path) throws TextException;

}
