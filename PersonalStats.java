import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class personalStats implements ActionListener{
	
	private static Scanner x;
	
	JFrame personal = new JFrame();
	JButton backButton = new JButton("Back");
	JPanel p1 = new JPanel(); // panel for all places
	JPanel p2 = new JPanel(); // panel for all place amounts finished in
	
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
	
	
	personalStats(boolean adam){
		
		
		
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
		}
		
		// loop for adding place labels to p1
		for (int i = 0; i < 12; i++) {
			places[i].setFont(new Font(null,Font.PLAIN,50));
			p1.add(places[i]);
		}
		
		placesAmount.setFont(new Font(null,Font.PLAIN,25));
		placesAmount.setBounds(10, 10, 200, 100);
		personal.add(placesAmount);
		
		// panels
		p1.setBounds(25, 100, 100, 850);
		p2.setBounds(125,100,60,850);
		
		personal.add(p1); // adding panel 1 to frame
		personal.add(p2); // adding panel 2 to frame
		
		back(); // function holding properties for back button to get back to home page
		
		// property's of brian's mario kart stats
		personal.setTitle("Mario Kart Statistics"); // frame title
		personal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program stops when frame is closed
		personal.setResizable(true); // Allows window to be resized by user
		personal.setSize(1920,1080); // sets default size of the frame to width: 690 height : 420
		personal.setLayout(null);
		personal.setVisible(true);
		personal.add(p1); // adding panel 1 to frame
		
		
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
			HomePage home = new HomePage();
		}
		
	}
	
	
	private int[] getPlaces(boolean adam) {
		
		// list that will contain amout of times placed in each 12 of the places in mario kart
		int adamPlaces[] = {0,0,0,0,0,0,0,0,0,0,0,0};
		int brianPlaces[] = {0,0,0,0,0,0,0,0,0,0,0,0};
	
		String courseName = "";String timePlayedCourse = "";String aLuck = ""; String bLuck = ""; String aPoints = ""; String bPoints = ""; String useless = "";
		
		try {
			
			x = new Scanner(new File("statFiles/courseStats"));
			x.useDelimiter("[,\n]");
			
			while (x.hasNext()) {
				
				courseName = x.next();
				timePlayedCourse = x.next();
				aLuck = x.next();
				bLuck = x.next();
				aPoints = x.next();
				bPoints = x.next();
				useless = x.next();
				
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
	
	
private int worstAndBest(boolean adam) {
		
		// variables for keeping track of the file and amount of times played a cup
		String bPoints = "";String aPoints = "";String cup = "";String cup2 = "";int amount = 0; int count = 0; int lowest = 999999999; int num = 0; int num2 = 0;
		int bestCup = 0; int worstCup = 999999999;int bestCourse = 0; int picNum = 0;int picNum2 = 0;int picNum3 = 0;int picNum4 = 0;
		int worstCourse = 999999999; String timesPlayed = ""; int bestCp = 0; int worstCp = 99999999; int cupPlayed = 0;
		
		// list with all cup names
		String cups[] = {"Mushroom Cup","Flower Cup","Star Cup","Special Cup","Shell Cup","Banana Cup","Leaf Cup","Lightning Cup"};
		
		// all cup integers for keeping track of the number of races played in a certain cup
		int mushroomCup = 0;int flowerCup = 0;int starCup = 0;int specialCup = 0;int shellCup = 0;int bananaCup = 0;int leafCup = 0;int lightningCup = 0;
		
		JLabel cupName = new JLabel();JLabel bctext = new JLabel(); JLabel wctext = new JLabel(); JLabel cupName2 = new JLabel();
		
		// try and catch for file handling 
		try {
			// scanner for looking through the file
			x = new Scanner(new File("StatFiles/courseStats"));
			x.useDelimiter("[,\n]");
			
			// loop for looking through entire file
			while (x.hasNext()) {
				
				x.next();
				timesPlayed = x.next();
				
				// looping to get rid of all useless information from file
				for (int i = 0; i < 2; i++) {
					x.next();
				}
				
				aPoints = x.next();
				bPoints = x.next();
				x.next(); // skipping through useless info
				
				num = Integer.parseInt(aPoints);
				num2 = Integer.parseInt(bPoints);
				
				count += 1; // adding 1 to count to know which track the scanner is looking at
				
				amount = Integer.parseInt(timesPlayed);
				cupPlayed += amount;
				
				if (adam == true) {
					if (num == 0 && amount == 0) {
						amount = 0;
					}else {
						amount = num / amount;
					}
				} else if (num == 0 && amount == 0){
					amount = 0;
					num = num2;
					
				} else {
					amount = num2 / amount;
					num = num2;
				}
				
				System.out.println(amount);
				
				// switch for seeing which cup and track is best for each player
				// number represents which number track it is in mario kart wii
				switch(count) {
				case 1:
					
					bestCup += num;
					worstCup += num;
					
					
					// checking for best course
					if (bestCourse < num) {
						bestCourse = num;
						picNum = count;
					}
					
					// checking for worst course
					if (worstCourse > num) {
						worstCourse = num;
						picNum2 = count;
					}
					
					break;
				case 2:

					bestCup += num;
					worstCup += num;
					
					
					// checking for best course
					if (bestCourse < num) {
						bestCourse = num;
						picNum = count;
					}
					
					// checking for worst course
					if (worstCourse > num) {
						worstCourse = num;
						picNum2 = count;
					}
					
					break;
				case 3:

					bestCup += num;
					worstCup += num;
					
					
					// checking for best course
					if (bestCourse < num) {
						bestCourse = num;
						picNum = count;
					}
					
					// checking for worst course
					if (worstCourse > num) {
						worstCourse = num;
						picNum2 = count;
					}
					
					break;
				case 4:

					bestCup += num;
					worstCup += num;
					
					
					// checking for best course
					if (bestCourse < num) {
						bestCourse = num;
						picNum = count;
					}
					
					// checking for worst course
					if (worstCourse > num) {
						worstCourse = num;
						picNum2 = count;
					}
					
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
				
				if ((count % 4) == 0) {
					if (bestCp < (bestCup/cupPlayed)) {
						picNum3 = count;
						bctext.setText("Best Cup:" + cups[(count/4)-1]);
						
						
					}
				}
				
				if (count == 32) {
					break;
				}
			}
		}
		catch(Exception e){
			System.out.println("ERROR");
		}
		
	
		
		x.close();
		
		return amount;
	}
}
