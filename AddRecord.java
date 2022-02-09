import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddRecord implements ActionListener{
	private static Scanner x;
	private static Scanner y;
	JFrame frame = new JFrame();
	
	// text fields
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	JTextField stats[] = {t1,t2,t3,t4};
	
	// labels
	JLabel j1 = new JLabel("adam luck");
	JLabel j2 = new JLabel("brian luck");
	JLabel j3 = new JLabel("adam points");
	JLabel j4 = new JLabel("brian points");
	
	JButton submit = new JButton("submit");
	
	String courses[] = {"LuigiCircuit","MooMooMeadows","MushroomGorge","ToadFactory","MarioCircuit",
			"CoconutMall","DKSummit","WarioGoldMine","DaisyCircuit","KoopaCape","MapleTreeway","GrumbleVolcano",
			"DryDryRuins","MoonviewHighway","BowserCastle","RainbowRoad","PeachBeach","YoshiFalls","GhostValley2",
			"MarioRaceway","SherbertLand","ShyGuyBeach","DelfinoSquare","WaluigiStadium","DesertHills","BowserCastle3",
			"DKJungleParkway","GCNMarioCircuit","MarioCircuit3","PeachGardens","DKMountain","N64BowserCastle"};
	
	
	JComboBox courseList = new JComboBox(courses);
	
	int buffer = 0;
	

	static boolean adam_bested = true;
	static int adam_points = 0;
	static int brian_points = 0;

	
	AddRecord(){
		submit.setBounds(380, 130, 80, 20);
		submit.setFocusable(false);
		submit.addActionListener(this);
		
		for (int i = 0; i < 4; i++) {
			stats[i].setBounds(195+buffer, 55, 50, 30);
			buffer += 75;
			frame.add(stats[i]);
		}
		
		
		// adding labels for textfields 
		j1.setBounds(190, 30, 100, 30);
		j2.setBounds(268, 30, 100, 30);
		j3.setBounds(338, 30, 100, 30);
		j4.setBounds(415, 30, 100, 30);
		frame.add(j1);
		frame.add(j2);
		frame.add(j3);
		frame.add(j4);
		
		
		courseList.setBounds(25, 55, 150, 30);
		courseList.addActionListener(this);
		frame.add(courseList);
		frame.add(submit);
		frame.setSize(500,200);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
	


		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			editCourseStats("StatFiles/courseStats",(String) courseList.getSelectedItem(),"1",stats[0].getText(),stats[1].getText(),stats[2].getText(),stats[3].getText());
			change_course_history((String) courseList.getSelectedItem());
			frame.dispose();
			new HomePage();
		}
		
	}
	


	private void change_course_history(String course) {
		
		try {
			
			
			File oldfile = new File("StatFiles/courseHistory.txt");
			File newFile = new File("StatFiles/temp.txt");
			
			FileWriter fw = new FileWriter("StatFiles/temp.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			x = new Scanner(new File("StatFiles/courseHistory.txt"));
			x.useDelimiter("[,\n]");
			
			
			String course_name;
			String ab;
			String bb;
			String anum[] = {"","","","",""};
			String arnum;
			String bnum[] = {"","","","",""};
			String brnum;
			int adamB;
			int brianB;
			int race_num;
			
		
			
			
			while (x.hasNext()) {
				
				course_name = x.next();
				adamB = Integer.parseInt(x.next());
				brianB = Integer.parseInt(x.next());
				anum[0] = x.next();
				anum[1] = x.next();
				anum[2] = x.next();
				anum[3] = x.next();
				anum[4] = x.next();
				arnum = x.next();
				bnum[0] = x.next();
				bnum[1] = x.next();
				bnum[2] = x.next();
				bnum[3] = x.next();
				bnum[4] = x.next();
				brnum = x.next();
				x.next();
				
				
				
				ab = String.valueOf(adamB);
				bb = String.valueOf(brianB);
				
				if (course_name.equals(course)) {
					
					if (adam_bested == true) {
						adamB += 1;
					}
					
					else {
						brianB += 1;
					}
					
					anum[Integer.parseInt(arnum)] = String.valueOf(adam_points);
					bnum[Integer.parseInt(brnum)] = String.valueOf(brian_points);
					
					arnum = String.valueOf(Integer.parseInt(arnum)+1);
					brnum = arnum;
					
					if (Integer.parseInt(arnum) >= 5) {
						arnum = "0";
						brnum = "0";
						
					}
					
				
					
					ab = String.valueOf(adamB);
					bb = String.valueOf(brianB);
					
					pw.println(course_name+","+ab+","+bb+","+anum[0]+","+anum[1]+","+anum[2]+","+anum[3]+","+anum[4]+","+arnum+","+bnum[0]+","+bnum[1]+","+bnum[2]+","+bnum[3]+","+bnum[4]+","+brnum+","+"useless");
					
					
					
					
					
				}
				
				else {
					
					pw.println(course_name+","+ab+","+bb+","+anum[0]+","+anum[1]+","+anum[2]+","+anum[3]+","+anum[4]+","+arnum+","+bnum[0]+","+bnum[1]+","+bnum[2]+","+bnum[3]+","+bnum[4]+","+brnum+","+"useless");
					
					
				}
				
			
				
			}
			
			
			x.close();
			pw.flush();
			pw.close();
			oldfile.delete();
			File dump = new File("StatFiles/courseHistory.txt");
			newFile.renameTo(dump);
		}
		
		catch(Exception e)
		{
			System.out.println("ERROR COURSE HISTORY");
		}
		
	}

	public static void editCourseStats(String file, String course,String timesPlayed,String adamLuck, String brianLuck, String adamPoints, String brianPoints) {
		
		int num[] = {0,0,0,0,0};
		int num2[] = {0,0,0,0,0};
		int adamPlaces[] = {0,0,0,0,0,0,0,0,0,0,0,0};
		int brianPlaces[] = {0,0,0,0,0,0,0,0,0,0,0,0};
		String stats[] = {"","","","",""};
		String tempFile = "StatFiles/temp.txt";
		File oldfile = new File(file);
		File newFile = new File(tempFile);
		int count = 0; int ap = 0; int bp = 0; int set = 0; int adamVictory = 0; int brianVictory = 0;int points = 8;
		String courseName = "";String timePlayedCourse = "";String aLuck = ""; String bLuck = ""; String aPoints = ""; String bPoints = "";
		
		
		
		
		try {
			FileWriter fw = new FileWriter(tempFile);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			x = new Scanner(new File(file));
			x.useDelimiter("[,\n]");
			
			while (x.hasNext()) {
				
				courseName = x.next();
				timePlayedCourse = x.next();
				aLuck = x.next();
				bLuck = x.next();
				aPoints = x.next();
				bPoints = x.next();
				x.next();
				


			
				
				
				if (courseName.equals(course)) {
					
					adam_points = Integer.parseInt(adamPoints);
					brian_points = Integer.parseInt(brianPoints);
					
					
					
					if (adam_points > brian_points) {
						adam_bested = true;
					}
					else {
						adam_bested = false;
					}
					
					num[0] = Integer.parseInt(timePlayedCourse);
					num[1] = Integer.parseInt(aLuck);
					num[2] = Integer.parseInt(bLuck);
					num[3] = Integer.parseInt(aPoints);
					num[4] = Integer.parseInt(bPoints);
					num2[0] = Integer.parseInt(timesPlayed);
					num2[1] = Integer.parseInt(adamLuck);
					num2[2] = Integer.parseInt(brianLuck);
					num2[3] = Integer.parseInt(adamPoints);
					num2[4] = Integer.parseInt(brianPoints);
					
					points = 12;// setting up points for 2nd and 3rd
					for (int i = 1; i < 3; i++) {
						if (num2[3] == points) {
							adamPlaces[i] = 1;
						}
						
						if (num2[4] == points) {
							brianPlaces[i] = 1;
						}
						points -= 2;
					}
					
					points = 8; // setting up points for last 9 places
					// loop for getting what place player has finished in
					for (int i = 3; i < 12; i++) {
						if (num2[3] == points) {
							adamPlaces[i] = 1;
						}
						
						if (num2[4] == points) {
							brianPlaces[i] = 1;
						}
						points -= 1;
					}
					
					for (int i = 0; i < 5; i++) {
						stats[i] = Integer.toString(num[i]+num2[i]);
					}
					pw.println(course + "," + stats[0] + "," + stats[1] + "," + stats[2] + "," + stats[3] +"," + stats[4] + "," + "useless");
					
				
					
				}
				else if (count == 32) {
					if (Integer.parseInt(timePlayedCourse) == 5) {
						
						num[1] = Integer.parseInt(aLuck);
						num[2] = Integer.parseInt(bLuck);

						// checking who won set
						if (num[1] > num[2]) {
							adamVictory = 1;
						} else {
							brianVictory = 1;
						}
						
						aLuck = "0";
						bLuck = "0";
						timePlayedCourse = "0";
						
						
						// updating set number
						set = 1;
						
					}
					ap = Integer.parseInt(aLuck)+num2[3];
					bp = Integer.parseInt(bLuck)+num2[4];
					pw.println("set" + "," + Integer.toString(Integer.parseInt(timePlayedCourse)+1) + "," + Integer.toString(ap) + "," + Integer.toString(bp)  + "," + "0" +"," + "0" + "," + "useless");
					
				} else if (count > 32) {
					
					// getting variables to be used to update file
					num[0] = Integer.parseInt(timePlayedCourse);
					num[1] = Integer.parseInt(aLuck);
					num[2] = Integer.parseInt(bLuck);
					num[3] = Integer.parseInt(aPoints);
					num[4] = Integer.parseInt(bPoints);

					switch(courseName) {
					case "adam":
						
						
					
						if (num2[3] == 15) {
							adamPlaces[0] = 1;
						}
						
						pw.println(courseName + "," + Integer.toString(num[0]+set) + "," + Integer.toString(num[1]+adamVictory) + "," + Integer.toString(num[2]+num2[3]) + "," + Integer.toString(num[3]+num2[1]) +"," + Integer.toString(num[4]+adamPlaces[0]) + "," + "useless");
						break;
					case "adam2-6":
						pw.println(courseName + "," + Integer.toString(num[0]+adamPlaces[1]) + "," + Integer.toString(num[1]+adamPlaces[2]) + "," + Integer.toString(num[2]+adamPlaces[3]) + "," + Integer.toString(num[3]+adamPlaces[4]) +"," + Integer.toString(num[4]+adamPlaces[5]) + "," + "useless");
						break;
					case "adam7-11":
						pw.println(courseName + "," + Integer.toString(num[0]+adamPlaces[6]) + "," + Integer.toString(num[1]+adamPlaces[7]) + "," + Integer.toString(num[2]+adamPlaces[8]) + "," + Integer.toString(num[3]+adamPlaces[9]) +"," + Integer.toString(num[4]+adamPlaces[10]) + "," + "useless");
						break;
					case "adam12":
						pw.println(courseName + "," + Integer.toString(num[0]+adamPlaces[11]) + "," + aLuck + "," + bLuck + "," + aPoints +"," + bPoints + "," + "useless");
						break;
					case "brian":
					
						if (num2[4] == 15) {
							brianPlaces[0] = 1;
						}
						
						pw.println(courseName + "," + Integer.toString(num[0]+set) + "," + Integer.toString(num[1]+brianVictory) + "," + Integer.toString(num[2]+num2[4]) + "," + Integer.toString(num[3]+num2[2]) +"," + Integer.toString(num[4]+brianPlaces[0]) + "," + "useless");
						break;
						
					case "brian2-6":
						pw.println(courseName + "," + Integer.toString(num[0]+brianPlaces[1]) + "," + Integer.toString(num[1]+brianPlaces[2]) + "," + Integer.toString(num[2]+brianPlaces[3]) + "," + Integer.toString(num[3]+brianPlaces[4]) +"," + Integer.toString(num[4]+brianPlaces[5]) + "," + "useless");
						break;
					case "brian7-11":
						pw.println(courseName + "," + Integer.toString(num[0]+brianPlaces[6]) + "," + Integer.toString(num[1]+brianPlaces[7]) + "," + Integer.toString(num[2]+brianPlaces[8]) + "," + Integer.toString(num[3]+brianPlaces[9]) +"," + Integer.toString(num[4]+brianPlaces[10]) + "," + "useless");
						break;
					case "brian12":
						pw.println(courseName + "," + Integer.toString(num[0]+brianPlaces[11]) + "," + aLuck + "," + bLuck + "," + aPoints +"," + bPoints + "," + "useless");
						
						break;
					}
				}
				
				else {
					pw.println(courseName + "," + timePlayedCourse + "," + aLuck + "," + bLuck + "," + aPoints +"," + bPoints + "," + "useless");
				}
				
				count+=1;
				
				
				
				
			}
 
			
			x.close();
			pw.flush();
			pw.close();
			oldfile.delete();
			File dump = new File(file);
			newFile.renameTo(dump);
			
		
		}
			catch(Exception e)
			{
				System.out.println("ERROR");
			}
			
		
	
			
	}
}
