import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class NewUser extends JFrame {
	
	Image ic = new ImageIcon("resources/background.jpg").getImage().getScaledInstance(80, 40, java.awt.Image.SCALE_SMOOTH);
	ImageIcon bcGround = new ImageIcon(ic);

	String gender;
	public static void main(String[] args) 
	{
		NewUser frame = new NewUser();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
	 
	JTextField name = new JTextField(15);
    JTextField weight = new JTextField(5);
    JTextField height = new JTextField(5);
    JTextField age = new JTextField(15);
    JTextField in = new JTextField(15);

    JTextField username = new JTextField(15);
    JPasswordField passWord = new JPasswordField(15);
    JTextField bmi = new JTextField(15);
    JLabel userL = new JLabel(" User Name:");
    JLabel passL = new JLabel("Password:");
    JLabel heightL = new JLabel("Hieght");
    JLabel nameL = new JLabel("Name:");
    JLabel ageL = new JLabel("Age:");
    JLabel ft = new JLabel("ft");
    JLabel inl = new JLabel("in");	  

    JLabel weightL = new JLabel("Weight:");	  
    JLabel bmiL = new JLabel("Body mass index (BMI):");
    JButton bmical = new JButton("BMI Calcator");
    JButton create = new JButton("Create Account");
    JRadioButton male = new JRadioButton("Male", false);
    JRadioButton female = new JRadioButton("Female", false);
    
 
    
   private JPanel panel = new JPanel();
	
	//Creating GUI FOR USER info
    NewUser()
    {     
    	super("Create Account");
        setSize(500,500);
        setLocation(500,480);
        setVisible(true);
        panel.setLayout (null); 
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createGui();      
        panel.add(username);
        panel.add(name);
        panel.add(passL); 
        panel.add(passWord);        
        panel.add(userL);
        panel.add(nameL);
        panel.add(weight);  
        panel.add(weightL);
        panel.add(height);    
        panel.add(heightL);
        panel.add(bmi);
        panel.add(bmical);    
        panel.add(bmiL); 
        panel.add(create);
        panel.add(male);
        panel.add(female);
        panel.add(inl);
        panel.add(in);
        panel.add(ft);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(58, 183, 56, 16);
        panel.add(lblGender);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 202, 220, 35);
        panel.add(separator);
        panel.repaint();



    }

	private void createGui()
	{
		//setting the position of gui
	    name.setBounds(58,32,150,20);
	    username.setBounds(90,65,126,20);
	    passWord.setBounds(292,65,120,20);
	    weight.setBounds(66,100,150,20);
	    height.setBounds(58,125,40,20);
	    in.setBounds(128,125,40,20);
	    ft.setBounds(103,125,40,20);
	    inl.setBounds(173,125,40,20);

	    bmi.setBounds(155,150,75,20);
	    bmiL.setBounds(15,150,140,20);
	    bmical.setBounds(249,150,105,20);
	    weightL.setBounds(15,100,150,20);
	    heightL.setBounds(15,125,51,20);
	    nameL.setBounds(15,30,150,20);
	    userL.setBounds(10,65,80,20);
	    passL.setBounds(228,65,69,20);
	    create.setBounds(15,250,150,20);
	    ActionListener usr = new userInfo();
	    create.addActionListener(usr);
	    
	    ActionListener GEN = new genderLST2();
	    male.addActionListener(GEN);
	    
	    ActionListener GEN2 = new genderLST();
	    female.addActionListener(GEN2);
	   
	    
	    male.setBounds(11, 208, 55, 25);
	    female.setBounds(80, 208, 75, 25);

	    ButtonGroup group = new ButtonGroup();
	    group.add(male);
	    group.add(female);


	    in.setText("0");
	    bmi.setText("0");
	    weight.setText("0");
	    height.setText("0");
	    ActionListener bt = new bmiListener();
	    bmical.addActionListener(bt);
	    panel.repaint();
	}
	class bmiListener implements ActionListener
	{
		//calculate the users Body Mass index
		public void actionPerformed(ActionEvent event)	
		{
		    String wieght = weight.getText();
		    String i = in.getText();
		    double inch = Double.parseDouble(i);
		    double w = Double.parseDouble(wieght);
		    String n = height.getText(); 
		    Double h = Double.parseDouble(n);
		    
			if(wieght.equals("0") || n.equals("0")|| wieght.equals(""))
			{
				JOptionPane.showMessageDialog(null,"please enter wieght in pounds and  your height to calulate bmi");
			}
			else
			{
				h = h*12+inch;
				double result = w*703/(h*h)*10;	
				result = Math.round(result);
				result = result/10;
				String b = Double.toString(result);
				bmi.setText(b);
			}
		}
	}
	 class userInfo implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		//user info is entered into the database
		{
			//String Name = name.getText();
			//String UserName = username.getText();
			//String PassWord = new String(passWord.getPassword());
			UserLogin lg = new UserLogin();
			lg.setVisible(true);
			dispose();
			JOptionPane.showMessageDialog(null,"account Created "+gender);

			
			
		}
		
	}
	 
	 class genderLST implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 gender="female";
			 
		 }	
	 }
	 class genderLST2 implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 gender="male";
			 
		 }	
	 }
 }
		
  
