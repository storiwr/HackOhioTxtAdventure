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
		displayOutput = new TextArea( 15, 50); // 15 rows x 45 chars
		buttonInput   = new Button("Go");
		Panel inputPanel = new Panel();

		// Add components to our layout / panels
		inputPanel.add(commandInput);
		inputPanel.add(buttonInput);
		appletPanel.add("North", displayOutput);
		appletPanel.add("South", inputPanel);

		// Create two locations
		Location l1 = new Location ("Welcome!", "Before there were MMORPGs and FPS with HD graphics, dolby surround, and \npartical physics, people were more limited in their entertainment choices. " +
									"\nGamers, (if they could really be called that) were forced to use their \nimagination, and, like the dead-tree books of old, focus on tiny text and crude \n" +
									"keyboard input to immerse themeselves in some sort of cyber entertainment. \n\nBecause Chester and I are gluttons for punishment, let's return to this time \n" +
									"with our state-of-the-art, Java-based digital miracle.     --Enjoy!");
		Location l2 = new Location ("Entrance to hall", "You stand at the entrance of a long hallway. The hallway gets darker\nand darker, and you cannot see what lies beyond. To the east\nis an old oaken door, unlocked and beckonning.");
		Location l3 = new Location ("End of hall", "You have reached the end of a long dark hallway. \nYou can see nothing up ahead. \nTo the west are a pair of french double doors. \nPale light filters through the dust covered panes.");
		Location l4 = new Location ("Small study", "This is a small and cluttered study, containing a desk covered with\npapers. Though they no doubt are of some importance,\nyou cannot read their writing.");
		Location l5 = new Location ("Large Courtyard", "You find yourself outside, a full moon overhead. In the center \nis a large fountain ovegrown with vines and moss. \nThe other side is dark.");
		Location l6 = new Location ("The Fountain","As you approach the fountain, you hear a deep rumbling sound \nfar below. You hear a sudden gurgling sound. Water gushes up from the \nold fountain.");
		Location l7 = new Location ("The Fountain", "Cautiously, you peer over the edge into the gently rippling water. \nIt is remarkably clear. Odd, considering how old it appears. \nYou see something at the bottom of the fountain.");
		Location l8 = new Location ("The Fountain", "You reach your hand into the cool water in an effort to retrieve the object. \nSuddenly a powerful burning sensation rips through your arm. \nYou yank your hand out and return to middle of the courtyard.");
		Location l9 = new Location ("Large Courtyard", "The far side is pitch black. Despite the full moon, no light \nseems to penetrate these shadows. You reach out \nblindly and feel something cold under your hand.");
		Location l10 = new Location ("Large Courtyard", "A heavy door swings open. Stumbling, you find yourself in a \ncavernous room. Moonlight from a row of tall windows on the far wall is \nyour only source of light. Ahead you hear a crash.");
		Location l11 = new Location ("Giant Room", "Curious, you head toward the noise. Perhaps you aren't alone here after all. \nSomething darts across the floor, disturbing the dust in its wake. You chase after it, oblivious to your surroundings.\n As suddenly as it appeared the creature vanishes. Looking around, \nyou realize you somehow made it back to the study.");
		Location l12 = new Location ("Total Darkness", "Undeturred by the total and oppressive darkness, \nyou press forward anyway. You continue walking \nonward and onward. You can no longer hear your footsteps. \nYou can't even be sure you are moving forward.");
		Location l13 = new Location ("Total Darkness", "Just when you believe all hope is lost, wondering if you will ever see \nlight again, a gust of wind blows up from under you. With a painful \nthud you realize you were falling. Gingerly getting back on your feet, \nyou notice a dim light coming through what must be a crack \nunder a door.");
		Location l14 = new Location ("Through the Door","Thrusting the door wide open, you find yourself blinking madly, \noverwhelmed by the intense brightness of the midday sun. \nYou look back at the old mansion, wondering what the hell happened. \nYou are so relieved, your first instinct is to hurry home and \nforget the whole thing. But then you will never know the secret behind \nthe ancient house. You stand, hesitant, between the two options.");
		Location l15 = new Location ("Home Bound","Relieved to finally be out and worried what your mother must be thinking, \nyou hurry home! After all, some mysteries are better left unsolved.");
		Location l16 = new Location ("Return Inside","With grave determination you turn back to the old mannor. \nYou are going to discover its secrets if it's the last thing you do. \nPerhaps it was, for you were never seen again.");
		Location l17 = new Location ("Directions", "Type the name of the option you wish to choose while \ngoing about your journey. \nAlternatively you can use the option's initials.");
		
		//Create and exit for l1
		l1.addExit (new Exit(Exit.DIRECTIONS, l17));
		l1.addExit (new Exit(Exit.START, l2));
		
		// Create an exit for l2
		l2.addExit (new Exit(Exit.NORTH, l3));
		l2.addExit (new Exit(Exit.EAST, l4));
		
		
		// Create an exit for l2
		l3.addExit (new Exit(Exit.SOUTH, l2));
		l3.addExit (new Exit(Exit.NORTH, l12));
		l3.addExit (new Exit(Exit.WEST, l5));

		// Create an exit for l4
		l4.addExit (new Exit(Exit.WEST, l2));
		
		// Create an exit for l5
		l5.addExit (new Exit(Exit.FORWARD, l6));		
		l5.addExit (new Exit(Exit.WEST, l9));
		l5.addExit (new Exit(Exit.EAST, l2));
		
		// Create an exit for l6
		l6.addExit (new Exit(Exit.PEER, l7));
		l6.addExit (new Exit(Exit.BACK, l5));
		
		// Create an exit for l7
		l7.addExit (new Exit(Exit.REACH, l8));
		l7.addExit (new Exit(Exit.BACK, l5));
		
		// Create an exit for l8
		l8.addExit (new Exit(Exit.BACK, l5));

		//Create an exit for l9
		l9.addExit (new Exit(Exit.REACH, l10));
		l9.addExit (new Exit(Exit.BACK, l5));
			
		//Create an exit for l10 
		l10.addExit (new Exit(Exit.FORWARD, l11));
		l10.addExit (new Exit(Exit.BACK, l9));
		
		//Create an exit for l11
		l11.addExit (new Exit(Exit.WEST, l2));
		
		//Create an exit for l12
		l12.addExit (new Exit(Exit.FORWARD, l13));
		
		//Create an exit for l13
		l13.addExit (new Exit(Exit.FORWARD, l14));
		
		//Create an exit for l14 
		l14.addExit (new Exit(Exit.HOME, l15));
		l14.addExit (new Exit(Exit.BACK, l16));
		
		//Create an exit for l15
		l15.addExit (new Exit(Exit.START, l2));
	
		//Create an exit for l16 
		l16.addExit (new Exit(Exit.START, l2));
		
		
		//Create an exit for l17
		l17.addExit (new Exit(Exit.START, l2));
		
		
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