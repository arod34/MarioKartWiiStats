import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class kartpersonalstats implements ActionListener{
	
	private static Scanner x;
	
	JFrame personal = new JFrame();
	JButton backButton = new JButton("Back");
	
	JPanel p1 = new JPanel(); // panel for all places
	JPanel p2 = new JPanel(); // panel for all place amounts finished in
	JPanel p3 = new JPanel(); // panel for best and worst course
	JPanel p4 = new JPanel(); // panel for best and worst cup
	JPanel p5 = new JPanel(); // panel for luckiest and unluckiest course
	
	// labels for pictures
	JLabel bestc = new JLabel();
	JLabel bestcp = new JLabel();
	JLabel worstc = new JLabel();
	JLabel worstcp = new JLabel();
	JLabel favChar = new JLabel();
	
	// labels for first and last name
	JLabel name = new JLabel();
	JLabel name2 = new JLabel();
	JLabel player = new JLabel();
	JLabel playerName = new JLabel();
	JLabel charName = new JLabel();
	JLabel info = new JLabel();
	
	JTextArea playerInfo = new JTextArea();
	
	Timer timer = new Timer(); // timer for changing color of name
	int colorNum = 0; // number for choosing color
	
	
	// place labels
	JLabel placesAmount  = new JLabel("Times Placed In:");
	JLabel one = new JLabel("1st:");
	JLabel two = new JLabel("2nd:");
	JLabel three = new JLabel("3rd:");
	JLabel four = new JLabel("4th:");
	JLabel five = new JLabel("5th:");
	JLabel six = new JLabel("6th:");
	JLabel seven = new JLabel("7th:");
	JLabel eight = new JLabel("8th:");
	JLabel nine = new JLabel("9th:");
	JLabel ten = new JLabel("10th:");
	JLabel eleven = new JLabel("11th:");
	JLabel twelve = new JLabel("12th:");
	
	// place amount labels
	JLabel one2 = new JLabel();
	JLabel two2 = new JLabel();
	JLabel three2 = new JLabel();
	JLabel four2 = new JLabel();
	JLabel five2 = new JLabel();
	JLabel six2 = new JLabel();
	JLabel seven2 = new JLabel();
	JLabel eight2 = new JLabel();
	JLabel nine2 = new JLabel();
	JLabel ten2 = new JLabel();
	JLabel eleven2 = new JLabel();
	JLabel twelve2 = new JLabel();
	
	JLabel places[] = {one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve};
	JLabel places2[] = {one2,two2,three2,four2,five2,six2,seven2,eight2,nine2,ten2,eleven2,twelve2};
	int placeNums[];
	
	// all course names
	String courses[] = {"LuigiCircuit","MooMooMeadows","MushroomGorge","ToadsFactory","MarioCircuit",
			"CoconutMall","DKSummit","WariosGoldMine","DaisyCircuit","KoopaCape","MapleTreeway","GrumbleVolcano",
			"DryDryRuins","MoonviewHighway","BowsersCastle","RainbowRoad","PeachBeach","YoshiFalls","GhostValley2",
			"MarioRaceway","SherbertLand","ShyGuyBeach","DelfinoSquare","WaluigiStadium","DesertHills","BowsersCastle3",
			"DKJungleParkway","GCNMarioCircuit","MarioCircuit3","PeachGardens","DKMountain","N64BowsersCastle"};
	
	// favorite character pictures
	ImageIcon bowser =  new ImageIcon(getClass().getClassLoader().getResource("bowsermkwii.jpg")); // adams favorite character
	ImageIcon bowserJR =  new ImageIcon(getClass().getClassLoader().getResource("bowserjrmkwii.jpg")); // brians favorite character
	ImageIcon adamPic =  new ImageIcon(getClass().getClassLoader().getResource("adam.jpg"));
	ImageIcon brianPic =  new ImageIcon(getClass().getClassLoader().getResource("brian.jpg"));
	
	
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
	
	
	kartpersonalstats(boolean adam){
		
		
		
		// checks which persons button was selected and pulls up according stats
		if (adam == true) {
			// adams personal stats
			placeNums = getPlaces(true);
			for (int i = 0; i < 12; i++) {
				places2[i].setText(Integer.toString(placeNums[i]));
				places2[i].setFont(new Font(null,Font.PLAIN,50));
				p2.add(places2[i]);
			}
			worstAndBest(true);
			totals(true);
			nameChoose(true);
			favChar.setIcon(bowser);
			player.setIcon(adamPic);
	
			charName.setText("BOWSER");
			charName.setFont(new Font(null,Font.PLAIN,50));
			playerInfo.setText("Adam is a brilliant racer with a excellent mario kart wii IQ and vows to take down the cheating winner of season 1 Brian Beffa.");

		} 
		
		else {
			// brians personal stats
			placeNums = getPlaces(false);
			for (int i = 0; i < 12; i++) {
				places2[i].setText(Integer.toString(placeNums[i]));
				places2[i].setFont(new Font(null,Font.PLAIN,50));
				p2.add(places2[i]);
			}
			
			worstAndBest(false);
			totals(false);
			nameChoose(false);
			favChar.setIcon(bowserJR);
			player.setIcon(brianPic);
			charName.setText("BOWSER JR");
			charName.setFont(new Font(null,Font.PLAIN,50));
			playerInfo.setText("Brian is a dirty cheater but tries to say that he plays by the rules but everyone knows his true nature.");
			
		}
		
		// loop for adding place labels to p1
		for (int i = 0; i < 12; i++) {
			places[i].setFont(new Font(null,Font.PLAIN,50));
			p1.add(places[i]);
		}
		
		// player info properties 
		playerInfo.setLineWrap(true);
		playerInfo.setWrapStyleWord(true);
		playerInfo.setFont(new Font(null,Font.PLAIN,25));
		playerInfo.setBounds(1450, 300, 300, 200);
		playerInfo.setBackground(Color.lightGray);
		playerInfo.setEditable(false);
		personal.add(playerInfo);
		
		placesAmount.setFont(new Font(null,Font.PLAIN,25));
		placesAmount.setBounds(10, 10, 200, 100);
		personal.add(placesAmount);
		
		// setting player picture up
		player.setBounds(1480, 50, 500, 200);
		personal.add(player);
		
		// setting up player name and their favorite character name
		charName.setBounds(1475, 300, 500, 500);
		personal.add(charName);
		
		// panels
		p1.setBounds(25, 100, 100, 850);
		p2.setBounds(125,100,60,850);
		p3.setBounds(250, 100, 350, 900);
		p4.setBounds(650, 100, 350, 900);
		p5.setBounds(1050, 100, 350, 900);;

		personal.add(p1); // adding panel 1 to frame
		personal.add(p2); // adding panel 2 to frame
		personal.add(p3); // adding panel 3 to frame
		personal.add(p4); // adding panel 4 to frame
		personal.add(p5); // adding panel 5 to frame
		
		// setting up favorite character picture properties
		favChar.setBounds(1450, 550, 500, 480);
		personal.add(favChar); // adding players favorite character to page
		
		back(); // function holding properties for back button to get back to home page
		
		// property's of brian's mario kart stats
		personal.setTitle("Mario Kart Statistics"); // frame title
		personal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program stops when frame is closed
		personal.setResizable(true); // Allows window to be resized by user
		personal.setSize(1920,1080); // sets default size of the frame to width: 690 height : 420
		personal.setLayout(null);
		personal.setVisible(true);
		personal.add(p1); // adding panel 1 to frame
		
		TimerTask task = new TimerTask() {
			public void run() {
				changeColor();
				
			}
		};

		timer.scheduleAtFixedRate(task, 500, 500);
		
		
	}
	

	
	private void changeColor() {
		switch (colorNum) {
		case 1:
			name.setForeground(Color.BLUE);
			name2.setForeground(Color.PINK);
			break;
		case 2:
			name.setForeground(Color.RED);
			name2.setForeground(Color.MAGENTA);
			break;
		case 3:
			name.setForeground(Color.YELLOW);
			name2.setForeground(Color.ORANGE);
			break;
		case 4:
			name.setForeground(Color.GREEN);
			name2.setForeground(Color.CYAN);
			break;
		case 5:
			name.setForeground(Color.CYAN);
			name2.setForeground(Color.BLUE);
			break;
		case 6:
			name.setForeground(Color.ORANGE);
			name2.setForeground(Color.RED);
			break;
		case 7:
			name.setForeground(Color.MAGENTA);
			name2.setForeground(Color.YELLOW);
			break;
		case 8:
			name.setForeground(Color.PINK);
			name2.setForeground(Color.GREEN);
			break;
			
		}
		if (colorNum == 8) {
			colorNum = 0;
		}
		colorNum += 1;
		
		
	}

	private void totals(boolean b) {
		
		// variables to hold file info
		String courseName = "";String timePlayedCourse = "";String aLuck = ""; String bLuck = ""; String aPoints = "";String course = "";
		JLabel totalpnt = new JLabel(); JLabel totallck = new JLabel();JLabel avgpnt = new JLabel();JLabel avgluck = new JLabel();JLabel tpnt = new JLabel();JLabel tlck = new JLabel();
		JLabel apnt = new JLabel(); JLabel alck = new JLabel();JLabel set = new JLabel(); JLabel set2 = new JLabel();int n = 0; int n2 = 0; int n3 = 0;
		// checking if adam or brian page is opened
		if (b == true) {
			course = "adam";
		} else {
			course = "brian";
		}
		
		try {
			
			x = new Scanner(new InputStreamReader(getClass().getResourceAsStream("kartcoursestats")));
			x.useDelimiter("[,\n]");
			
			while (x.hasNext()) {
				courseName = x.next();
				timePlayedCourse = x.next();
				aLuck = x.next();
				bLuck = x.next();
				aPoints = x.next();
				x.next();
				x.next();
				n = Integer.parseInt(bLuck);
				n2 = Integer.parseInt(timePlayedCourse);
				n3 = Integer.parseInt(aLuck);
				// setting up labels for all totals for personal page
				if (courseName.equals(course)) {
					
					// total points label
					totalpnt.setText("Total Points For All Races:");
					totalpnt.setFont(new Font(null,Font.PLAIN,25));
					tpnt.setText(bLuck);
					tpnt.setFont(new Font(null,Font.PLAIN,50));
					
					// average point labels
					avgpnt.setText("Average Points For All Races:");
					avgpnt.setFont(new Font(null,Font.PLAIN,25));
					n = Integer.parseInt(bLuck);
					apnt.setText(""+(n/n2));
					n = Integer.parseInt(aPoints);
					apnt.setFont(new Font(null,Font.PLAIN,50));
					
					// average luck labels
					avgluck.setText("Average Luck For All Races:");
					avgluck.setFont(new Font(null,Font.PLAIN,25));
					alck.setText(""+(n/n2));
					alck.setFont(new Font(null,Font.PLAIN,50));
					
					// total luck labels
					tlck.setText(aPoints);
					tlck.setFont(new Font(null,Font.PLAIN,50));
					totallck.setText("Total Luck For All Races:");
					totallck.setFont(new Font(null,Font.PLAIN,25));
					
					// total sets won
					set.setText(Integer.toString(n3-1));
					set.setFont(new Font(null,Font.PLAIN,50));
					set2.setText("Amount Of Sets Won Overall:");
					set2.setFont(new Font(null,Font.PLAIN,25));
				}
			}
			x.close();
			
			// adding to panel 3
			p3.add(totalpnt);
			p3.add(tpnt);
			p3.add(avgpnt);
			p3.add(apnt);
			
			// adding to panel 4
			p4.add(totallck);
			p4.add(tlck);
			p4.add(avgluck);
			p4.add(alck);
			
			// adding to panel 5
			p5.add(set2);
			p5.add(set);
		}
		catch(Exception e) {
			System.out.println("ERROR");
		}
	}

	private void back() {
		backButton.setBounds(25, 950, 200, 50);
		backButton.addActionListener(this);
		backButton.setFocusable(false);
		personal.add(backButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			personal.dispose();
			new karthomepage();
		}
		
	}
	
	private void nameChoose(boolean adam) {
		
		
		// checking whose page it is and setting correct name to it
		if (adam == true) {
			name.setText("Adam");
			name2.setText("Rademacher");
	
		} else {
			name.setText("Brian");
			name2.setText("Beffa");
		
		}
		
		name.setFont(new Font(null,Font.PLAIN,80));
		name2.setFont(new Font(null,Font.PLAIN,80));
		name.setBounds(325, 5, 500, 100);
		name2.setBounds(1000, 5, 500, 100);
		personal.add(name2);
		personal.add(name);
	}
	
	private int[] getPlaces(boolean adam) {
		
		// list that will contain amout of times placed in each 12 of the places in mario kart
		int adamPlaces[] = {0,0,0,0,0,0,0,0,0,0,0,0};
		int brianPlaces[] = {0,0,0,0,0,0,0,0,0,0,0,0};
	
		String courseName = "";String timePlayedCourse = "";String aLuck = ""; String bLuck = ""; String aPoints = ""; String bPoints = "";
		
		try {
			
			x = new Scanner(new InputStreamReader(getClass().getResourceAsStream("kartcoursestats")));
			x.useDelimiter("[,\n]");
			
			while (x.hasNext()) {
				
				courseName = x.next();
				timePlayedCourse = x.next();
				aLuck = x.next();
				bLuck = x.next();
				aPoints = x.next();
				bPoints = x.next();
				x.next();
				
				// filling adam places list if adam stats page is the one clicked else filling brian places list
				if (adam == true) {
				
					switch(courseName) {
					case "adam":
						adamPlaces[0] = Integer.parseInt(bPoints);
						break;
					case "adam2-6":
						adamPlaces[1] = Integer.parseInt(timePlayedCourse);
						adamPlaces[2] = Integer.parseInt(aLuck);
						adamPlaces[3] = Integer.parseInt(bLuck);
						adamPlaces[4] = Integer.parseInt(aPoints);
						adamPlaces[5] = Integer.parseInt(bPoints);
						break;
					case "adam7-11":
						adamPlaces[6] = Integer.parseInt(timePlayedCourse);
						adamPlaces[7] = Integer.parseInt(aLuck);
						adamPlaces[8] = Integer.parseInt(bLuck);
						adamPlaces[9] = Integer.parseInt(aPoints);
						adamPlaces[10] = Integer.parseInt(bPoints);
						break;
					case "adam12":
						adamPlaces[11] = Integer.parseInt(timePlayedCourse);
						break;
					} 
				}	
				else {
					switch(courseName) {
					case "brian":
						brianPlaces[0] = Integer.parseInt(bPoints);
						break;
					case "brian2-6":
						brianPlaces[1] = Integer.parseInt(timePlayedCourse);
						brianPlaces[2] = Integer.parseInt(aLuck);
						brianPlaces[3] = Integer.parseInt(bLuck);
						brianPlaces[4] = Integer.parseInt(aPoints);
						brianPlaces[5] = Integer.parseInt(bPoints);
						break;
					case "brian7-11":
						brianPlaces[6] = Integer.parseInt(timePlayedCourse);
						brianPlaces[7] = Integer.parseInt(aLuck);
						brianPlaces[8] = Integer.parseInt(bLuck);
						brianPlaces[9] = Integer.parseInt(aPoints);
						brianPlaces[10] = Integer.parseInt(bPoints);
						break;
					case "brian12":
						brianPlaces[11] = Integer.parseInt(timePlayedCourse);
						break;
				}
				
				
			
				
			
				}
				
				
				
				
				
			}
			/*
			for (int i = 0; i < 12; i++) {
				if (adam == true) {
					adamPlaces[i] -= 1;
					if (i == 10) {
						adamPlaces[i] -= 1;
					}
				} else {
					brianPlaces[i] -= 1;
					if (i == 10) {
						brianPlaces[i] -= 1;
					}
				}
			}
			*/
			
			x.close();
		
			
		
		}
			catch(Exception e)
			{
				System.out.println("ERROR1");
			}
			
		
		// returning brian or adam places when necessary
		if (adam == true) {
			return adamPlaces;
		} else {
			return brianPlaces;
		}
			
	}
	
	
	private void worstAndBest(boolean adam) {
		
		// variables for keeping track of the file and amount of times played a cup
		String bPoints = "";String aPoints = "";String bluck = "";String aluck = ""; String timesPlayed = ""; 
		int num = 0; int num2 = 0;int num3 = 0; int num4 = 0; int count = 0; int bestCup = 0; int worstCup = 999999999;int bestCourse = 0;int worstCourse = 999999999; 
		int luckiestCourse = 0; int unluckiestCourse = 99999;
		// list with all cup names
		String cups[] = {"Mushroom Cup","Flower Cup","Star Cup","Special Cup","Shell Cup","Banana Cup","Leaf Cup","Lightning Cup"};
		
		// all cup integers for keeping track of the number of races played in a certain cup
		int mushroomCup = 0;int flowerCup = 0;int starCup = 0;int specialCup = 0;int shellCup = 0;int bananaCup = 0;int leafCup = 0;int lightningCup = 0;
		int cups2[] = {mushroomCup,flowerCup,starCup, specialCup,shellCup,bananaCup,leafCup,lightningCup};
		int cuppnt[] = {0,0,0,0,0,0,0,0};
		
		JLabel bcpavg = new JLabel();JLabel bcptext = new JLabel(); JLabel wcptext = new JLabel(); JLabel wcpavg = new JLabel();JLabel bcavg = new JLabel();JLabel wcavg = new JLabel();
		JLabel bcname = new JLabel();JLabel wcname = new JLabel(); JLabel bcpic = new JLabel();JLabel wcpic = new JLabel();
		JLabel lcname = new JLabel();JLabel lcavg = new JLabel(); JLabel lcpic = new JLabel(); JLabel ulname = new JLabel();JLabel ulcavg = new JLabel(); JLabel ulcpic = new JLabel();
		// try and catch for file handling 
		try {
			// scanner for looking through the file
			x = new Scanner(new InputStreamReader(getClass().getResourceAsStream("kartcoursestats")));
			x.useDelimiter("[,\n]");
			
			// loop for looking through entire file
			while (x.hasNext()) {
				
				x.next();
				timesPlayed = x.next();
				
				aluck = x.next();
				bluck = x.next();
				
				aPoints = x.next();
				bPoints = x.next();
				x.next(); // skipping through useless info
				
				num = Integer.parseInt(aPoints);
				num2 = Integer.parseInt(bPoints);
				num3 = Integer.parseInt(aluck);
				num4 = Integer.parseInt(bluck);
				
				count += 1; // adding 1 to count to know which track the scanner is looking at
				
				
				
				if (adam == true) {
					num2=num;
					num4= num3;
				}else {
					num=num2;
					num3 = num4;
				}
				
				// choosing best course
				if (bestCourse < num/Integer.parseInt(timesPlayed)) {
					bestCourse = num/(Integer.parseInt(timesPlayed));
					bcavg.setText("Average Points: "+bestCourse);
					bcavg.setFont(new Font(null,Font.PLAIN,25));
					bcname.setText("Best Course: "+ courses[count-1]);
					bcname.setFont(new Font(null,Font.PLAIN,20));
					bcpic.setIcon(courseImages[count-1]);
				}
				
				// choosing worst course
				if (worstCourse > num/Integer.parseInt(timesPlayed)) {
					worstCourse = num/Integer.parseInt(timesPlayed);
					wcavg.setText("Average Points: "+worstCourse);
					wcavg.setFont(new Font(null,Font.PLAIN,25));
					wcname.setText("Worst Course: "+ courses[count-1]);
					wcname.setFont(new Font(null,Font.PLAIN,20));
					wcpic.setIcon(courseImages[count-1]);
				}
				
				// choosing luckiest course
				if (luckiestCourse < num3/Integer.parseInt(timesPlayed)) {
					luckiestCourse = num3/(Integer.parseInt(timesPlayed));
					lcavg.setText("Average Luck: "+luckiestCourse);
					lcavg.setFont(new Font(null,Font.PLAIN,25));
					lcname.setText("Luckiest Course: "+ courses[count-1]);
					lcname.setFont(new Font(null,Font.PLAIN,20));
					lcpic.setIcon(courseImages[count-1]);
				}
				
				// choosing unluckiest course
				if (unluckiestCourse > num3/Integer.parseInt(timesPlayed)) {
					unluckiestCourse = num3/Integer.parseInt(timesPlayed);
					ulcavg.setText("Average Luck: "+unluckiestCourse);
					ulcavg.setFont(new Font(null,Font.PLAIN,25));
					ulname.setText("Unluckiest Course: "+ courses[count-1]);
					ulname.setFont(new Font(null,Font.PLAIN,20));
					ulcpic.setIcon(courseImages[count-1]);
				}
				
				
				// switch for seeing which cup and track is best for each player
				// number represents which number track it is in mario kart wii
				switch(count) {
				case 1:
					
					cuppnt[0] += num;
	
					cups2[0] += Integer.parseInt(timesPlayed);
					break;
				case 2:

				
					cuppnt[0] += num;

					
				
					cups2[0] += Integer.parseInt(timesPlayed);
					break;
				case 3:

					cuppnt[0] += num;
					
					cups2[0] += Integer.parseInt(timesPlayed);
					break;
				case 4:

					
					cuppnt[0] += num;
					
					cups2[0] += Integer.parseInt(timesPlayed);
					break;
				case 5:
					cuppnt[1] += num;
					cups2[1] += Integer.parseInt(timesPlayed);
					break;
				case 6:
					cuppnt[1] += num;
					cups2[1] += Integer.parseInt(timesPlayed);
					break;
				case 7:
					cuppnt[1] += num;
					cups2[1] += Integer.parseInt(timesPlayed);
					break;
				case 8:
					cuppnt[1] += num;
					cups2[1] += Integer.parseInt(timesPlayed);
					break;
				case 9:
					cuppnt[2] += num;
					cups2[2] += Integer.parseInt(timesPlayed);
					break;
				case 10:
					cuppnt[2] += num;
					cups2[2] += Integer.parseInt(timesPlayed);
					break;
				case 11:
					cuppnt[2] += num;
					cups2[2] += Integer.parseInt(timesPlayed);
					break;
				case 12:
					cuppnt[2] += num;
					cups2[2] += Integer.parseInt(timesPlayed);
					break;
				case 13:
					cuppnt[3] += num;
					cups2[3] += Integer.parseInt(timesPlayed);
					break;
				case 14:
					cuppnt[3] += num;
					cups2[3] += Integer.parseInt(timesPlayed);
					break;
				case 15:
					cuppnt[3] += num;
					cups2[3] += Integer.parseInt(timesPlayed);
					break;
				case 16:
					cuppnt[3] += num;
					cups2[3] += Integer.parseInt(timesPlayed);
					break;
				case 17:
					cuppnt[4] += num;
					cups2[4] += Integer.parseInt(timesPlayed);
					break;
				case 18:
					cuppnt[4] += num;
					cups2[4] += Integer.parseInt(timesPlayed);
					break;
				case 19:
					cuppnt[4] += num;
					cups2[4] += Integer.parseInt(timesPlayed);
					break;
				case 20:
					cuppnt[4] += num;
					cups2[4] += Integer.parseInt(timesPlayed);
					break;
				case 21:
					cuppnt[5] += num;
					cups2[5] += Integer.parseInt(timesPlayed);
					break;
				case 22:
					cuppnt[5] += num;
					cups2[5] += Integer.parseInt(timesPlayed);
					break;
				case 23:
					cuppnt[5] += num;
					cups2[5] += Integer.parseInt(timesPlayed);
					break;
				case 24:
					cuppnt[5] += num;
					cups2[5] += Integer.parseInt(timesPlayed);
					break;
				case 25:
					cuppnt[6] += num;
					cups2[6] += Integer.parseInt(timesPlayed);
					break;
				case 26:
					cuppnt[6] += num;
					cups2[6] += Integer.parseInt(timesPlayed);
					break;
				case 27:
					cuppnt[6] += num;
					cups2[6] += Integer.parseInt(timesPlayed);
					break;
				case 28:
					cuppnt[6] += num;
					cups2[6] += Integer.parseInt(timesPlayed);
					break;
				case 29:
					cuppnt[7] += num;
					cups2[7] += Integer.parseInt(timesPlayed);
					break;
				case 30:
					cuppnt[7] += num;
					cups2[7] += Integer.parseInt(timesPlayed);
					break;
				case 31:
					cuppnt[7] += num;
					cups2[7] += Integer.parseInt(timesPlayed);
					break;
				case 32:
					cuppnt[7] += num;
					cups2[7] += Integer.parseInt(timesPlayed);
					break;
				}
			
				
				
				
				if (count == 32) {
					break;
				}
			}
			x.close();
			
		
			
			// setting up worst and best cup 
			for (int i = 0; i < 8;i++) {
				
				if (worstCup > (cuppnt[i]/cups2[i])) {
					worstCup = (cuppnt[i]/cups2[i]);
					wcptext.setText("Worst Cup: "+cups[i]);
					wcpavg.setText("Average Points: " + worstCup);
					wcptext.setFont(new Font(null,Font.PLAIN,20));
					wcpavg.setFont(new Font(null,Font.PLAIN,25));
					worstcp.setIcon(cupImages[i]);
				}
				
				if (bestCup < (cuppnt[i]/cups2[i])) {
					bestCup = (cuppnt[i]/cups2[i]);
					bcptext.setText("Best Cup: "+cups[i]);
					bcpavg.setText("Average Points: " + bestCup);
					bcptext.setFont(new Font(null,Font.PLAIN,20));
					bcpavg.setFont(new Font(null,Font.PLAIN,25));
					bestcp.setIcon(cupImages[i]);
				}
			}
			
			// adding best and worst cup and course pictures and average labels to panel 3
			p3.add(bcname);
			p3.add(bcpic);
			p3.add(bcavg);
			p3.add(wcname);
			p3.add(wcpic);
			p3.add(wcavg);
			
			// adding best and worst cup to panel 4
			p4.add(bcptext);
			p4.add(bestcp);
			p4.add(bcpavg);
			p4.add(wcptext);
			p4.add(worstcp);
			p4.add(wcpavg);
			
			// adding luckiest and unluckiest courses to panel 5
			p5.add(lcname);
			p5.add(lcpic);
			p5.add(lcavg);
			p5.add(ulname);
			p5.add(ulcpic);
			p5.add(ulcavg);
		}
		catch(Exception e){
			System.out.println("ERROR");
		}
		
	
		
		
		
		
	}
}
