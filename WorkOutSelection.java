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
		Image leggo =  new ImageIcon("resources/leg.jpg").getImage().getScaledInstance(114, 159,
		        Image.SCALE_SMOOTH);
		Image armmo = new ImageIcon("resources/arm.jpg").getImage().getScaledInstance(114, 159,
		        Image.SCALE_SMOOTH);
		Image coreeo = new ImageIcon("resources/sitUP.jpg").getImage().getScaledInstance(114, 159,
		        Image.SCALE_SMOOTH);
		Image cardioh = new ImageIcon("resources/cardio.jpg").getImage().getScaledInstance(114, 159,
		        Image.SCALE_SMOOTH);


		ImageIcon legIcon = new ImageIcon("resources/leg.gif");
		ImageIcon armIcon = new ImageIcon("resources/arm.gif");
		ImageIcon coreIcon = new ImageIcon("resources/pushUp.gif");
		ImageIcon cardioIcon = new ImageIcon("resources/cardio.gif");

		
		ImageIcon icon = new ImageIcon(img);
		
		
		JPanel eqpPanel = new JPanel();
		tabbedPane.addTab("With Equipment", null, eqpPanel, null);
		eqpPanel.setLayout(null);
		
		JButton button = new JButton("Full Workout");
		button.setBounds(10, 131, 111, 34);
		eqpPanel.add(button);
		
		JButton button_1 = new JButton("Legs");
		button_1.setBounds(150, 24, 97, 25);
		eqpPanel.add(button_1);
		
		JButton button_2 = new JButton("Arms");
		button_2.setBounds(295, 24, 97, 25);
		eqpPanel.add(button_2);
		
		JButton button_3 = new JButton("Cardio");
		button_3.setBounds(440, 24, 97, 25);
		eqpPanel.add(button_3);
		
		JButton button_4 = new JButton("Core");
		button_4.setBounds(585, 24, 97, 25);
		eqpPanel.add(button_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(131, 51, 582, 199);
		eqpPanel.add(panel_2);
		
		JLabel label = new JLabel("");
		label.setBounds(155, 11, 114, 159);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(303, 11, 114, 159);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(447, 11, 114, 159);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(10, 11, 114, 159);
		panel_2.add(label_3);
		
		
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
		Leg.setBounds(150, 23, 97, 25);
		panel.add(Leg);
		
		JButton Arms = new JButton("Arms");
		Arms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Arms.setBounds(295, 23, 97, 25);
		panel.add(Arms);
		
		JButton Cardio = new JButton("Cardio");
		Cardio.setBounds(440, 23, 97, 25);
		panel.add(Cardio);
		
		JButton Core = new JButton("Core");
		Core.setBounds(585, 23, 97, 25);
		panel.add(Core);
		
		JButton Full = new JButton("Full Workout");
		Full.setBounds(10, 130, 111, 34);
		panel.add(Full);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(131, 50, 582, 199);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel armL = new JLabel("");
		armL.setBounds(155, 11, 114, 159);
		panel_1.add(armL);
		
		JLabel cardioL = new JLabel("");
		cardioL.setBounds(303, 11, 114, 159);
		panel_1.add(cardioL);
		
		JLabel coreL = new JLabel("");
		coreL.setBounds(447, 11, 114, 159);
		panel_1.add(coreL);
		
		
		JLabel legL = new JLabel("");
		legL.setBounds(10, 11, 114, 159);
		panel_1.add(legL);
		legL.setIcon(legIcon);
		getContentPane().add(tabbedPane);
		
		
		legL.setIcon(new ImageIcon (leggo));
		coreL.setIcon(new ImageIcon (coreeo));
		cardioL.setIcon(new ImageIcon (cardioh));
		armL.setIcon(new ImageIcon (armmo));
	}
	public static void main(String[] args)
	{
	    WorkOutSelection frame = new WorkOutSelection();

	    frame.setTitle("WorkOutSelectionPlan");

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    frame.setVisible(true);
	}
}
