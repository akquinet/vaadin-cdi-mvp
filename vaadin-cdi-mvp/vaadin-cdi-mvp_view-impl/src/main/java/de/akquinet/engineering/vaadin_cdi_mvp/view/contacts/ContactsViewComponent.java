/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.view.contacts;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;


import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import de.akquinet.engineering.vaadin_cdi_mvp.view.VaadinView;
import de.akquinet.engineering.vaadin_cdi_mvp.view.contacts.ContactsView;
import de.akquinet.engineering.vaadin_cdi_mvp.view.contacts.editor.ContactEditorView;
import de.akquinet.engineering.vaadin_cdi_mvp.view.contacts.list.ContactListView;
import de.akquinet.engineering.vaadin_cdi_mvp.view.contacts.toolbar.ContactToolbarView;

/**
 * @author Oliver Damm
 */
@Dependent
public class ContactsViewComponent extends VerticalLayout implements ContactsView, VaadinView<Component>
{

	private static final long serialVersionUID = 1L;

	private Component componentToolbar;
	private Component componentList;
	private Component componentEditor;
	private HorizontalLayout layoutListEditor;

	@PostConstruct
	public void init()
	{
		this.componentToolbar = new Label();
		this.componentList = new Label();
		this.componentEditor = new Label();

		// Layout
		this.layoutListEditor = new HorizontalLayout();
		this.layoutListEditor.setSizeFull();
		this.layoutListEditor.setMargin(new MarginInfo(false, true, true, true));
		this.layoutListEditor.setSpacing(true);
		this.layoutListEditor.addComponent(this.componentList);
		this.layoutListEditor.addComponent(this.componentEditor);

		addComponent(this.componentToolbar);
		addComponent(this.layoutListEditor);
		setExpandRatio(this.layoutListEditor, 1f);

		setSizeFull();
		setSpacing(true);
	}

	@Override
	public <V> V unwrap(Class<V> type)
	{
		return type.cast(this);
	}

	@Override
	public void setToolbarView(ContactToolbarView view)
	{
		Component component = view.unwrap(VaadinView.class).getComponent();
		replaceComponent(this.componentToolbar, component);
		this.componentToolbar = component;
	}

	@Override
	public void setListView(ContactListView view)
	{
		Component component = view.unwrap(VaadinView.class).getComponent();
		this.layoutListEditor.replaceComponent(this.componentList, component);
		this.componentList = component;
	}

	@Override
	public void setEditorView(ContactEditorView view)
	{
		Component component = view.unwrap(VaadinView.class).getComponent();
		this.layoutListEditor.replaceComponent(this.componentEditor, component);
		this.layoutListEditor.setExpandRatio(component, 1f);
		this.componentEditor = component;
	}

	@Override
	public Component getComponent()
	{
		return this;
	}

}
