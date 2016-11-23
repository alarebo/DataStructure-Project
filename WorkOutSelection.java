import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class WorkOutSelection extends JFrame{
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	public WorkOutSelection() {
		setTitle("Workout Seclection");
		
		setSize(789,460);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		EqipmentPanel();
		createPanel();

	}
	private void EqipmentPanel() 
	{

		
	}
	private void createPanel() 
	{
		
		Image img =  new ImageIcon("resources/bckground_workout.jpg").getImage().getScaledInstance(607, 373,
		        Image.SCALE_SMOOTH);



		ImageIcon legIcon = new ImageIcon("resources/leg.gif");
		ImageIcon armIcon = new ImageIcon("resources/arm.gif");
		ImageIcon coreIcon = new ImageIcon("resources/pushUp.gif");
		ImageIcon cardioIcon = new ImageIcon("resources/cardio.gif");

		
		ImageIcon icon = new ImageIcon(img);
		
		
		JPanel eqpPanel = new JPanel();
		tabbedPane.addTab("With Equipment", null, eqpPanel, null);
		eqpPanel.setLayout(null);
		
		JButton leg = new JButton("Legs");
		leg.setBounds(93, 13, 83, 25);
		eqpPanel.add(leg);
		
		JButton arm = new JButton("Arms");
		arm.setBounds(185, 13, 83, 25);
		eqpPanel.add(arm);
		
		JButton cardio = new JButton("Cardio");
		cardio.setBounds(280, 13, 97, 25);
		eqpPanel.add(cardio);
		
		JButton coreW = new JButton("Core");
		coreW.setBounds(395, 13, 97, 25);
		eqpPanel.add(coreW);
		
		JButton fullB = new JButton("Full Workout");
		fullB.setBounds(12, 74, 83, 25);
		eqpPanel.add(fullB);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(12, 127, 83, 25);
		eqpPanel.add(button_5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(103, 47, 423, 2);
		eqpPanel.add(separator_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(103, 51, 423, 188);
		eqpPanel.add(panel_3);
		
		
		//
		
		//leg.setIcon(legIcon);
		//arm.setIcon(armIcon);
		//coreW.setIcon(coreIcon);
		//cardio.setIcon(cardioIcon);
		
		
		
		
		
		//first tabbed panel
		JPanel panel = new JPanel();
		tabbedPane.addTab("Without Equipment", null, panel, null);
		panel.setLayout(null);
		
		JButton Leg = new JButton("Legs");
		Leg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				WorkOut f = new WorkOut();
				f.animationE.setIcon(f.legIcon);
				f.Stackicon(0);
				f.setVisible(true);
				dispose();
			}
		});
		Leg.setBounds(150, 23, 83, 25);
		panel.add(Leg);
		
		JButton Arms = new JButton("Arms");
		Arms.setBounds(270, 23, 118, 25);
		panel.add(Arms);
		
		JButton Cardio = new JButton("Cardio");
		Cardio.setBounds(432, 23, 97, 25);
		panel.add(Cardio);
		
		JButton Core = new JButton("Core");
		Core.setBounds(600, 23, 97, 25);
		panel.add(Core);
		
		JButton Full = new JButton("Full Workout");
		Full.setBounds(12, 65, 107, 25);
		panel.add(Full);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(12, 159, 107, 25);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(131, 50, 582, 199);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(147, 0, 135, 175);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(294, 0, 135, 175);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(447, 0, 135, 175);
		panel_1.add(label_2);
		
		
		JLabel legL = new JLabel("");
		legL.setBounds(12, 0, 135, 175);
		panel_1.add(legL);
		legL.setIcon(legIcon);
		getContentPane().add(tabbedPane);
	}
	public static void main(String[] args)
	{
	    WorkOutSelection frame = new WorkOutSelection();

	    frame.setTitle("WorkOutSelectionPlan");

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    frame.setVisible(true);
	}
}
