/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.view;

/**
 * @author Oliver Damm
 */
public interface ObservableView<O> extends View
{

	public void setObserver(O observer);

}
