/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.model.contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import de.akquinet.engineering.vaadin_cdi_mvp.model.AbstractObservableModel;
import de.akquinet.engineering.vaadin_cdi_mvp.model.ObserverNotifier;

/**
 * @author Oliver Damm
 */
@ApplicationScoped
public class ContactModelBean extends AbstractObservableModel<ContactModelObserver> implements ContactModel
{

	private Map<Long, Contact> contacts;

	@PostConstruct
	public void init()
	{
		this.contacts = new HashMap<>();
	}

	@Override
	public Long createOrUpdateContact(Long id, String firstname, String lastname, String email)
	{
		if (id != null)
		{
			Contact contact = this.contacts.get(id);
			contact.setFirstname(firstname);
			contact.setLastname(lastname);
			contact.setEmail(email);
		}
		else
		{
			Contact contact = new Contact();
			this.contacts.put(contact.getId(), contact);
			contact.setFirstname(firstname);
			contact.setLastname(lastname);
			contact.setEmail(email);

			id = contact.getId();
		}

		notityObservers(new ObserverNotifier<ContactModelObserver>()
		{

			@Override
			public void notify(ContactModelObserver observer)
			{
				observer.contactModelChanged();
			}

		});

		return id;
	}

	public void deleteContact(Long id)
	{
		this.contacts.remove(id);

		notityObservers(new ObserverNotifier<ContactModelObserver>()
		{

			@Override
			public void notify(ContactModelObserver observer)
			{
				observer.contactModelChanged();
			}

		});
	}

	@Override
	public List<Contact> getContacts()
	{
		List<Contact> result = new ArrayList<>(this.contacts.values());
		Collections.sort(result, new ContactComparator());
		return Collections.unmodifiableList(result);
	}

	@Override
	public Contact getContact(Long id)
	{
		return this.contacts.get(id);
	}

	private static class ContactComparator implements Comparator<Contact>
	{

		@Override
		public int compare(Contact contact1, Contact contact2)
		{
			if (contact1.getLastname().compareTo(contact2.getLastname()) != 0)
			{
				return contact1.getLastname().compareTo(contact2.getLastname());
			}
			else if (contact1.getFirstname().compareTo(contact2.getFirstname()) != 0)
			{
				return contact1.getFirstname().compareTo(contact2.getFirstname());
			}
			else
			{
				return contact1.getEmail().compareTo(contact2.getEmail());
			}
		}

	}

}
