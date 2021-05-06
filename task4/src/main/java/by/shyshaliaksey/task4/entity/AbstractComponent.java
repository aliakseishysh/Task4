package by.shyshaliaksey.task4.entity;

import by.shyshaliaksey.task4.exception.TextException;

public abstract class AbstractComponent {

	protected ComponentName componentName;
	
	protected AbstractComponent() {
	}
	
	protected AbstractComponent(ComponentName componentName) {
		this.componentName = componentName;
	}
	
	public ComponentName getComponentName() { return this.componentName; }
	
	public abstract String getContent() throws TextException;
	
	public abstract void operation() throws TextException;

	public abstract void add(AbstractComponent abstractComponent) throws TextException;
	
	public abstract void remove(AbstractComponent abstractComponent) throws TextException;

	public abstract AbstractComponent getChild(int index) throws TextException;
	
}
