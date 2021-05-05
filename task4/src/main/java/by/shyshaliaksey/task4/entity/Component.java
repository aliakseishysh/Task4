package by.shyshaliaksey.task4.entity;

import by.shyshaliaksey.task4.exception.TextException;

public abstract class Component {

	protected ComponentName componentName;
	protected String content;
	
	protected Component() {
	}
	
	protected Component(ComponentName componentName, String content) {
		this.componentName = componentName;
		this.content = content;
	}
	
	public ComponentName getComponentName() { return this.componentName; }
	
	public String getContent() { return this.content; }
	
	public abstract void operation() throws TextException;

	public abstract void add(Component component) throws TextException;
	
	public abstract void remove(Component component) throws TextException;

	public abstract Object getChild(int index) throws TextException;
	
}
