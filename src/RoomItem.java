/*
//
// Exit - represents an exit to a location
// 
// Last modification date : October 4, 2014
//
public class RoomItem 
{
	// Numerical codes
	public static final int UNDEFINED = 0;
	public static final int FOUNTAIN = 1;
	public static final int ITEM2 = 2;
	public static final int ITEM3  = 3;
	public static final int ITEM4  = 4;
	public static final int ITEM5    = 5;
	public static final int ITEM6  = 6;
	public static final int ITEM7 = 7;
	public static final int ITEM8 = 8;
	public static final int ITEM9 = 9;
	public static final int ITEM10 = 10;
	public static final int ITEM11 = 11;
	public static final int ITEM12 = 12;

	// String codes	
	public static final String[] dirName = 
	{ 
		"UNDEFINED",
		"FOUNTAIN",
		"ITEM2",
		"ITEM3",
		"ITEM4",
		"ITEM5",
		"ITEM6",
		"ITEM7",
		"ITEM8",
		"ITEM9",
		"ITEM10",
		"ITEM11",
		"ITEM12"
	};

	public static final String[] shortDirName = 
	{
		"NULL",
		"I1",
		"I2",
		"I3",
		"I4",
		"I5",
		"I6",
		"I7",
		"I8",
		"I9",
		"I10",
		"I11",
		"I12"		
	};

	// Member variables
	private Location m_leadsTo = null;
	private int m_direction;

	// Full name of direction eg SOUTHEAST
	private String m_directionName;

	// Shortened version of direction eg SE
	private String m_shortDirectionName;

	// Default constructor
	public Exit()
	{
		m_direction = Exit.UNDEFINED;
		m_leadsTo = null;
		m_directionName = dirName[UNDEFINED];
		m_shortDirectionName = shortDirName[UNDEFINED];
	}

	// Full constructor
	public Exit( int direction, Location leadsTo )
	{
		m_direction = direction;

		// Assign direction names
		if (direction <= dirName.length )
			m_directionName = dirName[m_direction];
		if (direction <= shortDirName.length )
			m_shortDirectionName = shortDirName[m_direction];

		// Assign location
		m_leadsTo = leadsTo;
	}

	// toString method
	public String toString()
	{
		return m_directionName;
	}

	// Assigns direction name
	public void setDirectionName( String dirname )
	{
		m_directionName = dirname;
	}

	// Returns direction name
	public String getDirectionName()
	{
		return m_directionName;
	}

	// Assigns short direction name
	public void setShortDirectionName ( String shortName )
	{
		m_shortDirectionName = shortName;
	}

	// Returns short direction name
	public String getShortDirectionName ()
	{
		return m_shortDirectionName;
	}

	// Assigns location
	public void setLeadsTo ( Location leadsTo )
	{
		m_leadsTo = leadsTo;
	}

	// Returns location
	public Location getLeadsTo (  )
	{
		return m_leadsTo;
	}

}
*/