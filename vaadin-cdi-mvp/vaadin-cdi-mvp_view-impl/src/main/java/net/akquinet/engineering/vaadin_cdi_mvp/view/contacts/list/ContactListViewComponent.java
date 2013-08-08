/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.list;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;

import net.akquinet.engineering.vaadin_cdi_mvp.view.VaadinView;

import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;

/**
 * @author Oliver Damm
 */
@Dependent
public class ContactListViewComponent extends Table implements ContactListView, VaadinView<Component>
{

	private static final long serialVersionUID = 1L;

	private ContactListViewObserver observer;

	@PostConstruct
	public void init()
	{
		setHeight("100%");
		setWidth("300px");
		setNullSelectionAllowed(true);
		setSelectable(true);
		setMultiSelect(false);
		setColumnHeaderMode(ColumnHeaderMode.HIDDEN);
		setImmediate(true);

		addValueChangeListener(new ContactListValueChangeListener());
	}

	@Override
	public void setObserver(ContactListViewObserver observer)
	{
		this.observer = observer;
	}

	@Override
	public <V> V unwrap(Class<V> type)
	{
		return type.cast(this);
	}

	public void setContacts(List<ContactItem> contacts)
	{
		BeanItemContainer<ContactItem> container = new BeanItemContainer<ContactItem>(ContactItem.class);
		container.addAll(contacts);
		setContainerDataSource(container);
		setVisibleColumns(new Object[] { "contact" });
	}

	@Override
	public void select(ContactItem contact)
	{
		super.select(contact);
	}

	@Override
	public void unselect()
	{
		Object value = getValue();
		if (value != null)
		{
			super.unselect(value);
		}
	}

	@Override
	public ContactItem getSelectedContact()
	{
		return (ContactItem) getValue();
	}

	@Override
	public Component getComponent()
	{
		return this;
	}

	private void contactListValueChanged()
	{
		if (this.observer != null)
		{
			Object value = getValue();
			if (value != null)
			{
				ContactItem item = (ContactItem) value;
				this.observer.contactListSelected(item.getId());
			}
			else
			{
				this.observer.contactListUnselected();
			}
		}
	}

	private class ContactListValueChangeListener implements ValueChangeListener
	{

		private static final long serialVersionUID = 1L;

		@Override
		public void valueChange(Property.ValueChangeEvent event)
		{
			contactListValueChanged();
		}

	}

}
