/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oliver Damm
 */
public abstract class AbstractObservableModel<O> implements ObservableModel<O>
{

	private List<O> observers;

	protected AbstractObservableModel()
	{
		this.observers = new ArrayList<>();
	}

	@Override
	public void addObserver(O observer)
	{
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(O observer)
	{
		this.observers.remove(observer);
	}

	protected void notityObservers(ObserverNotifier<O> notifier)
	{
		for (O observer : this.observers)
		{
			notifier.notify(observer);
		}
	}

}
