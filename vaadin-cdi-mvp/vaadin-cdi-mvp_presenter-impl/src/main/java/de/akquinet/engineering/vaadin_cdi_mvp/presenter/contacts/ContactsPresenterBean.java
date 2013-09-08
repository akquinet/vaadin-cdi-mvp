/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.presenter.contacts;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import de.akquinet.engineering.vaadin_cdi_mvp.events.ContactEditingCanceled;
import de.akquinet.engineering.vaadin_cdi_mvp.events.ContactEditingFinished;
import de.akquinet.engineering.vaadin_cdi_mvp.events.ContactSelectedEvent;
import de.akquinet.engineering.vaadin_cdi_mvp.events.CreateContactRequestedEvent;
import de.akquinet.engineering.vaadin_cdi_mvp.events.DeleteContactRequestedEvent;
import de.akquinet.engineering.vaadin_cdi_mvp.events.EditContactRequestedEvent;
import de.akquinet.engineering.vaadin_cdi_mvp.model.contact.Contact;
import de.akquinet.engineering.vaadin_cdi_mvp.model.contact.ContactModel;
import de.akquinet.engineering.vaadin_cdi_mvp.presenter.Discriminator;
import de.akquinet.engineering.vaadin_cdi_mvp.presenter.contacts.editor.ContactEditorPresenter;
import de.akquinet.engineering.vaadin_cdi_mvp.presenter.contacts.list.ContactListPresenter;
import de.akquinet.engineering.vaadin_cdi_mvp.presenter.contacts.toolbar.ContactToolbarPresenter;
import de.akquinet.engineering.vaadin_cdi_mvp.view.contacts.ContactsView;

/**
 * @author Oliver Damm
 */
@SessionScoped
public class ContactsPresenterBean implements ContactsPresenter, Serializable
{

	private static final long serialVersionUID = 1L;

	@Inject
	private ContactsView view;

	@Inject
	@Discriminator("usecase1")
	private ContactToolbarPresenter contactToolbarPresenter;

	@Inject
	private ContactListPresenter contactListPresenter;

	@Inject
	private ContactEditorPresenter contactEditorPresenter;

	@Inject
	private ContactModel contactModel;

	@PostConstruct
	public void init()
	{
		this.view.setToolbarView(this.contactToolbarPresenter.getView());
		this.view.setListView(this.contactListPresenter.getView());
		this.view.setEditorView(this.contactEditorPresenter.getView());
	}

	@Override
	public ContactsView getView()
	{
		return this.view;
	}

	public void createContactRequested(@Observes @Discriminator("usecase1") CreateContactRequestedEvent event)
	{
		this.contactToolbarPresenter.enableButtons(false, false, false);
		this.contactListPresenter.selectContact(null);
		this.contactEditorPresenter.setContact(null);
		this.contactEditorPresenter.setStates(true, true);
	}

	public void editContactRequested(@Observes @Discriminator("usecase1") EditContactRequestedEvent event)
	{
		Long selectedContact = this.contactListPresenter.getSelectedContact();
		if (selectedContact != null)
		{
			this.contactToolbarPresenter.enableButtons(false, false, false);

			Contact contact = this.contactModel.getContact(selectedContact);
			this.contactEditorPresenter.setContact(contact);
			this.contactEditorPresenter.setStates(true, true);
		}
	}

	public void deleteContactedRequested(@Observes @Discriminator("usecase1") DeleteContactRequestedEvent event)
	{
		Long selectedContact = this.contactListPresenter.getSelectedContact();
		if (selectedContact != null)
		{
			this.contactModel.deleteContact(selectedContact);
		}
	}

	public void contactEditingFinised(@Observes ContactEditingFinished event)
	{
		this.contactListPresenter.selectContact(event.getId());
	}

	public void contactEditingCanceled(@Observes ContactEditingCanceled event)
	{
		this.contactToolbarPresenter.enableButtons(true, false, false);

		Long selectedContact = this.contactListPresenter.getSelectedContact();
		if (selectedContact != null)
		{
			Contact contact = this.contactModel.getContact(selectedContact);
			this.contactEditorPresenter.setContact(contact);
			this.contactEditorPresenter.setStates(true, false);
		}
		else
		{
			this.contactEditorPresenter.setStates(false, false);
		}
	}

	public void contactSelected(@Observes ContactSelectedEvent event)
	{
		if (event.getId() != null)
		{
			this.contactToolbarPresenter.enableButtons(true, true, true);

			final Contact contact = this.contactModel.getContact(event.getId());
			this.contactEditorPresenter.setContact(contact);
			this.contactEditorPresenter.setStates(true, false);
		}
		else
		{
			this.contactToolbarPresenter.enableButtons(true, false, false);

			this.contactEditorPresenter.setContact(null);
			this.contactEditorPresenter.setStates(false, false);
		}
	}

}
