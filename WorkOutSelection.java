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
import java.awt.Color;

@SuppressWarnings("serial")
public class WorkOutSelection extends JFrame{
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	public WorkOutSelection() {
		setResizable(false);
		setTitle("Workout Selection");
		
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
		
		//W/out equipment icons

		Image leggo =  new ImageIcon("resources/leg.jpg").getImage().getScaledInstance(114, 159,
		        Image.SCALE_SMOOTH);
		Image armmo = new ImageIcon("resources/arm.jpg").getImage().getScaledInstance(114, 159,
		        Image.SCALE_SMOOTH);
		Image coreeo = new ImageIcon("resources/sitUP.jpg").getImage().getScaledInstance(114, 159,
		        Image.SCALE_SMOOTH);
		Image cardioh = new ImageIcon("resources/cardio.jpg").getImage().getScaledInstance(114, 159,
		        Image.SCALE_SMOOTH);
		//Equipment Icons
		Image leggE =  new ImageIcon("resources/Equipment/legEquip.jpg").getImage().getScaledInstance(114, 159,
		        Image.SCALE_SMOOTH);
		Image armmE = new ImageIcon("resources/Equipment/armEquip.jpg").getImage().getScaledInstance(114, 159,
		        Image.SCALE_SMOOTH);
		Image coreeE = new ImageIcon("resources/Equipment/coreEquip.jpg").getImage().getScaledInstance(114, 159,
		        Image.SCALE_SMOOTH);
		Image cardiooE = new ImageIcon("resources/Equipment/cardioEquip.jpg").getImage().getScaledInstance(114, 159,
		        Image.SCALE_SMOOTH);

	

		//w/out equipment
		ImageIcon legIcon = new ImageIcon("resources/leg.gif");				
		
		JPanel eqpPanel = new JPanel();
		tabbedPane.addTab("With Equipment", null, eqpPanel, null);
		eqpPanel.setLayout(null);
		Image bcground = new ImageIcon("resources/bcgselection.jpg").getImage().getScaledInstance(778, 395,
		        Image.SCALE_SMOOTH);
		Image im = new ImageIcon("resources/inframe.png").getImage().getScaledInstance(651, 252,
		        Image.SCALE_SMOOTH);
		ImageIcon inW = new ImageIcon(im);

		

		
		//creates an action listener for legs
		JButton legB = new JButton("Legs");
		legB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkOut a = new WorkOut();
				a.animationE.setIcon(a.legIcon1);
				a.txtArea.setText(a.legText1);
				a.Stackicon(5);
				a.tStack(5);
				a.setTitle("Leg Workout w/ Equipment");
				a.setVisible(true);
				dispose();
			}
		});
		legB.setBounds(150, 24, 97, 25);
		eqpPanel.add(legB);
		
		JButton armB = new JButton("Arms");
		armB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkOut b = new WorkOut();
				b.animationE.setIcon(b.armIcon1);
				b.txtArea.setText(b.armText1);
				b.Stackicon(6);
				b.tStack(6);
				b.setTitle("Arms Workout w/ Equipment");
				b.setVisible(true);
				dispose();
			}
		});
		armB.setBounds(295, 24, 97, 25);
		eqpPanel.add(armB);
		
		JButton cardioB = new JButton("Cardio");
		cardioB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkOut c = new WorkOut();
				c.animationE.setIcon(c.cardioIcon1);
				c.txtArea.setText(c.cardioText1);
				c.Stackicon(7);
				c.tStack(7);
				c.setTitle("Cardio Workout w/ Equipment");
				c.setVisible(true);
				dispose();
			}
		});
		cardioB.setBounds(440, 24, 97, 25);
		eqpPanel.add(cardioB);
		
		JButton coreB = new JButton("Core");
		coreB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkOut d = new WorkOut();
				d.animationE.setIcon(d.coreIcon1);
				d.txtArea.setText(d.coreText1);
				d.Stackicon(8);
				d.tStack(8);
				d.setTitle("Core Workout w/ Equipment");
				d.setVisible(true);
				dispose();
			}
		});
		coreB.setBounds(585, 24, 97, 25);
		eqpPanel.add(coreB);
		
		JButton fullB = new JButton("Full Workout");
		fullB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkOut x = new WorkOut();
				x.animationE.setIcon(x.fullIcon);
				x.txtArea.setText(x.fullText1);
				x.Stackicon(9);
				x.tStack(9);
				
				x.setTitle("Full Workout w/ Equipment");
				x.setVisible(true);
				dispose();
			}
		});
		fullB.setBounds(10, 131, 111, 34);
		eqpPanel.add(fullB);
		
		JLabel icL = new JLabel("");
		icL.setBounds(103, 24, 651, 252);
		icL.setIcon(inW);
		eqpPanel.add(icL);
		
		
		JPanel insidePanel = new JPanel();
		insidePanel.setBackground(Color.gray);

		insidePanel.setForeground(Color.BLACK);
		insidePanel.setLayout(null);
		//insidePanel.setOpaque(false);
		insidePanel.setBounds(131, 51, 582, 199);
		eqpPanel.add(insidePanel);
		
		JLabel armE = new JLabel("");
		armE.setBounds(155, 11, 114, 159);
		insidePanel.add(armE);
		
		JLabel cardioE = new JLabel("");
		cardioE.setBounds(303, 11, 114, 159);
		insidePanel.add(cardioE);
		
		JLabel coreE = new JLabel("");
		coreE.setBounds(447, 11, 114, 159);
		insidePanel.add(coreE);
		
		JLabel legE = new JLabel("");
		legE.setBounds(10, 11, 114, 159);
		insidePanel.add(legE);
		
		legE.setIcon(new ImageIcon (leggE));
		coreE.setIcon(new ImageIcon (coreeE));
		cardioE.setIcon(new ImageIcon (cardiooE));
		armE.setIcon(new ImageIcon (armmE));
		ImageIcon ic = new ImageIcon(bcground);
		
		JLabel bcgLabel = new JLabel("");
		bcgLabel.setBounds(0, 0, 778, 395);
		bcgLabel.setIcon(ic);
		eqpPanel.add(bcgLabel);
	
		
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
				f.txtArea.setText(f.legText);
				f.Stackicon(0);
				f.tStack(0);
				f.setVisible(true);
				dispose();
			}
		});
		Leg.setBounds(150, 23, 97, 25);
		panel.add(Leg);
		
		JButton Arms = new JButton("Arms");
		Arms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkOut g = new WorkOut();
				g.animationE.setIcon(g.armIcon);
				g.txtArea.setText(g.armText);
				g.Stackicon(1);
				g.tStack(1);
				g.setTitle("Arm Workout");
				g.setVisible(true);
				dispose();
			}
		});
		Arms.setBounds(295, 23, 97, 25);
		panel.add(Arms);
		
		
		JButton Cardio = new JButton("Cardio");
		Cardio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkOut h = new WorkOut();
				h.animationE.setIcon(h.cardioIcon);
				h.txtArea.setText(h.cardioText);
				h.Stackicon(2);
				h.tStack(2);
				h.setTitle("Cardio Workout");
				h.setVisible(true);
				dispose();
			}
		});
		Cardio.setBounds(440, 23, 97, 25);
		panel.add(Cardio);
		
		
		JButton Core = new JButton("Core");
		Core.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkOut i = new WorkOut();
				i.animationE.setIcon(i.coreIcon);
				i.txtArea.setText(i.coreText);
				i.Stackicon(3);
				i.tStack(3);
				i.setTitle("Core Workout");
				i.setVisible(true);
				dispose();
			}
		});
		Core.setBounds(585, 23, 97, 25);
		panel.add(Core);
		
		
		JButton Full = new JButton("Full Workout");
		Full.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkOut j = new WorkOut();
				j.animationE.setIcon(j.fullIcon);
				j.txtArea.setText(j.fullText);
				j.Stackicon(4);
				j.tStack(4);
				j.setTitle("Full Body Workout");
				j.setVisible(true);
				dispose();
			}
		});
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
