/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package net.akquinet.engineering.vaadin_cdi_mvp.view.contacts;

import net.akquinet.engineering.vaadin_cdi_mvp.view.View;
import net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.editor.ContactEditorView;
import net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.list.ContactListView;
import net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.toolbar.ContactToolbarView;

/**
 * @author Oliver Damm
 */
public interface ContactsView extends View
{

	public void setToolbarView(ContactToolbarView view);

	public void setListView(ContactListView view);

	public void setEditorView(ContactEditorView view);

}
