/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.presenter.contacts.list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import de.akquinet.engineering.vaadin_cdi_mvp.events.ContactSelectedEvent;
import de.akquinet.engineering.vaadin_cdi_mvp.model.contact.Contact;
import de.akquinet.engineering.vaadin_cdi_mvp.model.contact.ContactModel;
import de.akquinet.engineering.vaadin_cdi_mvp.model.contact.ContactModelObserver;

import net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.list.ContactItem;
import net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.list.ContactListView;
import net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.list.ContactListViewObserver;

/**
 * @author Oliver Damm
 */
@SessionScoped
public class ContactListPresenterBean implements ContactListPresenter, ContactListViewObserver, ContactModelObserver,
		Serializable
{

	private static final long serialVersionUID = 1L;

	@Inject
	private ContactListView view;

	@Inject
	private ContactModel contactModel;

	@Inject
	private Event<ContactSelectedEvent> contactSelectedEvent;

	@PostConstruct
	public void init()
	{
		this.view.setObserver(this);
		this.contactModel.addObserver(this);
	}

	@Override
	public ContactListView getView()
	{
		return this.view;
	}

	@Override
	public void selectContact(Long id)
	{
		if (id != null)
		{
			Contact contact = this.contactModel.getContact(id);
			this.view.select(ContactListPresenterBean.toItem(contact));
		}
		else
		{
			this.view.unselect();
		}
	}

	@Override
	public Long getSelectedContact()
	{
		ContactItem contact = this.view.getSelectedContact();
		if (contact != null)
		{
			return contact.getId();
		}
		return null;
	}

	@Override
	public void contactListSelected(Long id)
	{
		this.contactSelectedEvent.fire(new ContactSelectedEvent(id));
	}

	@Override
	public void contactListUnselected()
	{
		this.contactSelectedEvent.fire(new ContactSelectedEvent(null));
	}

	@Override
	public void contactModelChanged()
	{
		List<ContactItem> items = new ArrayList<>();

		List<Contact> contacts = this.contactModel.getContacts();
		for (Contact contact : contacts)
		{
			items.add(ContactListPresenterBean.toItem(contact));
		}

		this.view.setContacts(items);
	}

	private static ContactItem toItem(Contact contact)
	{
		return new ContactItem(contact.getId(), contact.toString());
	}

}
