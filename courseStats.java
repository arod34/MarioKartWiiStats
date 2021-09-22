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

public class courseStats implements ActionListener{
	
	private static Scanner x;
	
	JFrame frame = new JFrame(); // frame of my stats
	JLabel j = new JLabel("Adam stats"); // temporary
	JButton backButton = new JButton("Back"); // button for going back to home page


	// player pics
	ImageIcon adamPic = new ImageIcon("misc/adam.jpg");
	ImageIcon brianPic = new ImageIcon("misc/brian.jpg");
	
	Timer timer = new Timer(); // timer for changing color of name
	int colorNum = 0; // number for choosing color
	
	// all course names
		String courses[] = {"LuigiCircuit","MooMooMeadows","MushroomGorge","ToadsFactory","MarioCircuit",
				"CoconutMall","DKSummit","WariosGoldMine","DaisyCircuit","KoopaCape","MapleTreeway","GrumbleVolcano",
				"DryDryRuins","MoonviewHighway","BowsersCastle","RainbowRoad","PeachBeach","YoshiFalls","GhostValley2",
				"MarioRaceway","SherbertLand","ShyGuyBeach","DelfinoSquare","WaluigiStadium","DesertHills","BowsersCastle3",
				"DKJungleParkway","GCNMarioCircuit","MarioCircuit3","PeachGardens","DKMountain","N64BowsersCastle"};
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
	
		JLabel coursename = new JLabel();
		int num = 50;
		int target = 100;
		boolean max = false;
	
	courseStats(int Course){
		
		
		layout(Course+1); // function pulling up individual course stats
		coursename.setText(courses[Course]);
		coursename.setFont(new Font(null, Font.PLAIN,50));
		
		

		
		// button for going back to home page property's
		backButton.addActionListener(this);
		backButton.setFocusable(false);
		backButton.setBounds(25, 950, 200, 50);
		
		// Property's of the frame for my mario kart wii stats
		frame.add(backButton);
		frame.setTitle("Mario Kart Statistics"); // frame title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program stops when frame is closed
		frame.setResizable(true); // Allows window to be resized by user
		frame.setSize(1920,1080); // sets default size of the frame to width: 690 height : 420
		frame.setLayout(null);
		frame.setVisible(true);
		
		TimerTask task = new TimerTask() {
			public void run() {
				changeSize();
				
			}
		};

		timer.scheduleAtFixedRate(task, 20, 20);
		
		
	}
	
	
	private void changeSize() {
		
		if (num == 100) {
			target = 50;
		}
		
		if (num == 50) {
			target = 100;
		}
		
		if (num < target) {
			max = false;
		} else {
			max = true;
		}
		
		if (max == true) {
			num -= 1;
			coursename.setFont(new Font(null, Font.PLAIN,num));
			
		} else {
			num += 1;
			coursename.setFont(new Font(null, Font.PLAIN,num));
		}
		
		
	}

	
	public void layout(int courseNum) {
		// labels for courses info
		JLabel adampts = new JLabel();JLabel adamluck = new JLabel();JLabel brianpts = new JLabel();JLabel brianluck = new JLabel(); 
		JLabel adampts2 = new JLabel();JLabel adamluck2 = new JLabel();JLabel brianpts2 = new JLabel();JLabel brianluck2 = new JLabel();
		JLabel adampic = new JLabel(); JLabel coursepic = new JLabel();JLabel timeplayed = new JLabel();
		
		// strings for storing file data
		String timePlayedCourse = "";String aLuck = ""; String bLuck = ""; String aPoints = ""; String bPoints = "";
		
		int count = 0; // int for seeing what track the file is on
		int aAvg = 0; // int for holding adams average points for course
		int bAvg = 0; // int for holding brians average points for course
		int alAvg = 0; // int for holding adams average luck for course
		int blAvg = 0; // int for holding brians average luck for course
		
		try {
			x = new Scanner(new InputStreamReader(getClass().getResourceAsStream("courseStats")));
			x.useDelimiter("[,\n]");
			while (x.hasNext()) {
				
				count += 1;
			
				x.next();
				timePlayedCourse = x.next();
				aLuck = x.next();
				bLuck = x.next();
				aPoints = x.next();
				bPoints = x.next();
				x.next();
				
				if (count == courseNum) {
					
					aAvg = (Integer.parseInt(aPoints)/Integer.parseInt(timePlayedCourse));
					bAvg = (Integer.parseInt(bPoints)/Integer.parseInt(timePlayedCourse));
					alAvg = (Integer.parseInt(aLuck)/Integer.parseInt(timePlayedCourse));
					blAvg = (Integer.parseInt(bLuck)/Integer.parseInt(timePlayedCourse));
					
					// setting up text for cours page
					adampts.setText("Adam Average Points:");
					adampts2.setText("Average: " + aAvg);
					adamluck.setText("Adam Average Luck:");
					adamluck2.setText("Average: " + alAvg);
					brianpts.setText("Brian Average Points:");
					brianpts2.setText("average: " + bAvg);
					brianluck.setText("Brian Average Luck:");
					brianluck2.setText("Average: " + blAvg);
					timeplayed.setText("Times Played Course: "+ timePlayedCourse);
					coursename.setText(courses[count-1]);
					
					// setting up font for course page
					adampts.setFont(new Font(null, Font.PLAIN,50));
					adampts2.setFont(new Font(null, Font.PLAIN,50));
					adamluck.setFont(new Font(null, Font.PLAIN,50));
					adamluck2.setFont(new Font(null, Font.PLAIN,50));
					brianpts.setFont(new Font(null, Font.PLAIN,50));
					brianpts2.setFont(new Font(null, Font.PLAIN,50));
					brianluck.setFont(new Font(null, Font.PLAIN,50));
					brianluck2.setFont(new Font(null, Font.PLAIN,50));
					timeplayed.setFont(new Font(null, Font.PLAIN,30));
					
					
					// setting up images for labels on page
					coursepic.setIcon(courseImages[count-1]);
					
					//setting up spot for label on page
					adampts.setBounds(80,25,600,400);
					adampts2.setBounds(160,120,600,400);
					adamluck.setBounds(80,450,600,400);
					adamluck2.setBounds(160,545,600,400);
					brianpts.setBounds(1300,25,600,400);
					brianpts2.setBounds(1380,120,600,400);
					brianluck.setBounds(1300,450,600,400);
					brianluck2.setBounds(1380,545,600,400);
					coursepic.setBounds(750, 300, 250, 200);
					coursename.setBounds(700, 50, 1000, 100);
					timeplayed.setBounds(715, 450, 800, 200);
					
					// adding labels to frame
					frame.add(adampts);
					frame.add(adampts2);
					frame.add(adampic);
					frame.add(adamluck);
					frame.add(adamluck2);
					frame.add(brianpts);
					frame.add(brianpts2);
					frame.add(brianluck);
					frame.add(brianluck2);
					frame.add(coursepic);
					frame.add(timeplayed);
					frame.add(coursename);
				}
		
				
			}
			
			x.close();
			
		}
		
		catch(Exception e) {
			System.out.println("ERROR3");
		}
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			frame.dispose();
			new HomePage();
		}
		
	}
}
