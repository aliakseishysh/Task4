package by.shyshaliaksey.task4.entity;

import by.shyshaliaksey.task4.exception.TextException;

public abstract class AbstractComponent implements Cloneable {

	protected ComponentName componentName;
	protected AbstractComponent parent;
	
	protected AbstractComponent() {
	}
	
	protected AbstractComponent(ComponentName componentName, AbstractComponent parent) {
		this.componentName = componentName;
		this.parent = parent;
	}
	
	public ComponentName getComponentName() { return this.componentName; }
	
	public AbstractComponent getParent() { return this.parent; }
	
	public abstract char getContent() throws TextException;
	
	public abstract void add(AbstractComponent abstractComponent) throws TextException;
	
	public abstract void remove(AbstractComponent abstractComponent) throws TextException;

	public abstract AbstractComponent getChild(int index) throws TextException;
	
}
