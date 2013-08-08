/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.list;

/**
 * @author Oliver Damm
 */
public interface ContactListViewObserver
{

	public void contactListSelected(Long id);

	public void contactListUnselected();

}
