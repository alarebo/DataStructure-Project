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
	    ImageIcon legIcon = new ImageIcon("resources/legs/leg.gif");
		ImageIcon armIcon = new ImageIcon("resources/arm.gif");
		ImageIcon cardioIcon = new ImageIcon("resources/cardio.gif");
		ImageIcon coreIcon = new ImageIcon("resources/sitUP.gif");
		//with equipment
		ImageIcon legIcon1 = new ImageIcon("resources/Equipment/legEquip.gif");
		ImageIcon armIcon1 = new ImageIcon("resources/Equipment/armEquip.gif");
		ImageIcon coreIcon1 = new ImageIcon("resources/Equipment/coreEquip.gif");
		ImageIcon cardioIcon1 = new ImageIcon("resources/Equipment/cardioEquip.gif");
	    
	    
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
	    
	    public static void music(String fileName) {	      
	    	
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
                	Stackicon(change=20);
                	tStack(change=20);
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
    	  
    	  if(i == 0)	//legs
    	  {
        	  Iconstack.push("legs/butterfly_kick.gif");        	 
        	  Iconstack.push("legs/donkey_kicks.gif"); 
        	  Iconstack.push("legs/superman.gif");  
        	 
        	  return Iconstack;
    	  }
    	  if(i == 1 && Iconstack.isEmpty())	//arms
    	  {
    		  Iconstack.push("horizontal_arm_swing.gif");
    		  Iconstack.push("pushUP.gif");
    		  Iconstack.push("revarmcircles.gif");
    		  
    		  return Iconstack;
    	  }
    	 if(i == 2 && Iconstack.isEmpty()){	//CARDIO
    		 Iconstack.push("cardio.gif");
    		 Iconstack.push("jjacks.gif");
    		 Iconstack.push("burpee.gif");
    		  
    		  return Iconstack;
    	 }
    	 if(i == 3 && Iconstack.isEmpty()){	//CORE
    		 Iconstack.push("sitUP.gif");
    		 Iconstack.push("bike_crunch.gif");
    		 Iconstack.push("bridge.gif");
    		  
    		  return Iconstack;
    	 }
    	 if(i == 4)	//FULL BODY
   	  {
    		 i = 0;
    		 
   	  }
    	 if(i == 5 && Iconstack.isEmpty()){ 	//LEGS W/ EQUIP
    		 Iconstack.push("dumbell_lunge.gif");
    		 Iconstack.push("dumbell_squat.gif");
    		 Iconstack.push("calf_raise.gif");
    		 return Iconstack;
    	 }
    	 if(i == 6 && Iconstack.isEmpty()){ 	//ARMS W/ EQUIP
    		 Iconstack.push("seated_shoulder_press.gif");
    		 Iconstack.push("dumbbell_flat_press.gif");
    		 Iconstack.push("dumbbell_single_rows.gif");
    		 return Iconstack;
    	 }
    	 
    	 if(i == 7 && Iconstack.isEmpty()){ 	//CARDIO W/ EQUIP
    		 Iconstack.push("cardioEquip.gif");
    		 Iconstack.push("elliptical.gif");
    		 Iconstack.push("recumbent_bike.gif");
    		 return Iconstack;
    	 }
    	 if(i == 8 && Iconstack.isEmpty()){ 	//CORE W/ EQUIP
    		 Iconstack.push("coreEquip.gif");
    		 Iconstack.push("side_throw.gif");
    		 Iconstack.push("bridgeEquip.gif");
    		 return Iconstack;
    	 }
    	 if(i == 9 && Iconstack.isEmpty()){ 	//FULL BODY W/ EQUIP
    		 Iconstack.push("");
    		 Iconstack.push("");
    		 Iconstack.push("");
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
    	  
    	  if(i == 0){		//LEGS
    		  textstack.push("Butterfly Kicks: \n\n 1) Both legs should be elevated off the ground.\n 2)Bring one leg up. Hold the other leg in the air.\n 3)Bring one leg up, and the other down. Continue \nthis motion to do buttefly kicks.");
        	  textstack.push("Donkey Kicks: \n\n 1) Get on all fours so that your hands are shoulder\n  width apart and your knees are straight below your hips.\n 2)Bracing your abdominals and keeping your knee bent lift one leg up behind\n you until it is in line with your body and your foot is parallel to the ceiling.\n 3) Lower back down to the starting position and repeat with the other leg.");    	    
        	  textstack.push("Superman: \n\n 1) Lie face down on your stomach with the arms extended\n out in front of you and the legs extended behind you\n 2)In one movement lift the arms and legs up towards the ceiling making a U\n shape\n 3)Make sure that you do not lock out the limbs and keep the core\n as still as possible\n 4)Hold for 2-5 seconds and lower back down to complete 1 rep");
        	  return textstack;
    	  }
    	 
    	  if(i == 1 && textstack.isEmpty()){	//ARMS
        	 textstack.push("Horizontal Arm Swing: \n\n 1) Begin in a standing position. \n\n 2) Cross the arms over the front of the body, then \n swing them back on the horizontal plane. \n\n 3) Alternate the way the arms cross every swing.");
        	 textstack.push("Pushup: \n\n 1)Lie on the floor face down and place your \n hands about 36 inches apart while holding your torso\n up at arms length. \n\n 2) Lower yourself downward until\n your chest almost touches the floor as you inhale. \n\n 3) Now breathe out and press your upper body back \n up to the starting position while squeezing your chest.");    	    
        	 textstack.push("Arm Circles: \n\n 1) Draw large circles with your arms, reaching high\n and back to start. Reverse directions after 30 seconds.");
        	  return textstack;
    	  }
    	 
    	  if(i == 2 && textstack.isEmpty()){	//CARDIO
    		  textstack.push("High Knees: \n\n 1)Stand straight with the feet hip width apart, looking straight ahead \n and arms hanging down by your side. \n\n 2)Jump from one foot to the other at the same time lifting your \n\n knees as high as possible, hip height is advisable. \n\n 3)Touch the ground with the balls of your feet.");
    		  textstack.push("Jumping Jacks: \n\n 1)Stand with your feet together and your hands down by your side. \n\n 2)In one motion, jump your feet out to the side and raise your \n arms above your head. \n\n 3)Immediately reverse that motion by jumping back to the \n starting position.");
    		  textstack.push("Burpee: \n\n 1)Stand with your feet hip width apart and your arms down by your side \n\n 2)Lower into a squat position with your hands flat on the floor in front of you. \n\n 3)Step both legs backwards so you are in a press up position. \n\n 4)Step both legs back in to chest so you are back at a squat position. \n\n 4)Lift up onto the balls of the feet gently with your hands raised above your head.");
    		  return textstack;
    	  }
    	 
    	  if(i == 3 && textstack.isEmpty()){	//CORE
    		  textstack.push("Sit Up: \n\n1)Lie on your back with your knees bent and you feet flat on the floor. \n\n 2)Place your finger tips behind your ears. \n\n 3)Pull your shoulder blades back so your elbows are out to the side. \n\n 4)Brace your abs and then raise your body up towards your knees, \n shoulders should be lifted of the floor. \n\n 5)Head always looking straight, no chin on chest and do not pull the \n head forward. \n\n 6)Roll back down to the starting position.");
    		  textstack.push("Bicycle Crunches: \n\n1)Lie flat on the floor with the lower back pressed into the ground. \n\n 2)Place your hands slightly either side of your head, do not lock your \n fingers or pull the head up. \n\n 3)Lift your knees to a 45 degree angle. \n\n 4)At first slowly go through a bicycle pedal motion with the legs. \n\n 5)Alternately touching your elbows to the opposite knee twisting back and \n forth through the core, keep the elbows back rather \n than forward to the chest as this could strain the neck.");
    		  textstack.push("Bridge: \n\n1)Lie on your back with your knees bent and your feet flat on the floor. \n\n 2)Raise your hips of the floor so that your body forms a straight line \n  from your shoulders to your knees. \n\n 3)Pause at the top then slowly lower your body back to the floor.");
    		  return textstack;
    	  }
    	  if(i == 5 && textstack.isEmpty()){	//legs w/ equipment
    		  textstack.push("Lunge: \n\n Equipment Needed: dumbbells \n\n1)Stand with your torso upright holding two dumbbells in your hands by your sides. This \n will be your starting position. \n\n 2)Step forward with your right leg around 2 feet or so from the foot being left \n stationary behind and lower your upper body down, while keeping \n the torso upright and maintaining balance. Inhale as you go down. \n\n 3)Using mainly the heel of your foot, push up and go back to the starting position \n as you exhale. \n\n Tip: Do not allow your knee to go forward beyond your toes as you come down.");
    		  textstack.push("Squat: \n\n Equipment Needed: dumbbells \n\n1)Stand up straight while holding a dumbbell on each hand. \n\n 2)Position your legs using a shoulder width medium stance with the toes slightly pointed \n  out. Keep your head up at all times as looking down will get you off balance and \n also maintain a straight back. This will be your starting position. \n\n 3)Begin to slowly lower your torso by bending the knees as you maintain a straight \n  posture with the head up. Continue down until your thighs are \n parallel to the floor. \n\n Begin to raise your torso as you exhale by pushing the floor with the heel of your foot \n  mainly as you straighten the legs again and go back to the starting position.");
    		  textstack.push("Calf Raise: \n\n Equipment Needed: dumbbells \n\n1)Sit on the edge of the bench, feet flat on the \n floor about 12 inches apart. \n\n 2)Rest dumbells on thighs while keeping hold of them. \n\n 3)Rest dumbells on thighs while keeping hold of them. \n\n 4)Lower your heels to the ground and repeat.");
    		  return textstack;
    	  }
    	  if(i == 6 && textstack.isEmpty()){	//arms w/equipment
    		  textstack.push("Seated Shoulder Press: \n\n Equipment Needed: dumbbells \n\n 1)While holding a dumbbell in each hand, sit on a military press bench or utility \n bench that has back support. Place the dumbbells upright on top of \n your thighs. \n\n 2)Now raise the dumbbells to shoulder height one at a time using your thighs \n to help propel them up into position. \n\n 3)Make sure to rotate your wrists so that the palms of your hands are facing \n forward. This is your starting position. \n\n 4)Now, exhale and push the dumbbells upward until they touch at the top. \n\n 5)Then, after a brief pause at the top contracted position, slowly lower the weights back down \n to the starting position while inhaling.");
    		  textstack.push("Flat Press: \n\n Equipment Needed: dumbbells, bench \n\n 1)Lying with your back flat on bench, hold the dumbbells directly above \n chest, arms extended. \n\n 2)Lower dumbbells to chest in a controlled manner. \n\n 3)Press dumbbells back to starting position and repeat. \n\n TIP: AVOID LOCKING ELBOWS!");
    		  textstack.push("Single Arm Rows: \n\n Equipment Needed: dumbbells, bench \n\n 1)Stand upright next to bench. Place one knee and \nhand on bench. Upper body should be parallel to \n the floor. \n\n 2)Hold one dumbbell with arm extended. \n\n 3)Raise dumbbell up to your midsection keeping back still throughout \n movement. \n\n 4)Slowly lower dumbbell to start position and repeat. After desired number of reps, \n repeat for other arm.");
    		  return textstack;
    	  }
    	  if(i == 7 && textstack.isEmpty()){ 	//CARDIO W/ EQUIP
     		 textstack.push("Treadmill: \n\n Equipment Needed: treadmill \n\n 1)Start by placing the speed at a comfortable walk. \n If you want, increase the speed until you are into a jog \n or run. \n\n 2)You can also place the treadmill on an incline to increase the \n difficulty.");
     		 textstack.push("Elliptical: \n\n Equipment Needed: equipment \n\n 1)Place your feet on the foot plates and grab the arm handles. \n\n 2)Set your resistance so that it is challenging and start the elliptical \n motion by pulling machine arm with one arm and push the \n other machine arm. \n\n 3)Pick a pace that will elevate your heart rate yet let you stay on  \n the machine for a while.");
     		 textstack.push("Recumbent Bike: \n\n Equipment Needed: \n\n 1)Sit in the seat and adjust the seat so that your knee is slightly \n bent when the pedal is in the farthest position. \n\n 2)Adjust the resistance so that it is challenging yet allows you to keep \n good technique.");
     		 return Iconstack;
     	 }
    	  if(i == 8 && textstack.isEmpty()){ 	//CORE W/ EQUIP
      		 textstack.push("Seated Russian Twists: \n\n Equipment Needed: medicine ball \n\n 1)While seated, suspend your feet off of the ground. \n\n 2)Holding a medicine ball rotate your shoulders side to side touching \n the medicine ball to the ground. (Keep feet off floor)");
      		 textstack.push("Side Throws: \n\n Equipment Needed: medicine ball, wall \n\n 1)Stand with feet hip-width apart; place left foot \n approximately one foot in front of right foot. \n\n 2)Hold medicine ball with both hands and arms only slightly bent. \n\n 3)Swing ball over to the right hip and forcefully underhand toss ball forward \n to the wall (or a partner). Keep the stomach drawn in to \n to maximize proper usage of muscle. \n\n 4)Catch ball on the bounce from your partner or wall and repeat according to \n prescribed repetitions."); 
      		 textstack.push("Ball Plank: \n\n Equipment needed: medicine ball \n\n 1)While on your knees, place hands on a medicine ball. \n\n 2)Align hands at nipple line, place feet hip width apart \n on toes, and extend the arms to raise body up. \n Trunk and hips should be in a straight line. \n\n 3)Hold for 10 seconds. This is one set. Gradually build up \n to 30 seconds plus."); 
      		 return Iconstack;
      	 }
    	  if(i == 9 && textstack.isEmpty()){ 	//FULL BODY W/ EQUIP
       		 textstack.push("");
       		 textstack.push("");
       		 textstack.push("");
       		 return Iconstack;
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
	
