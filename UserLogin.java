import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class UserLogin extends JFrame 
{

	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 200;
	private JButton ulogin,newUsr;
	private JLabel userN,passWD;
	private JTextField txtuser;
	private JPasswordField pass;
	JPanel panel = new JPanel();
	
	public static void main(String[] args)
	{
	   UserLogin logframe = new  UserLogin();
	   logframe.setTitle("User Authentication");
	   logframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   logframe.setVisible(true);
	}

	
	public UserLogin()
	{
		creatCompenent();
		createPanel();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setBackground(Color.blue);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void creatCompenent() 
	{
		txtuser =  new JTextField(15);
		pass =  new JPasswordField(15);
		
		ulogin = new JButton("Login");
		ulogin.setPreferredSize(new Dimension(145, 20));

		newUsr = new JButton("Create Account");
		newUsr.setPreferredSize(new Dimension(145, 20));

		userN = new JLabel("User Name:");
		passWD  = new JLabel("Password:");
		
		userN.setForeground(Color.RED);
		passWD.setForeground(Color.RED);
		
		ActionListener lg =  new lgnlistener();
		ulogin.addActionListener(lg);
		
		ActionListener ct =  new CreateListener();
		newUsr.addActionListener(ct);

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
			String user = txtuser.getText();
			String pswd = new String(pass.getPassword());

		      if(user.equals("test") && pswd.equals("12345")) 
		      {

		        WorkOutSelection newScreen =new WorkOutSelection();

		        newScreen.setVisible(true);

		        dispose();
		      } 
		      else 
		      {
		        JOptionPane.showMessageDialog(null,"Wrong Password / Username");
		        txtuser.setText("");
		        pass.setText("");
		        txtuser.requestFocus();
		      }
	   
		} 
	 
	}
	private void createPanel()
	{
		JPanel panel = new JPanel();
		GridBagConstraints gbc= new GridBagConstraints();
		panel.setLayout(new GridBagLayout());

		gbc.insets = new Insets(5,5,5,5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		  
		panel.add(userN,gbc);
		 
		gbc.gridy = 0;
		gbc.gridy = 1;
		
		panel.add(passWD,gbc);
		
		gbc.gridx = 5;
		gbc.gridy = 0;
		panel.add(txtuser,gbc);
		
		gbc.gridx = 5;
		gbc.gridy = 1;
		panel.add(pass,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(ulogin,gbc);
		
		gbc.gridx = 5;
		gbc.gridy = 3;
		panel.add(newUsr,gbc);
		
		add(panel);

	}

}
