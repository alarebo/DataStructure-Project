import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.*;



@SuppressWarnings("serial")
public class LoadingWindow extends JFrame
{
	int counter;	    
	Timer timeR;
	private JLabel logoLabel,userLabel;
	String nameU ="user name";
	private JTextField txtWelcome;

	
	public LoadingWindow()
	{
		setSize(700,400);
		setVisible(true);
		createGui();
		userTEXT("User Name");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	private void createGui() 
	{
		JPanel welcomPanel = new JPanel();
		welcomPanel.setLayout(null);
		
		ImageIcon img =  new ImageIcon("resources/Loading.gif");
		getContentPane().add(welcomPanel,BorderLayout.CENTER);	
		
	    userLabel = new JLabel(nameU);
	    userLabel.setForeground(new Color(75, 0, 130));
	    userLabel.setBackground(new Color(255, 255, 255));
		userLabel.setFont(new Font("High Tower Text", Font.PLAIN, 33));
		userLabel.setBounds(173, 27, 186, 33);
		welcomPanel.add(userLabel);
		
		txtWelcome = new JTextField() {
		    @Override public void setBorder(Border border) {
		        // No!
		    }
		};
		txtWelcome.setOpaque(false);
		txtWelcome.setForeground(new Color(75, 0, 130));
		txtWelcome.setFont(new Font("High Tower Text", Font.BOLD, 33));
		txtWelcome.setEditable(false);
		txtWelcome.setText("Welcome:");
		txtWelcome.setBounds(12, 21, 162, 43);
		welcomPanel.add(txtWelcome);
		txtWelcome.setColumns(10);
		logoLabel = new JLabel("");
		logoLabel.setIcon(img);
		logoLabel.setBounds(0, 0, 682, 353);
		welcomPanel.add(logoLabel);
		
		

	}
	void userTEXT(String u) 
	{
		userLabel.setText(u);	
	}
	public static void main(String [] args)
	{
		LoadingWindow win = new LoadingWindow();
		win.setVisible(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Timer timer = new Timer(6000, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        win.dispose();
		        WorkOutSelection f = new WorkOutSelection();
		        f.setVisible(true);
		        }
		    });
	    timer.setRepeats(false);
	    timer.start();
	
	}
}