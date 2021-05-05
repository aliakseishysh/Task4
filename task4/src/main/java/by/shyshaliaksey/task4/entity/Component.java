package by.shyshaliaksey.task4.entity;

import by.shyshaliaksey.task4.exception.TextException;

public abstract class Component {

	protected ComponentName componentName;
	
	protected Component() {
	}
	
	protected Component(ComponentName componentName) {
		this.componentName = componentName;
	}
	
	public ComponentName getComponentName() { return this.componentName; }
	
	public abstract String getContent() throws TextException;
	
	public abstract void operation() throws TextException;

	public abstract void add(Component component) throws TextException;
	
	public abstract void remove(Component component) throws TextException;

	public abstract Object getChild(int index) throws TextException;
	
}
