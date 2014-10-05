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
		Location l6 = new Location ("Cautiously, you peer over the edge into the gently rippling \nwater. It is remarkably clear. Odd, considering how old it appears. \nYou see something at the bottom of the fountain.");
		Location l7 = new Location ("You reach your hand into the cool water in an effort to retrieve the \nobject. Suddenly a powerful burning sensation rips through your arm. You yank your hand out \nand return to middle of the courtyard.");
		Location l8 = new Location ("The far side is pitch black. Despite the full moon, \nno light seems to penetrate these shadows. You reach out blindly \nand feel something cold under your hand.");
		Location l9 = new Location ("A heavy door swings open. Stumbling, you find yourself in a cavernous room. Moonlight from a row of tall windows on the far wall is your only source of light. Ahead you hear a crash.");
		Location l10 = new Location ("Description of l10");
		Location l11 = new Location ("Description of l11,  no way back ");
		Location l12 = new Location ("Description of l12 , no way back");
		Location l13 = new Location ("Description of l13");
		Location l14 = new Location ("Description of l14");
		Location l15 = new Location ("Description of l15");
		Location l16 = new Location ("Description of l16");
		
		// Create an exit for l1
		l1.addExit (new Exit(Exit.NORTH, l2));
		l1.addExit (new Exit(Exit.EAST, l3));
		l1.addExit (new Exit(Exit.NORTHEAST, l4));
		l1.addExit (new Exit (Exit.WEST, l9));
		// Create an exit for l2
		l2.addExit (new Exit(Exit.SOUTH, l1));

		// Create an exit for l3
		l3.addExit (new Exit(Exit.WEST, l1));
		
		// Create an exit for l4
		l4.addExit (new Exit(Exit.FORWARD, l5));		
		l4.addExit (new Exit(Exit.SOUTHWEST, l1));
		l4.addExit (new Exit(Exit.NORTHWEST, l8));
		// Create an exit for l5
		l5.addExit (new Exit(Exit.PEER, l6));
		l5.addExit (new Exit(Exit.BACK, l4));
		
		// Create an exit for l6
		l6.addExit (new Exit(Exit.REACH, l7));
		l6.addExit (new Exit(Exit.BACK, l4));
		
		// Create an exit for l7
		l7.addExit (new Exit(Exit.BACK, l4));

		//Create an exit for l8
		l8.addExit (new Exit(Exit.REACH, l9));
		l8.addExit (new Exit(Exit.BACK, l4));
			
		//Create an exit for l9 
		l9.addExit (new Exit(Exit.FORWARD, l10));
		l9.addExit (new Exit(Exit.BACK, l6));
		
		//Create an exit for l10
		l10.addExit (new Exit(Exit.NORTH, l11));
		l10.addExit (new Exit(Exit.SOUTH, l12));
		l10.addExit (new Exit(Exit.EAST, l9));
		
		//Create an exit for l11
		l11.addExit (new Exit(Exit.EAST, l13));
		
		//Create an exit for l12
		l12.addExit (new Exit(Exit.EAST, l14));
		
		//Create an exit for l13 
		l13.addExit (new Exit(Exit.WEST, l11));
		l13.addExit (new Exit(Exit.EAST, l2));
		
		//Create an exit for l14
		l14.addExit (new Exit(Exit.WEST, l12));
		l14.addExit (new Exit(Exit.EAST, l5));
		//Create an exit for l15 
		l15.addExit (new Exit(Exit.WEST, l14));
		l15.addExit (new Exit(Exit.NORTH, l16));
		
		//Create an exit for l16
		l16.addExit (new Exit(Exit.SOUTH, l15));
		l16.addExit (new Exit(Exit.WEST, l3));
		
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