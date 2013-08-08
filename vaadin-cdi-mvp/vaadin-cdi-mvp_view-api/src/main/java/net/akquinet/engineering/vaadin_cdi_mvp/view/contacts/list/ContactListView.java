/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.list;

import java.util.List;

import net.akquinet.engineering.vaadin_cdi_mvp.view.ObservableView;

/**
 * @author Oliver Damm
 */
public interface ContactListView extends ObservableView<ContactListViewObserver>
{

	public void setContacts(List<ContactItem> contacts);

	public void select(ContactItem contact);

	public void unselect();

	public ContactItem getSelectedContact();

}
