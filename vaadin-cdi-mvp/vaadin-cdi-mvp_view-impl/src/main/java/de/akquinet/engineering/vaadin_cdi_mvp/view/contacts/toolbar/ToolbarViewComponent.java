/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.view.contacts.toolbar;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;


import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

import de.akquinet.engineering.vaadin_cdi_mvp.view.VaadinView;
import de.akquinet.engineering.vaadin_cdi_mvp.view.contacts.toolbar.ContactToolbarView;
import de.akquinet.engineering.vaadin_cdi_mvp.view.contacts.toolbar.ContactToolbarViewObserver;

/**
 * @author Oliver Damm
 */
@Dependent
public class ToolbarViewComponent extends HorizontalLayout implements ContactToolbarView, VaadinView<Component>
{

	private static final long serialVersionUID = 1L;

	private ContactToolbarViewObserver observer;
	private Button buttonCreateContact;
	private Button buttonEditContact;
	private Button buttonDeleteContact;

	@PostConstruct
	public void init()
	{
		this.buttonCreateContact = new Button("Kontakt anlegen");
		this.buttonCreateContact.addClickListener(new ButtonCreateClickListener());

		this.buttonEditContact = new Button("Kontakt bearbeiten");
		this.buttonEditContact.addClickListener(new ButtonEditClickListener());

		this.buttonDeleteContact = new Button("Kontakt löschen");
		this.buttonDeleteContact.addClickListener(new ButtonDeleteClickListener());

		addComponent(this.buttonCreateContact);
		addComponent(this.buttonEditContact);
		addComponent(this.buttonDeleteContact);

		setMargin(true);
		setSpacing(true);
	}

	@Override
	public <V> V unwrap(Class<V> type)
	{
		return type.cast(this);
	}

	@Override
	public void setObserver(ContactToolbarViewObserver observer)
	{
		this.observer = observer;
	}

	@Override
	public void enableButtonCreate(boolean enabled)
	{
		this.buttonCreateContact.setEnabled(enabled);
	}

	@Override
	public void enableButtonEdit(boolean enabled)
	{
		this.buttonEditContact.setEnabled(enabled);
	}

	@Override
	public void enableButtonDelete(boolean enabled)
	{
		this.buttonDeleteContact.setEnabled(enabled);
	}

	@Override
	public Component getComponent()
	{
		return this;
	}

	private void buttonCreateContactClicked()
	{
		if (ToolbarViewComponent.this.observer != null)
		{
			this.observer.buttonCreateContactClicked();
		}
	}

	private void buttonEditContactClicked()
	{
		if (ToolbarViewComponent.this.observer != null)
		{
			this.observer.buttonEditContactClicked();
		}
	}

	private void buttonDeleteContactClicked()
	{
		if (ToolbarViewComponent.this.observer != null)
		{
			this.observer.buttonDeleteContactClicked();
		}
	}

	private class ButtonCreateClickListener implements ClickListener
	{

		private static final long serialVersionUID = 1L;

		@Override
		public void buttonClick(ClickEvent event)
		{
			buttonCreateContactClicked();
		}

	}

	private class ButtonEditClickListener implements ClickListener
	{

		private static final long serialVersionUID = 1L;

		@Override
		public void buttonClick(ClickEvent event)
		{
			buttonEditContactClicked();
		}

	}

	private class ButtonDeleteClickListener implements ClickListener
	{

		private static final long serialVersionUID = 1L;

		@Override
		public void buttonClick(ClickEvent event)
		{
			buttonDeleteContactClicked();
		}

	}

}
