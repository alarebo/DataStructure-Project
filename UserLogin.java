import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class UserLogin extends JFrame 
{

	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 200;
	private JButton ulogin,newUsr;
	private JLabel userN,passWD,errorLabel;
	private JTextField txtuser;
	private JPasswordField pass;
	JPanel panel = new JPanel();
	private JLabel bcLabel;
	String user =" ";
	String u="test",p="12345";
	
	public static void main(String[] args)
	{
	   UserLogin logframe = new  UserLogin();
	   logframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   logframe.setVisible(true);
	}
	
	public UserLogin()
	{
		setResizable(false);
		setTitle("User Authentication");
		createCompenent();
		createPanel();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setBackground(Color.blue);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createCompenent() 
	{

		txtuser =  new JTextField(15);
		txtuser.setBounds(132, 29, 171, 22);
		pass =  new JPasswordField(15);
		pass.setBounds(132, 58, 171, 22);
		
		ulogin = new JButton("Login");
		ulogin.setBounds(208, 120, 145, 20);
		ulogin.setPreferredSize(new Dimension(145, 20));

		newUsr = new JButton("Create Account");
		newUsr.setBounds(43, 120, 145, 20);
		newUsr.setPreferredSize(new Dimension(145, 20));

		userN = new JLabel("User Name:");
		userN.setBounds(56, 32, 68, 16);
		passWD  = new JLabel("Password:");
		passWD.setBounds(56, 61, 68, 16);
		
		ActionListener lg =  new lgnlistener();
		ulogin.addActionListener(lg);
		
		ActionListener ct =  new CreateListener();
		newUsr.addActionListener(ct);
		
        userN.setForeground(Color.WHITE);
        passWD.setForeground(Color.WHITE);

	}
	class CreateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			 NewUser regFace =new NewUser();
			 dispose();
			 regFace.setVisible(true);
		}

	}

	class lgnlistener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String pswd = new String(pass.getPassword());
			user = txtuser.getText();


		      if(user.equals(u) && pswd.equals(p)) 
		      {

		        LoadingWindow newScreen =new LoadingWindow();
		        newScreen.setVisible(true);
		        newScreen.userTEXT(user);
		        newScreen.setTitle("LOADING....");
				Timer timer = new Timer(6000, new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	newScreen.dispose();
				        WorkOutSelection f = new WorkOutSelection();
				        f.setVisible(true);
				        }
				    });
			    timer.setRepeats(false);
			    timer.start();
		        dispose();
		      } 
		      else 
		      {
		        errorLabel.setText("Wrong Password / Username");	
		        errorLabel.setForeground(Color.RED);

		        
		        txtuser.setText("");
		        pass.setText("");
		        txtuser.requestFocus();
		      }
	   
		} 
	 
	}
	private void createPanel()
	{
		Image img =  new ImageIcon("resources/background.jpg").getImage().getScaledInstance(394, 165,
		        Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(userN);
		panel.add(passWD);
		panel.add(txtuser);
		panel.add(pass);
		panel.add(ulogin);
		panel.add(newUsr);
		
		getContentPane().add(panel);
		
	    errorLabel = new JLabel("");
		errorLabel.setBounds(66, 90, 248, 17);
		panel.add(errorLabel);
		
		bcLabel = new JLabel("");
		bcLabel.setIcon(icon);
		bcLabel.setBounds(0, 0, 394, 165);
		panel.add(bcLabel);

	}
}
