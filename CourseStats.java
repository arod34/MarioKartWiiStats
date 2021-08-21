import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class courseStats implements ActionListener{
	
	JFrame frame = new JFrame(); // frame of my stats
	JLabel j = new JLabel("Adam stats"); // temporary
	JButton backButton = new JButton("Back"); // button for going back to home page
	ImageIcon adamPic = new ImageIcon("adam.jpg"); // picture of me for my stats page
	
	
	courseStats(int Course){
		
		
		switch(Course) {
		case 0:
			j.setText("0");
			break;
		case 1:
			j.setText("0");
			break;
		case 2:
			j.setText("0");
			break;
		case 3:
			j.setText("0");
			break;
		case 4:
			j.setText("0");
			break;
		case 5:
			j.setText("0");
			break;
		case 6:
			j.setText("0");
			break;
		case 7:
			j.setText("0");
			break;
		case 8:
			j.setText("0");
			break;
		case 9:
			j.setText("0");
			break;
		case 10:
			j.setText("0");
			break;
		case 11:
			j.setText("0");
			break;
		case 12:
			j.setText("0");
			break;
		case 13:
			j.setText("0");
			break;
		case 14:
			j.setText("0");
			break;
		case 15:
			j.setText("0");
			break;
		case 16:
			j.setText("0");
			break;
		case 17:
			j.setText("0");
			break;
		case 18:
			j.setText("0");
			break;
		case 19:
			j.setText("0");
			break;
		case 20:
			j.setText("0");
			break;
		case 21:
			j.setText("0");
			break;
		case 22:
			j.setText("0");
			break;
		case 23:
			j.setText("0");
			break;
		case 24:
			j.setText("0");
			break;
		case 25:
			j.setText("0");
			break;
		case 26:
			j.setText("0");
			break;
		case 27:
			j.setText("0");
			break;
		case 28:
			j.setText("0");
			break;
		case 29:
			j.setText("0");
			break;
		case 30:
			j.setText("0");
			break;
		case 31:
			j.setText("1");
			break;
		}
		
		j.setBounds(0,0,500,100);
		j.setBackground(Color.red);
		j.setFont(new Font(null,Font.PLAIN,25));
		j.setOpaque(true);
		j.setIcon(adamPic);
		
		// button for going back to home page property's
		backButton.addActionListener(this);
		backButton.setBounds(25, 425, 70, 20);
		
		// Property's of the frame for my mario kart wii stats
		frame.add(backButton);
		frame.add(j);
		frame.setTitle("Mario Kart Statistics"); // frame title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program stops when frame is closed
		frame.setResizable(true); // Allows window to be resized by user
		frame.setSize(960,540); // sets default size of the frame to width: 690 height : 420
		frame.setLayout(null);
		frame.setVisible(true);
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			frame.dispose();
			HomePage home = new HomePage();
		}
		
	}
}
