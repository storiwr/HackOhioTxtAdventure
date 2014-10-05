import java.util.Vector;

//
//
// Location - represents a gaming location
//
//Original code created: October 08, 1997
//Adapted October 5, 2014
//
public class Location 
{
	// Member variables
	private String m_roomTitle;
	private String m_roomDescription;
	@SuppressWarnings("rawtypes")
	private Vector m_vecExits;

	// Blank constructor
	@SuppressWarnings("rawtypes")
	public Location()
	{
		// Blank title + description
		m_roomTitle = new String ();
		m_roomDescription = new String();
		m_vecExits = new Vector();
	}

	// Partial constructor
	@SuppressWarnings("rawtypes")
	public Location( String title )
	{
		// Assign title
		m_roomTitle = title;

		// Blank description
		m_roomDescription = new String();

		// Blank exits
		m_vecExits = new Vector();
	}

	// Full constructor
	@SuppressWarnings("rawtypes")
	public Location( String title, String description )
	{
		// Assign title + description
		m_roomTitle = title;
		m_roomDescription = description;

		// Blank exits
		m_vecExits = new Vector();
	}

	// toString method
	@Override
	public String toString()
	{
		return m_roomTitle;
	}

	// Adds an exit to this location
	@SuppressWarnings("unchecked")
	public void addExit ( Exit exit )
	{
		m_vecExits.addElement (exit);
	}

	// Removes an exit from this location
	public void removeExit ( Exit exit )
	{
		if (m_vecExits.contains (exit))
		{
			m_vecExits.removeElement (exit);
		}
	}

	// Returns a vector of exits
	@SuppressWarnings("rawtypes")
	public Vector getExits ()
	{
		// Return a clone, as we don't want an external
		// object to modify our original vector
		return (Vector) m_vecExits.clone();
	}
	
	// Returns location title
	public String getTitle()
	{
		return m_roomTitle;
	}

	// Assigns location title
	public void setTitle( String roomTitle )
	{
		m_roomTitle = roomTitle;
	}

	// Returns location description
	public String getDescription()
	{
		return m_roomDescription;
	}

	// Assigns location description
	public void setDescription( String roomDescription )
	{
		m_roomDescription = roomDescription;
	}
}