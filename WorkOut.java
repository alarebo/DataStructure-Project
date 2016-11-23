import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Stack;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;


	@SuppressWarnings({ "serial", "unused" })
	public class WorkOut extends JFrame {
		static int st=0;
    	Stack<String> Iconstack = new Stack<String>();
    	Stack<String> textstack = new Stack<String>();
    	int change = 0;
    	JTextArea txtArea;

		static String tune = "resources/glutes_music.wav";
	    int counter;
	    JLabel timerLabel,promptLabel,animationE;
	    JButton btnStartWorkout,Exit;
	    Timer timer;
	    String icon = "resources/squats.gif";
	    String stText= "";
	    String stIcon = "";
	    ImageIcon c = new ImageIcon(icon);
	    ImageIcon legIcon = new ImageIcon("resources/leg.gif");
		ImageIcon armIcon = new ImageIcon("resources/arm.gif");
		ImageIcon cardioIcon = new ImageIcon("resources/cardio.gif");
		ImageIcon coreIcon = new ImageIcon("resources/sitUP.gif");
	    
	    
		public static void main(String[] args) 
		{
			WorkOut frame = new WorkOut();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			frame.play();
			frame.Stackicon(st);
			frame.tStack(st);
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
		
		
		 class backL implements ActionListener//the actionListenr for back Button 
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
		 
		 
		 class exitListener implements ActionListener
		 {
			 public void actionPerformed(ActionEvent event)
			 {
				 dispose();
			 }
		 }
		 

		public static void open()
		{
			music(tune);	
		}
	    private static Clip clip;
	    private JTextField tf;
	    public WorkOut() 
	    {
	    	createGui();


	    	setSize(950,650);
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
			
			
	    	JButton start =  new JButton("Start");
	    	start.setBounds(250, 326, 75, 25);
			JButton Stop =  new JButton("stop");
			Stop.setBounds(178, 326, 61, 25);
			
			ActionListener l =  new stpl();
			start.addActionListener(l);
			ActionListener s =  new stspl();
			Stop.addActionListener(s);
			
			
			ImageIcon c = new ImageIcon("resources/squats.gif");
						
			JPanel panel = new JPanel();
			panel.setLayout(null);
	        
			GridBagConstraints gbc= new GridBagConstraints();
			

			gbc.insets = new Insets(5,5,5,5);	 
			
			panel.add(Stop);
				 
			panel.add(start);
			
			
			getContentPane().add(panel,BorderLayout.CENTER);
			
			JButton btnBack = new JButton("back");
			btnBack.setBounds(91, 326, 75, 25);
			ActionListener b = new backL();
			btnBack.addActionListener(b);
			panel.add(btnBack);
			
			
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(149, 48, 228, 263);
			panel.add(panel_1);
			
			animationE = new JLabel();
			panel_1.add(animationE);
			animationE.setIcon(c);
			
			tf = new JTextField();
			tf.setBounds(36, 135, 86, 20);
			panel.add(tf);
			tf.setColumns(10);
			
		    timerLabel = new JLabel("");
			timerLabel.setBounds(36, 208, 86, 25);
			panel.add(timerLabel);
			
		    promptLabel = new JLabel("");
			promptLabel.setBounds(77, 264, 46, 14);
			panel.add(promptLabel);
			
		    btnStartWorkout = new JButton("Start Workout");
			btnStartWorkout.setBounds(21, 88, 101, 36);
			panel.add(btnStartWorkout);
			
		    event e =  new event();
		    btnStartWorkout.addActionListener(e);
		    timerLabel.setForeground(Color.BLACK);
		    tf.setText("0");
		    
		    Exit = new JButton("Exit");
		    Exit.setBounds(152, 364, 97, 25);
		    panel.add(Exit);
		    ActionListener d = new exitListener();
		    Exit.addActionListener(d);
		    
		    
		    txtArea = new JTextArea();
		    txtArea.setEditable(false);
		    txtArea.setText("1)Stand with your head facing forward and your chest held \r\nup and out.\r\n\r\n2Place your feet shoulder-width apart or slightly wider. Extend\r\n your hands straight out in front of you to help keep your\r\n balance. You can also bend the elbows or clasp the fingers.\r\n\r\n3)Sit back and down like you're sitting into an imaginary chair.\r\n Keep your head facing forward as your upper body bends\r\n forward a bit. Rather than allowing your back to round, let your\r\n lower back arch slightly as you descend.\r\n\r\n4)Lower down so your thighs are as parallel to the floor as possible,\r\n with your knees over your ankles. Press your weight back into your\r\n heels.\r\n\r\n5)Keep your body tight, and push through your heels to bring yourself\r\n back to the starting position.");
		    txtArea.setBounds(395, 63, 555, 385);
		    panel.add(txtArea);
		}
		public void play(){
	        clip.start();
	    }
	 
	
    
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int count = (int)(Double.parseDouble(tf.getText()));
            timerLabel.setText("Time left: " + count);
            TimeClass tc = new TimeClass(count);
            timer = new Timer(1000, tc);
            timer.start();
            String b = timerLabel.getText();
            if(b == "done")
            {
            	
            }
        }
    }
    
    public class TimeClass implements ActionListener 
    {
        int counter;
        
        public TimeClass(int counter) 
        {
            this.counter= counter;
        }
        public void actionPerformed(ActionEvent tc) 
        {
    	    String path = "resources/";
    	    String done = "Done!";
            counter--;
            if(counter >= 1) {
                timerLabel.setText("Time left: " + counter);
            }
            else
            {
            	change++;
                timer.stop();
                timerLabel.setText("Done!");
                Toolkit.getDefaultToolkit().beep();
                if(done == timerLabel.getText())
                {
                	Stackicon(change);
                	tStack(change);
                	icon= path+stIcon;
                	c=new ImageIcon(icon);
                	animationE.setIcon(c);
                	txtArea.setText(stText);
                }
                
            }
         
         }
      }
      public Stack <String> Stackicon(int i)
      {
    	  
    	  if(i == 0)
    	  {
        	  Iconstack.push("butterfly_kick.gif");        	 
        	  Iconstack.push("donkey_kicks.gif"); 
        	  Iconstack.push("superman.gif");  
        	 
        	  return Iconstack;
    	  }
    	  
    	  if(change > 0){
    		  if(!Iconstack.isEmpty()){
    		  stIcon = Iconstack.pop();
    		
    		  
    		  }else{
    			  WorkOutSelection bckk = new WorkOutSelection();
    		  		bckk.setVisible(true);
    		  		dispose();
    		  }
    	  }
		return Iconstack;
		
      }
      public Stack <String> tStack(int i)
      {
    	  
    	  if(i == 0)
    	  {
        	 
        	 textstack.push("1) Both legs should be elevated off the ground.\n 2)Bring one leg up. Hold the other leg in the air.\n 3)Bring one leg up, and the other down. Continue \nthis motion to do buttefly kicks.");
        	  textstack.push("1) Get on all fours so that your hands are shoulder\n  width apart and your knees are straight below your hips.\n 2)Bracing your abdominals and keeping your knee bent lift one leg up behind\n you until it is in line with your body and your foot is parallel to the ceiling.\n 3) Lower back down to the starting position and repeat with the other leg.");    	    
        	  textstack.push("1) Lie face down on your stomach with the arms extended\n out in front of you and the legs extended behind you\n 2)In one movement lift the arms and legs up towards the ceiling making a U\n shape\n 3)Make sure that you do not lock out the limbs and keep the core\n as still as possible\n 4)Hold for 2-5 seconds and lower back down to complete 1 rep");
        	  return textstack;
    	  }
    	  
    	  if(change > 0){
    		  if(!textstack.isEmpty()){
    		  
    		  stText = textstack.pop();
    		  
    		  }else{
    			  WorkOutSelection bckk = new WorkOutSelection();
    		  		bckk.setVisible(true);
    		  		dispose();
    		  }
    	  }
		return textstack;
		
      }
   }
	
