import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

public class WorkOutSelection extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 900;
	private static final int FRAME_HEIGHT = 400;
	
	private JLabel Icon1,Icon2,Icon3,Icon4,choose;	 
	private ImageIcon WorkOut;
	private JButton Legs,Arms,Core,cardio,Full;

	public WorkOutSelection()
	 { 		 
		createButton();
		createJLabel();
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setBackground(Color.blue);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }

	private void createButton() 
	{
		Legs = new JButton("Legs");
		Legs.setPreferredSize(new Dimension(100, 50));
		Legs.setBackground(Color.RED);
		Legs.setOpaque(true);
		  
		Arms = new JButton("Arms");
		Arms.setPreferredSize(new Dimension(100, 50));
		Arms.setBackground(Color.RED);
		Arms.setOpaque(true);
		

		Core = new JButton("Core");
		Core.setPreferredSize(new Dimension(100, 50));
		Core.setBackground(Color.RED);
		Core.setOpaque(true);
		
		
		Full = new JButton("Full Body");
		Full.setPreferredSize(new Dimension(120, 50));
		Full.setBackground(Color.RED);
		Full.setOpaque(true);
		
		
		cardio = new JButton("Cardio");
		cardio.setPreferredSize(new Dimension(120, 50));
		cardio.setBackground(Color.RED);
		cardio.setOpaque(true);
		  
		// Inizilising ActionListners
		ActionListener listener = new BTNlistener();
		ActionListener listener1 = new BTNlistener1();
		ActionListener listener2 = new BTNlistener2();
		ActionListener listener3 = new BTNlistener3();

		//add the Action listner to the gui
		Legs.addActionListener(listener);
		Arms.addActionListener(listener1); 
		Core.addActionListener(listener2); 
		Full.addActionListener(listener3);	
	  }
	 class BTNlistener implements ActionListener
	 {
		 public void actionPerformed(ActionEvent event)
		 {
			 
		 } 
	 
	 }
	 
	 class BTNlistener1 implements ActionListener
	 {	 
		 public void actionPerformed(ActionEvent event)	  
		 {
			 
		 } 	 
	 }
	 class BTNlistener2 implements ActionListener
	 {	 
		 public void actionPerformed(ActionEvent event)	  
		 {
			 
		 } 	 
	 }
	 class BTNlistener3 implements ActionListener
	 {	 
		 public void actionPerformed(ActionEvent event)	  
		 {
			 
		 } 	 
	 }

	private void createJLabel()
	{
		//Image img = new ImageIcon("resources/leg.png").getImage().getScaledInstance(80, 50, java.awt.Image.SCALE_SMOOTH);//Getting image from workspace src folder//
		ImageIcon img2 = new ImageIcon("resources/arm.gif");
		Image img3 = new ImageIcon("resources/w.png").getImage().getScaledInstance(80, 40, java.awt.Image.SCALE_SMOOTH);


		WorkOut = new ImageIcon("resources/pushUP.gif");
		ImageIcon core1 = new ImageIcon("resources/leg.gif");
		ImageIcon c = new ImageIcon("resources/cardio.gif");
		ImageIcon d = new ImageIcon(img3);



		Icon1 = new JLabel();        //Creating Label//		
		Icon2 = new JLabel();		 
		Icon3 = new JLabel();
		Icon4 = new JLabel();
		choose = new JLabel();		
		choose.setForeground(Color.RED);
		
		Icon1.setIcon(core1);       //Setting up Icon for Labels//
		Icon2.setIcon(img2);
		Icon3.setIcon(WorkOut);
		Icon4.setIcon(c);
		choose.setIcon(d);
		


		
	}

	private void createPanel() 
	{
		JPanel pan = new JPanel();
        JPanel panel = new JPanel();
        
		GridBagConstraints gbc= new GridBagConstraints();
		panel.setLayout(new GridBagLayout());
		 
		panel.setBackground(Color.CYAN);
		pan.setBackground(Color.blue);

		 
		gbc.insets = new Insets(5,5,5,5);
		 
		gbc.gridx = 0;
		gbc.gridx = 0;
		  
		panel.add(choose,gbc);
		 
		gbc.gridy = 0;
		gbc.gridy = 1;

		panel.add(Full,gbc);
		 
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		panel.add(Legs, gbc);
		 
		gbc.gridx = 2;
		gbc.gridy = 0;
		 
		panel.add(Arms,gbc); 
		  
		gbc.gridx = 3;
		gbc.gridy = 0;
		  
		panel.add(Core,gbc);
		 
		gbc.gridx = 1;
		gbc.gridy = 1;
		 
		panel.add(Icon1,gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 0;
		panel.add(cardio);
		 
		gbc.gridx = 2;
		gbc.gridy = 1;
		  
		panel.add(Icon2,gbc);
		  
		gbc.gridx = 3;
		gbc.gridy = 1;
		
		panel.add(Icon3,gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 1;
		
		panel.add(Icon4,gbc);
		
		panel.setBorder(BorderFactory.createLineBorder(Color.blue));
		pan.add(panel,BorderLayout.CENTER);
		add(pan);
	}

	public static void main(String[] args)
	{
	    WorkOutSelection frame = new WorkOutSelection();

	    frame.setTitle("WorkOutSelectionPlan");

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    frame.setVisible(true);
	}
	

}
