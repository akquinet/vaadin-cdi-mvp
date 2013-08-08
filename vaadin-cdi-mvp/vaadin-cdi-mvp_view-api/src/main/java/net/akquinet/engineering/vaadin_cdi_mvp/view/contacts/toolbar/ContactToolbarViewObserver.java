/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.toolbar;

/**
 * @author Oliver Damm
 */
public interface ContactToolbarViewObserver
{

	public void buttonCreateContactClicked();

	public void buttonEditContactClicked();

	public void buttonDeleteContactClicked();

}
