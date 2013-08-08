/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.model;

/**
 * @author Oliver Damm
 */
public interface ObserverNotifier<O>
{

	public void notify(O observer);

}
