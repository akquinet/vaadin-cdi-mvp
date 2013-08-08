/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.list;

/**
 * @author Oliver Damm
 */
public class ContactItem
{

	private Long id;
	private String contact;

	public ContactItem(Long id, String contact)
	{
		this.id = id;
		this.contact = contact;
	}

	public Long getId()
	{
		return this.id;
	}

	public String getContact()
	{
		return this.contact;
	}

	public String toString()
	{
		return this.contact;
	}

	public int hashCode()
	{
		return this.id.hashCode();
	}

	public boolean equals(Object o)
	{
		if (o instanceof ContactItem == false)
		{
			return false;
		}

		ContactItem that = (ContactItem) o;
		return that.id.equals(this.id);
	}

}
