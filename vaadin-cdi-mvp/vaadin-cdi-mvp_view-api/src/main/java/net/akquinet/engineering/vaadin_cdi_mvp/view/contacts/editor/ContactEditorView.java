/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.editor;

import net.akquinet.engineering.vaadin_cdi_mvp.view.ObservableView;

/**
 * @author Oliver Damm
 */
public interface ContactEditorView extends ObservableView<ContactEditorViewObserver>
{

	public void setFirstname(String firstname);

	public String getFirstname();

	public void setLastname(String lastname);

	public String getLastname();

	public void setEmail(String email);

	public String getEmail();

	public void setEnabled(boolean enabled);

	public void setVisible(boolean visible);

}
