package by.shyshaliaksey.task4.entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractComponent implements Iterable<AbstractComponent>, Cloneable {

	protected ComponentName componentName;
	protected AbstractComponent parent;
	
	protected AbstractComponent() {
	}
	
	protected AbstractComponent(ComponentName componentName, AbstractComponent parent) {
		this.componentName = componentName;
		this.parent = parent;
	}
	
	public Iterator<AbstractComponent> iterator() {
		List<AbstractComponent> list = new LinkedList<>();
		addAllToList(list);
		list.add(this);
		return list.iterator();
    }
	
	public ComponentName getComponentName() { return this.componentName; }
	
	public abstract int getComponentsSize();
	
	public AbstractComponent getParent() { return this.parent; }
	
	public abstract char getContent();
	
	public abstract void add(AbstractComponent abstractComponent);
	
	public abstract void remove(AbstractComponent abstractComponent);
	
	public abstract AbstractComponent getChild(int index);

	protected abstract void addAllToList(List<AbstractComponent> abstractComponents);
	
}
