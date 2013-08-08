/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.model.contact;

/**
 * @author Oliver Damm
 */
public class Contact
{

	private static long nextId = 0;

	private Long id;
	private String firstname;
	private String lastname;
	private String email;

	public Contact()
	{
		this.id = ++Contact.nextId;
	}

	public Long getId()
	{
		return this.id;
	}

	public String getFirstname()
	{
		return this.firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return this.lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String toString()
	{
		return this.lastname + ", " + this.firstname + " (" + this.email + ")";
	}

}
