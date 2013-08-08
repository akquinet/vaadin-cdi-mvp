/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.presenter.contacts.toolbar;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.toolbar.ContactToolbarView;
import net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.toolbar.ContactToolbarViewObserver;
import de.akquinet.engineering.vaadin_cdi_mvp.events.CreateContactRequestedEvent;
import de.akquinet.engineering.vaadin_cdi_mvp.events.DeleteContactRequestedEvent;
import de.akquinet.engineering.vaadin_cdi_mvp.events.EditContactRequestedEvent;

/**
 * @author Oliver Damm
 */
public abstract class AbstractContactToolbarPresenterBean implements ContactToolbarPresenter,
		ContactToolbarViewObserver, Serializable
{

	private static final long serialVersionUID = 1L;

	@Inject
	private ContactToolbarView view;

	@PostConstruct
	public void init()
	{
		this.view.setObserver(this);
	}

	@Override
	public ContactToolbarView getView()
	{
		return this.view;
	}

	@Override
	public void enableButtons(boolean createEnabled, boolean editEnabled, boolean deleteEnabled)
	{
		this.view.enableButtonCreate(createEnabled);
		this.view.enableButtonEdit(editEnabled);
		this.view.enableButtonDelete(deleteEnabled);
	}

	@Override
	public void buttonCreateContactClicked()
	{
		getCreateContactRequestedEvent().fire(new CreateContactRequestedEvent());
	}

	@Override
	public void buttonEditContactClicked()
	{
		getEditContactRequestedEvent().fire(new EditContactRequestedEvent());
	}

	@Override
	public void buttonDeleteContactClicked()
	{
		getDeleteContactRequestedEvent().fire(new DeleteContactRequestedEvent());
	}

	protected abstract Event<CreateContactRequestedEvent> getCreateContactRequestedEvent();

	protected abstract Event<EditContactRequestedEvent> getEditContactRequestedEvent();

	protected abstract Event<DeleteContactRequestedEvent> getDeleteContactRequestedEvent();

}
