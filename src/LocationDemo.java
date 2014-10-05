import java.util.*;
import java.applet.*;
import java.awt.*;

//
//
// LocationDemo - Demonstrates the use of location/exit objects
//
// Last modification date : October 08, 1997
//
public class LocationDemo extends Applet
{
	Location currentLocation;
	String command;

	TextField commandInput;
	TextArea  displayOutput;
	Button    buttonInput;

	// Constructor
	public LocationDemo()
	{
		super();
	}

	// Initialization method
	public void init()
	{
		super.init();

		// Define colors
		setBackground(Color.white);
		setForeground(Color.black);

		Panel appletPanel = new Panel();

		// Use a border layout
		BorderLayout b = new BorderLayout();
		appletPanel.setLayout (b);
		add(appletPanel);

		
		// Define UI items
		commandInput  = new TextField(20);
		displayOutput = new TextArea( 10, 60); // 10 rows x 60 chars
		buttonInput   = new Button("Go");
		Panel inputPanel = new Panel();

		// Add components to our layout / panels
		inputPanel.add(commandInput);
		inputPanel.add(buttonInput);
		appletPanel.add("North", displayOutput);
		appletPanel.add("South", inputPanel);

		// Create two locations
		Location l1 = new Location ("Entrance to hall", "You stand at the entrance of a long hallway. The hallway gets darker\nand darker, and you cannot see what lies beyond. To the east\nis an old oaken door, unlocked and beckonning");
		Location l2 = new Location ("End of hall", "You have reached the end of a long dark hallway. You can\nsee nowhere to go but back");
		Location l3 = new Location ("Small study", "This is a small and cluttered study, containing a desk covered with\npapers. Though they no doubt are of some importance,\nyou cannot read their writing");
		Location l4 = new Location ("Large Courtyard", "You find yourself outside, a full moon \noverhead. In the center is a large fountain\n ovegrown with vines and moss. \nThe other side is dark.");
		Location l5 = new Location ("As you approach the fountain, you hear a deep rumbling sound far below.\nYou hear a sudden gurgling sound. Water gushes up from the old fountain.");
		Location l6 = new Location ("Cautiously, you peer over the edge into the gently rippling \nwater. It is remarkably clear. Odd considering how old it appears. \nYou see something at the bottom of the fountain.");
		// Create an exit for l1
		l1.addExit (new Exit(Exit.NORTH, l2));
		l1.addExit (new Exit(Exit.EAST, l3));
		l1.addExit (new Exit(Exit.NORTHEAST, l4));

		// Create an exit for l2
		l2.addExit (new Exit(Exit.SOUTH, l1));

		// Create an exit for l3
		l3.addExit (new Exit(Exit.WEST, l1));
		
		// Create an exit for l4
		l4.addExit (new Exit(Exit.FORWARD, l5));		
		l4.addExit (new Exit(Exit.SOUTHWEST, l1));
		
		// Create an exit for 15
		l5.addExit (new Exit(Exit.PEER, l6));
		l5.addExit (new Exit(Exit.BACK, l4));
		
		// Create an exit for 15
				l6.addExit (new Exit(Exit.REACH, l6));
				l6.addExit (new Exit(Exit.BACK, l4));

		// Set up room locations
		currentLocation = l1;

		// Show first location
		showLocation();
		repaint();
	}

	private void showLocation()
	{
		// Show room title
		displayOutput.append( "\n" + currentLocation.getTitle() + "\n" );
		displayOutput.append( "\n" );
		
		// Show room description 
		displayOutput.append( currentLocation.getDescription() + "\n" );

		// Show available exits
		displayOutput.append( "\nAvailable exits : \n" );
		for (Enumeration<?> e = currentLocation.getExits().elements(); e.hasMoreElements();)
		{
			Exit an_exit = (Exit) e.nextElement();
			displayOutput.append (an_exit + "\n");
		}		
		
	}

	public boolean action (Event evt, Object focus)
	{
		String command;

		// Was a button pressed ? 
		if (evt.target instanceof Button )
		{
			// Obtain string
			command = commandInput.getText();

			// Don't parse blank commands
			if (command.length() == 0)
				return true;

			// Convert to uppercase for comparison
			command = command.toUpperCase();

			// Search for an exit match
			for (Enumeration<?> e = currentLocation.getExits().elements(); e.hasMoreElements();)
			{
				Exit an_exit = (Exit) e.nextElement();

				if ( (an_exit.getDirectionName().compareTo(command) == 0) ||
					 (an_exit.getShortDirectionName().compareTo(command) == 0 )
				   )
				{
					// Set location to the location pointed to by exit
					currentLocation = an_exit.getLeadsTo();

					// Show new location
					showLocation();

					// Clear text area
					commandInput.setText (new String());

					// Event handled
					return true;
				}				
			}

			// If code reaches here, direction is invalid
			displayOutput.append ("\nHuh? Invalid direction!\n");

			// Clear text area
			commandInput.setText (new String());

			// Event handled
			return true;
		}
		// Event not handled
		else return false;
	}

}