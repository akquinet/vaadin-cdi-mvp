/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.model.contact;

import java.util.List;

import de.akquinet.engineering.vaadin_cdi_mvp.model.ObservableModel;

/**
 * @author Oliver Damm
 */
public interface ContactModel extends ObservableModel<ContactModelObserver>
{

	public Long createOrUpdateContact(Long id, String firstname, String lastname, String email);

	public void deleteContact(Long id);

	public List<Contact> getContacts();

	public Contact getContact(Long id);

}
