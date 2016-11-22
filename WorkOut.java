
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

	@SuppressWarnings("serial")
	public class WorkOut extends JFrame {
		static int st=0;
		static String tune = "resources/Ms_New_Booty_Lyrics.wav";
		public static void main(String[] args) 
		{
			WorkOut frame = new WorkOut();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			frame.play();
	    }
		static class stpl implements ActionListener
		 {
			 public void actionPerformed(ActionEvent event)
			 {	
				 clip.setFramePosition(0);  // Must always rewind!
				 clip.start();
			 } 
		 
		 }
		static class stspl implements ActionListener
		 {
			 public void actionPerformed(ActionEvent event)
			 {	
				 if(clip.isActive())
				 {
					clip.stop(); 
				 }
			 } 
		 
		 }
		 class backL implements ActionListener
		 {
			 public void actionPerformed(ActionEvent event)
			 {	
				 if(clip.isActive())
				 {
					clip.stop(); 
				 }
				 WorkOutSelection back = new WorkOutSelection();
				 back.setVisible(true);
				 dispose();
			 } 
		 
		 }

		public static void open()
		{
			music(tune);	
		}
	    private static Clip clip;
	    public WorkOut() 
	    {
	    	createGui();

	    	setSize(550,450);
			setTitle("Leg WorkOut");
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			open();
			st=0;

	    }
	    
	    public static  void music(String fileName) {	      
	    	
	    	try 
	    	{
	    		File file = new File(fileName);
	    		if (file.exists()) 
	    		{
	    			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
	    			// load the sound into memory (a Clip)
	    			clip = AudioSystem.getClip();
	    			clip.open(sound);
	    			if(st ==0){clip.start();}
	    		}
	    		else
	    		{
	    			throw new RuntimeException("Sound: file not found: " + fileName);
	    		}
	    	}
       
	    	catch (MalformedURLException e) 
	    	{
	    		e.printStackTrace();
	    		throw new RuntimeException("Sound: Malformed URL: " + e);
	    	}
    
	    	catch (UnsupportedAudioFileException e) 
	    	{         
	    		e.printStackTrace();
	    		throw new RuntimeException("Sound: Unsupported Audio File: " + e);   
	    	}
	    	catch (IOException e)
	    	{           
	    		e.printStackTrace();        
	    		throw new RuntimeException("Sound: Input/Output Error: " + e);
	    	}
	    	catch (LineUnavailableException e) 
	    	{
	    		e.printStackTrace();
	    		throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
	    	}
			
		}

		private void createGui() {
			
			Image img =  new ImageIcon("resources/bckground_workout.jpg").getImage().getScaledInstance(550, 405,
			        Image.SCALE_SMOOTH);
			ImageIcon ico = new ImageIcon(img);
			
	    	JButton start =  new JButton("Start");
	    	start.setBounds(319, 326, 75, 25);
			JButton Stop =  new JButton("stop");
			Stop.setBounds(239, 326, 61, 25);
			JLabel animation = new JLabel();
			
			ActionListener l =  new stpl();
			start.addActionListener(l);
			ActionListener s =  new stspl();
			Stop.addActionListener(s);
			
			
			ImageIcon c = new ImageIcon("resources/squats.gif");
			
			animation.setIcon(c);
			
			JPanel panel = new JPanel();
			panel.setLayout(null);
	        
			GridBagConstraints gbc= new GridBagConstraints();
			

			gbc.insets = new Insets(5,5,5,5);	 
			
			panel.add(Stop);
				 
			panel.add(start);
			
			getContentPane().add(panel,BorderLayout.CENTER);
			
			JButton btnBack = new JButton("back");
			btnBack.setBounds(149, 326, 75, 25);
			ActionListener b = new backL();
			btnBack.addActionListener(b);
			panel.add(btnBack);
			
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(149, 48, 228, 263);
			panel.add(panel_1);
			
			JLabel animationE = new JLabel();
			panel_1.add(animationE);
			animationE.setIcon(c);
			
			JLabel bgL = new JLabel("");
			bgL.setIcon(ico);
			bgL.setBounds(0, 0, 550, 405);
			panel.add(bgL);
		}
		public void play(){
	        clip.start();
	    }
	 }
