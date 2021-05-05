package by.shyshaliaksey.task4.entity;

import by.shyshaliaksey.task4.exception.TextException;

public class Client {

	private Component component;
	
	public Client(Component component) {
		this.component = component;
	}
	
	public void execute() throws TextException {
		component.operation();
	}
	
}
