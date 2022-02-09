
import java.awt.Font;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;



public class HomePage implements ActionListener{



	JFrame homePage = new JFrame(); // frame for home page

	// panels
	JPanel p1 = new JPanel(); // 1st panel
	JPanel p2 = new JPanel(); // 2nd panel

	// favorite images
	ImageIcon FavCourse; // image showing most played course 
	ImageIcon FavCup; // image showing most played cup
	ImageIcon worstCourse; // image for least played course
	ImageIcon worstCup; // image for least played cup
	ImageIcon luckPic = new ImageIcon(("pics/adam.jpg")); // image of luckiest player



	Scanner scan; // scanner for looking through files

	// buttons for navigating to different pages
	JButton adamButton = new JButton("Adam's Statistics"); // button taking you to a new window showing adam's stat's
	JButton brianButton = new JButton("Brian's Statistics"); // button taking you to a new window showing brian's stat's
	JButton newRecord = new JButton("Add New Race Record"); // button taking you to new window to input a new race record

	// JLabels
	JLabel AmountTimesPlayedCourse = new JLabel();
	JLabel AmountTimesPlayedCup = new JLabel();
	JLabel totalAmountRaces = new JLabel();
	JLabel Total = new JLabel();
	JLabel FavCourseLabel = new JLabel();
	JLabel FavCupLabel = new JLabel();
	JLabel adamText = new JLabel();
	JLabel brianText = new JLabel();
	JLabel leastPlayedCourse = new JLabel();
	JLabel leastPlayedCup = new JLabel();
	JLabel leastc1 = new JLabel(); // label for number of times played least course
	JLabel leastc2 = new JLabel(); // label for number of times played least cup
	JLabel luck = new JLabel();
	JLabel dont = new JLabel("DONT USE ADD RECORD");


	// integers 
	int buffer = 0; // variable for spacing between buttons
	int totalRaces = 0; // total amount of races from all courses





	// all course buttons
	// mushroom cup
	JButton LuigiCircuit = new JButton("Luigi Circuit");
	JButton MooMooMeadows = new JButton("Moo Moo Meadows");
	JButton MushroomGorge = new JButton("Mushroom Gorge");
	JButton ToadsFactory = new JButton("Toad's Factory");

	// flower cup
	JButton MarioCircuit = new JButton("Mario Circuit");
	JButton CoconutMall = new JButton("Coconut Mall");
	JButton DKSummit = new JButton("DK Summit");
	JButton WariosGoldMine = new JButton("Wario's Gold Mine");

	// star cup
	JButton DaisyCircuit = new JButton("Daisy Circuit");
	JButton KoopaCape = new JButton("Koopa Cape");
	JButton MapleTreeway = new JButton("Maple Treeway");
	JButton GrumbleVolcano = new JButton("GrumbleVolcano");

	// special cup
	JButton DryDryRuins = new JButton("Dry Dry Ruins");
	JButton MoonviewHighway = new JButton("Moonview Highway");
	JButton BowsersCastle = new JButton("Bowser's Castle");
	JButton RainbowRoad = new JButton("Rainbow Road");

	// shell cup
	JButton PeachBeach = new JButton("Peach Beach");
	JButton YoshiFalls = new JButton("Yoshi Falls");
	JButton GhostValley2 = new JButton("Ghost Valley 2");
	JButton MarioRaceway = new JButton("Mario Raceway");

	// banana cup
	JButton SherbertLand = new JButton("Sherbert Land");
	JButton ShyGuyBeach = new JButton("Shy Guy Beach");
	JButton DelfinoSquare = new JButton("Delfino Square");
	JButton WaluigiStadium = new JButton("Waluigi Stadium");

	// leaf cup
	JButton DesertHills = new JButton("Desert Hills");
	JButton BowsersCastle3 = new JButton("Bowser's Castle 3");
	JButton DKJungleParkway = new JButton("DK Jungle Parkway");
	JButton GCNMarioCircuit = new JButton("GCN Mario Circuit");

	// lightning cup
	JButton MarioCircuit3 = new JButton("Mario Circuit 3");
	JButton PeachGardens = new JButton("Peach Gardens");
	JButton DKMountain = new JButton("DK Mountain");
	JButton N64BowsersCastle = new JButton("N64 Bowser's Castle");

	// list of all course buttons 
	JButton courses[] = {LuigiCircuit,MooMooMeadows,MushroomGorge,ToadsFactory,MarioCircuit,
			CoconutMall,DKSummit,WariosGoldMine,DaisyCircuit,KoopaCape,MapleTreeway,GrumbleVolcano,
			DryDryRuins,MoonviewHighway,BowsersCastle,RainbowRoad,PeachBeach,YoshiFalls,GhostValley2,
			MarioRaceway,SherbertLand,ShyGuyBeach,DelfinoSquare,WaluigiStadium,DesertHills,BowsersCastle3,
			DKJungleParkway,GCNMarioCircuit,MarioCircuit3,PeachGardens,DKMountain,N64BowsersCastle};

	// course pictures
	ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("LuigiCircuit.jpg"));
	ImageIcon i2 = new ImageIcon(getClass().getClassLoader().getResource("MooMooMeadows.jpg"));
	ImageIcon i3 = new ImageIcon(getClass().getClassLoader().getResource("MushroomGorge.png"));
	ImageIcon i4 = new ImageIcon(getClass().getClassLoader().getResource("ToadFactory.jpg"));
	ImageIcon i5 = new ImageIcon(getClass().getClassLoader().getResource("MarioCircuit.jpg"));
	ImageIcon i6 = new ImageIcon(getClass().getClassLoader().getResource("CoconutMall.jpg"));
	ImageIcon i7 = new ImageIcon(getClass().getClassLoader().getResource("DKSummit.jpg"));
	ImageIcon i8 = new ImageIcon(getClass().getClassLoader().getResource("WarioGoldMine.png"));
	ImageIcon i9 = new ImageIcon(getClass().getClassLoader().getResource("DaisyCircuit.jpg"));
	ImageIcon i10 = new ImageIcon(getClass().getClassLoader().getResource("KoopaCape.png"));
	ImageIcon i11 = new ImageIcon(getClass().getClassLoader().getResource("MapleTreeway.png"));
	ImageIcon i12 = new ImageIcon(getClass().getClassLoader().getResource("GrumbleVolcano.jpg"));
	ImageIcon i13 = new ImageIcon(getClass().getClassLoader().getResource("DryDryRuins.jpg"));
	ImageIcon i14 = new ImageIcon(getClass().getClassLoader().getResource("MoonviewHighway.png"));
	ImageIcon i15 = new ImageIcon(getClass().getClassLoader().getResource("BowserCastle.jpg"));
	ImageIcon i16 = new ImageIcon(getClass().getClassLoader().getResource("RainbowRoad.jpg"));
	ImageIcon i17 = new ImageIcon(getClass().getClassLoader().getResource("PeachBeach.png"));
	ImageIcon i18 = new ImageIcon(getClass().getClassLoader().getResource("YoshiFalls.jpg"));
	ImageIcon i19 = new ImageIcon(getClass().getClassLoader().getResource("GhostValley2.png"));
	ImageIcon i20 = new ImageIcon(getClass().getClassLoader().getResource("MarioRaceway.jpg"));
	ImageIcon i21 = new ImageIcon(getClass().getClassLoader().getResource("SherbertLand.jpg"));
	ImageIcon i22 = new ImageIcon(getClass().getClassLoader().getResource("ShyGuyBeach.png"));
	ImageIcon i23 = new ImageIcon(getClass().getClassLoader().getResource("DelfinoSquare.jpg"));
	ImageIcon i24 = new ImageIcon(getClass().getClassLoader().getResource("WaluigiStadium.jpg"));
	ImageIcon i25 = new ImageIcon(getClass().getClassLoader().getResource("DesertHills.png"));
	ImageIcon i26 = new ImageIcon(getClass().getClassLoader().getResource("BowserCastle3.jpg"));
	ImageIcon i27 = new ImageIcon(getClass().getClassLoader().getResource("DKJungleParkway.jpg"));
	ImageIcon i28 = new ImageIcon(getClass().getClassLoader().getResource("GCNMarioCircuit.jpg"));
	ImageIcon i29 = new ImageIcon(getClass().getClassLoader().getResource("MarioCircuit3.jpg"));
	ImageIcon i30 = new ImageIcon(getClass().getClassLoader().getResource("PeachGardens.jpg"));
	ImageIcon i31 = new ImageIcon(getClass().getClassLoader().getResource("DKMountain.jpg"));
	ImageIcon i32 = new ImageIcon(getClass().getClassLoader().getResource("N64BowserCastle.jpg"));

	// list of images for course
	ImageIcon courseImages[] = {i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,i20,i21,i22,i23,i24,i25,i26,i27,i28,i29,i30,i31,i32};

	// cup images
	ImageIcon i33 = new ImageIcon(getClass().getClassLoader().getResource("MushroomCup.jpg"));
	ImageIcon i34 = new ImageIcon(getClass().getClassLoader().getResource("FlowerCup.jpg"));
	ImageIcon i35 = new ImageIcon(getClass().getClassLoader().getResource("StarCup.jpg"));
	ImageIcon i36 = new ImageIcon(getClass().getClassLoader().getResource("SpecialCup.jpg"));
	ImageIcon i37 = new ImageIcon(getClass().getClassLoader().getResource("ShellCup.png"));
	ImageIcon i38 = new ImageIcon(getClass().getClassLoader().getResource("BananaCup.jpg"));
	ImageIcon i39 = new ImageIcon(getClass().getClassLoader().getResource("LeafCup.png"));
	ImageIcon i40 = new ImageIcon(getClass().getClassLoader().getResource("LightningCup.jpg"));

	// list of all the cup images
	ImageIcon cupImages[] = {i33,i34,i35,i36,i37,i38,i39,i40};


	HomePage(){

		//dont.setFont(new Font(null,Font.PLAIN,25));
		
		addButtons(); // adding buttons to navigate to different pages
		playedCourse(); // displayes most played course and least played course to panels
		playedCup(); // displays most played cup and least played cup to panels
		totalRaces(); // adds totasl number of races to panel 1
		totalLuck(); // total luck function
		background();

		p1.setBounds(350, 25, 250, 950); // setting up where first panel is on frame
		p2.setBounds(850, 25, 250, 950); // setting up 2nd panel on frame
		//dont.setBounds(25, 0, 400, 50);

		// adding panel to frame
		homePage.add(p1);
		homePage.add(p2);
		//homePage.add(dont);

		// frame properties
		homePage.setTitle("Mario Kart Statistics"); // frame title
		homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program stops when frame is closed
		homePage.setResizable(true); // Allows window to be resized by user
		homePage.setSize(1920,1080);
		homePage.setLayout(null);
		homePage.setVisible(true);


	}

	private void background() {
		//ImageIcon background = new ImageIcon(getClass().getClassLoader().getResource("background.png"));
		JLayeredPane b = new JLayeredPane();
		JLabel b1 = new JLabel();
		b.setBounds(0, 0, 1920, 1080);
		b.add(b1,JLayeredPane.DEFAULT_LAYER);
		//b1.setIcon(background);
		b1.setBounds(0, 0, 1920, 1080);
		homePage.add(b);
		
	}

	private void addButtons() {
		// loop to add action listener and place on home page for all course buttons
		for(int i = 0; i < 32;i++) {

			// course button properties
			courses[i].addActionListener(this);
			courses[i].setFocusable(false);
			courses[i].setBounds(25,75+buffer,200,20);

			homePage.add(courses[i]);
			buffer = buffer + 30;

			}

		// adding new record button to update course statistics
		newRecord.setBounds(25, 45, 200, 20);
		newRecord.setFocusable(false);
		newRecord.addActionListener(this);
		homePage.add(newRecord);

		// setting personal statistics properties up
		adamButton.setBounds(345, 775, 250, 50);
		adamButton.setFocusable(false);
		adamButton.addActionListener(this);

		brianButton.setBounds(345, 925, 250, 50);
		brianButton.setFocusable(false);
		brianButton.addActionListener(this);


		// label properties
		adamText.setText("Adam Personal Stats:");
		adamText.setBounds(350, 725, 250, 50);
		adamText.setFont(new Font(null,Font.PLAIN,25));

		brianText.setText("Brian Personal Stats:");
		brianText.setBounds(350, 875, 250, 50);
		brianText.setFont(new Font(null,Font.PLAIN,25));

		// adding personal statistics buttons to home page
		homePage.add(adamButton);
		homePage.add(brianButton);
		homePage.add(adamText);
		homePage.add(brianText);

	}

	private int totalLuck() {
		String luck1 = "";String luck2 = ""; int total = 0; int total2 = 0; int count = 0;

		JLabel lucktext = new JLabel(); JLabel luck = new JLabel(); JLabel playerluck = new JLabel(); JLabel player = new JLabel();

		// try except for file handling
		try {

			// scanner for looking through the file
			scan = new Scanner(new InputStreamReader(getClass().getResourceAsStream("courseStats")));
			scan.useDelimiter("[,\n]");

			// loop to look through entire file
			while (scan.hasNext()) {

				// scanning thrice to get to the luck value of each track
				scan.next();
				scan.next();
				
				luck1 = scan.next(); // adam luck for course
				luck2 = scan.next(); // brian luck for course

				scan.next();
				scan.next();
				scan.next();

				total += Integer.parseInt(luck1);
				total2 += Integer.parseInt(luck2);

				count += 1;
				if (count == 32) {
					break;
				}
			}
			scan.close();

			lucktext.setFont(new Font(null,Font.PLAIN,25));
			lucktext.setText("Luck For All Courses:");

			luck.setFont(new Font(null,Font.PLAIN,35));
			luck.setText("Total luck: " + (total+total2));

			playerluck.setFont(new Font(null,Font.PLAIN,25));
			playerluck.setText("Player With Most Luck");

			if (total > total2) {
				luckPic = new ImageIcon(("pics/adam.jpg"));
			} else {
				luckPic = new ImageIcon(("pics/brian.jpg"));

			}

			player.setIcon(luckPic);

			p2.add(lucktext);
			p2.add(luck);
			p2.add(playerluck);
			p2.add(player);

		}
		catch(Exception e) {
			System.out.println("ERROR2");
		}

		return total;
	}

	private int totalRaces() {
		String timesPlayed = ""; int total = 0;int count = 0;

		// try except for file handling
		try {

			// scanner for looking through the file
			scan = new Scanner(new InputStreamReader(getClass().getResourceAsStream("courseStats")));
			scan.useDelimiter("[,\n]");

			// loop to look through entire file
			while (scan.hasNext()) {

				// scanning twice to get to the race value of each track
				scan.next();
				timesPlayed = scan.next();

				// skipping over all other useless info for track
				for (int i = 0; i < 5; i++) {
					scan.next();
				}

				total += Integer.parseInt(timesPlayed);
				count += 1;
				if (count == 32) {
					break;
				}
			}
			scan.close();

			// setting up total label and totalAmountRaces text
			Total.setFont(new Font(null,Font.PLAIN,50));
			Total.setText("#: "+total);
			totalAmountRaces.setFont(new Font(null,Font.PLAIN,25));
			totalAmountRaces.setText("Total Races Played:");
			p1.add(totalAmountRaces);
			p1.add(Total);
		}
		catch(Exception e) {
			System.out.println("ERROR");
		}

		return total;
	}


	private int playedCup() {

		// variables for keeping track of the file and amount of times played a cup
		String timesPlayed = "";String cup = "";String cup2 = "";int amount = 0; int count = 0; int lowest = 999999999;

		// list with all cup names
		String cups[] = {"Mushroom Cup","Flower Cup","Star Cup","Special Cup","Shell Cup","Banana Cup","Leaf Cup","Lightning Cup"};

		// all cup integers for keeping track of the number of races played in a certain cup
		int mushroomCup = 0;int flowerCup = 0;int starCup = 0;int specialCup = 0;int shellCup = 0;int bananaCup = 0;int leafCup = 0;int lightningCup = 0;

		JLabel cupName = new JLabel();JLabel mpctext = new JLabel(); JLabel lpctext = new JLabel(); JLabel cupName2 = new JLabel();

		// try and catch for file handling 
		try {
			// scanner for looking through the file
			scan = new Scanner(new InputStreamReader(getClass().getResourceAsStream("courseStats")));
			scan.useDelimiter("[,\n]");

			// loop for looking through entire file
			while (scan.hasNext()) {

				// scanning through to get to number of times played a track
				scan.next();
				timesPlayed = scan.next(); // assigning timesPlayed to the number in the file which represent how many time a course has been played

				// looping to get rid of all useless information from file
				for (int i = 0; i < 5; i++) {
					scan.next();
				}

				count += 1; // adding 1 to count to know which track the scanner is looking at


				// switch for assigning the times played to the cup int variables
				// number represents which number track it is in mario kart wii
				switch(count) {
				case 1:
					mushroomCup += Integer.parseInt(timesPlayed);
					break;
				case 2:
					mushroomCup += Integer.parseInt(timesPlayed);
					break;
				case 3:
					mushroomCup += Integer.parseInt(timesPlayed);
					break;
				case 4:
					mushroomCup += Integer.parseInt(timesPlayed);
					break;
				case 5:
					flowerCup += Integer.parseInt(timesPlayed);
					break;
				case 6:
					flowerCup += Integer.parseInt(timesPlayed);
					break;
				case 7:
					flowerCup += Integer.parseInt(timesPlayed);
					break;
				case 8:
					flowerCup += Integer.parseInt(timesPlayed);
					break;
				case 9:
					starCup += Integer.parseInt(timesPlayed);
					break;
				case 10:
					starCup += Integer.parseInt(timesPlayed);
					break;
				case 11:
					starCup += Integer.parseInt(timesPlayed);
					break;
				case 12:
					starCup += Integer.parseInt(timesPlayed);
					break;
				case 13:
					specialCup += Integer.parseInt(timesPlayed);
					break;
				case 14:
					specialCup += Integer.parseInt(timesPlayed);
					break;
				case 15:
					specialCup += Integer.parseInt(timesPlayed);
					break;
				case 16:
					specialCup += Integer.parseInt(timesPlayed);
					break;
				case 17:
					shellCup += Integer.parseInt(timesPlayed);
					break;
				case 18:
					shellCup += Integer.parseInt(timesPlayed);
					break;
				case 19:
					shellCup += Integer.parseInt(timesPlayed);
					break;
				case 20:
					shellCup += Integer.parseInt(timesPlayed);
					break;
				case 21:
					bananaCup += Integer.parseInt(timesPlayed);
					break;
				case 22:
					bananaCup += Integer.parseInt(timesPlayed);
					break;
				case 23:
					bananaCup += Integer.parseInt(timesPlayed);
					break;
				case 24:
					bananaCup += Integer.parseInt(timesPlayed);
					break;
				case 25:
					leafCup += Integer.parseInt(timesPlayed);
					break;
				case 26:
					leafCup += Integer.parseInt(timesPlayed);
					break;
				case 27:
					leafCup += Integer.parseInt(timesPlayed);
					break;
				case 28:
					leafCup += Integer.parseInt(timesPlayed);
					break;
				case 29:
					lightningCup += Integer.parseInt(timesPlayed);
					break;
				case 30:
					lightningCup += Integer.parseInt(timesPlayed);
					break;
				case 31:
					lightningCup += Integer.parseInt(timesPlayed);
					break;
				case 32:
					lightningCup += Integer.parseInt(timesPlayed);
					break;
				}



				if (count == 32) {
					break;
				}
			}
		}
		catch(Exception e){
			System.out.println("ERROR1");
		}

		// integer list variable filled with cup variables to be able to compare the values
		int most[] = {mushroomCup,flowerCup,starCup,specialCup,shellCup,bananaCup,leafCup,lightningCup};

		for (int i = 0; i < 8; i++) {
			// checks if amount is less than current cup and then assign amount to the amount of that cup
			
			if (amount < most[i]) {
				amount = most[i];
				cup = cups[i];
				FavCup = cupImages[i];
			}

			// checking for lowest played cup
			if (lowest > most[i]) {
				lowest = most[i];
				cup2 = cups[i];
				worstCup = cupImages[i];
			}
		}



		// setting up panel and label variables
		cupName.setFont(new Font(null,Font.PLAIN,25));
		cupName.setText(cup);
		mpctext.setFont(new Font(null,Font.PLAIN,25));
		mpctext.setText("Most Played Cup:");

		cupName2.setFont(new Font(null,Font.PLAIN,25));
		cupName2.setText(cup2);
		lpctext.setFont(new Font(null,Font.PLAIN,25));
		lpctext.setText("Least Played Cup:");

		// adding to panels
		p1.add(mpctext);
		p1.add(cupName);
		p2.add(lpctext);
		p2.add(cupName2);

		p1.add(FavCupLabel);
		p1.add(AmountTimesPlayedCup);

		AmountTimesPlayedCup.setText("Amount Of Times Played " + amount); // setting text for label for most played cup
		FavCupLabel.setIcon(FavCup); // setting image for most played cup

		// adding least played cup image to panel
		leastPlayedCup.setIcon(worstCup);
		p2.add(leastPlayedCup);

		leastc2.setText("Amount Of Times Played " + lowest);
		p2.add(leastc2);

		scan.close();

		return amount;
	}

	private int playedCourse(){

		// variables for determining most played course
		String course = ""; String timesPlayed = ""; int amount = 0; int count = 0; int courseNum = 0; int lowest = 999999999;int courseNum2 = 0;

		// labels for text in p1
		JLabel mpctext = new JLabel();JLabel courseName = new JLabel(); JLabel lpctext = new JLabel(); JLabel courseName2 = new JLabel();

		// file handling try catch
		try {

			// scanning through t.txt
			scan = new Scanner(new InputStreamReader(getClass().getResourceAsStream("courseStats")));
			scan.useDelimiter("[,\n]");
			

			// looping while scan has a next item to look at
			while (scan.hasNext()) {
				
				// keeping track of course and how many times its been played
				course = scan.next();
				timesPlayed = scan.next();

				// looping through rest of useless info
				for (int i = 0; i < 5; i++) {
					scan.next();
				}

				// count helps determine correct picture for most played track
				count += 1;

				if (count == 33) {
					break;
				}

				//  checking to see which course has the most times played
				if (amount < Integer.parseInt(timesPlayed)) {
					amount = Integer.parseInt(timesPlayed); // Assigning new number to amount to check if it is the highest number
					courseNum = count; // setting course num to count to know which course is played the most 

					AmountTimesPlayedCourse.setText("Amount Of Times Played " + amount); // label for number of times played the most played course

					FavCourse = courseImages[courseNum-1]; // setting FavCourse to course of image that is played the most

					// setting up courseName label and mpctext label properties
					courseName.setFont(new Font(null,Font.PLAIN,25));
					courseName.setText(course);
					mpctext.setFont(new Font(null,Font.PLAIN,25));
					mpctext.setText("Most Played Course:");

					FavCourseLabel.setIcon(FavCourse); // assigning course with the most times played to this

					// adding both labels to panel 1
					p1.add(mpctext);
					p1.add(courseName);

					// adding most played course labels to frame
					p1.add(FavCourseLabel);
					p1.add(AmountTimesPlayedCourse);
				}

				// checking for least played course
				if (lowest > Integer.parseInt(timesPlayed)) {

					lowest = Integer.parseInt(timesPlayed); // assigning highest to new lowest number
					courseNum2 = count; // setting course number 2 to count to determine what picture is needed

					worstCourse = courseImages[courseNum2 - 1];

					// setting up course name and lpc label properties
					courseName2.setFont(new Font(null,Font.PLAIN,25));
					courseName2.setText(course);
					lpctext.setFont(new Font(null,Font.PLAIN,25));
					lpctext.setText("Least Played Course:");

					// adding labels to panel
					p2.add(lpctext);
					p2.add(courseName2);

					// adding least played course image to panel 2
					leastPlayedCourse.setIcon(worstCourse);
					p2.add(leastPlayedCourse);

					// adding amount of times played least course to panel 2
					leastc1.setText("Amount Of Times Played " + lowest);
					p2.add(leastc1);



				}
			}
		}
		catch(Exception e){
			System.out.println("ERROR_PLAYED_COURSE");
		}
		scan.close();
		return amount;
	}


	@Override
	// function for opening adam stat page and closing homepage 
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 32; i++) {
			if (e.getSource() == courses[i]) {
				homePage.dispose();
				new courseStats(i); 
			}
		}

		// function for adding new race record
		if (e.getSource() == newRecord) {
			new AddRecord();
			homePage.dispose();
		}

		// adam personal stats page
		if (e.getSource() == adamButton) {
			new personalStats(true);
			homePage.dispose();
		}

		// brian personal stats page
		if (e.getSource() == brianButton) {
			new personalStats(false);
			homePage.dispose();
		}

	}







}
