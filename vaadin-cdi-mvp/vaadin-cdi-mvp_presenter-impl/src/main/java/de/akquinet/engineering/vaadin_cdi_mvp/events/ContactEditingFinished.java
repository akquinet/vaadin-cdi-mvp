/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.events;

/**
 * @author Oliver Damm
 */
public class ContactEditingFinished
{

	private final Long id;

	public ContactEditingFinished(Long id)
	{
		this.id = id;
	}

	public Long getId()
	{
		return this.id;
	}

}
