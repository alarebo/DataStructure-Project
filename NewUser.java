import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class NewUser extends JFrame {

	public static void main(String[] args) 
	{
		NewUser frame = new NewUser();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
	 
	JTextField name = new JTextField(15);
    JTextField weight = new JTextField(5);
    JTextField height = new JTextField(5);
    JTextField age = new JTextField(15);
    JTextField username = new JTextField(15);
    JPasswordField passWord = new JPasswordField(15);
    JTextField bmi = new JTextField(15);
    JLabel userL = new JLabel(" User Name:");
    JLabel passL = new JLabel("Password:");
    JLabel heightL = new JLabel("Hieght");
    JLabel nameL = new JLabel("Name:");
    JLabel ageL = new JLabel("Age:");	  
    JLabel weightL = new JLabel("Weight:");	  
    JLabel bmiL = new JLabel("Body mass index (BMI):");
    JButton bmical = new JButton("BMI Calcator");
    JButton create = new JButton("Create Account");
    JRadioButton male = new JRadioButton("Male?", false);
    JRadioButton female = new JRadioButton("Female?", false);
    
 
    
   private JPanel panel = new JPanel();
	
	//Creating GUI FOR USER info
    NewUser()
    {     
    	super("Create Account");
        setSize(500,500);
        setLocation(500,480);
        panel.setLayout (null); 
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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
    }

	private void createGui()
	{
		//setting the position of gui
	    name.setBounds(80,30,150,20);
	    username.setBounds(80,65,150,20);
	    passWord.setBounds(310,65,150,20);
	    weight.setBounds(80,100,150,20);
	    height.setBounds(80,125,150,20);
	    bmi.setBounds(150,150,80,20);
	    bmiL.setBounds(15,150,150,20);
	    bmical.setBounds(250,145,150,20);
	    weightL.setBounds(15,100,150,20);
	    heightL.setBounds(15,125,150,20);
	    nameL.setBounds(15,30,150,20);
	    userL.setBounds(10,65,150,20);
	    passL.setBounds(240,65,150,20);
	    create.setBounds(15,250,150,20);
	    ActionListener usr = new userInfo();
	    create.addActionListener(usr);
	   
	    
	    male.setBounds(20, 200, 80, 50);
	    female.setBounds(80, 200, 80, 50);

	    ButtonGroup group = new ButtonGroup();
	    group.add(male);
	    group.add(female);


	    
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
		    Double w = Double.parseDouble(wieght);
		    String n = height.getText(); 
		    Double h = Double.parseDouble(n);
		    
			if(wieght.equals("0") || n.equals("0")|| wieght.equals(""))
			{
				JOptionPane.showMessageDialog(null,"please enter wieght pounds and  your height to calulate bmi");
			}
			else
			{
				h = h*12;
				double result = ((w/h)*1/h*703)*100;	
				result = Math.round(result);
				result = result/100;
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
			JOptionPane.showMessageDialog(null,"account Created");

			
			
		}
		
	}
}
		
  