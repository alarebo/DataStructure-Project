import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class WorkOutSelection extends JFrame {
private JLabel Icon1,Icon2,Icon3;
private ImageIcon WorkOut;
private JButton Legs,Arms,Core;
public WorkOutSelection()
{ 
	createButton();
	createPanel();
	createJLabel();
	setSize(400,400);
}	
private void createButton()
{
	Legs = new JButton("Legs");
	Arms = new JButton("Arms");
	Core = new JButton("Core");
}

private void createJLabel()
{
	WorkOut = new ImageIcon("sit-ups-crunches.jpg");//Getting image from workspace src folder//
	Icon1 = new JLabel(); 							//Creating Label//
	Icon2 = new JLabel();
	Icon3 = new JLabel();
	
	Icon1.setIcon(WorkOut);							//Setting up Icon for Labels//
	Icon2.setIcon(WorkOut);
	Icon3.setIcon(WorkOut);
	
}
private void createPanel()
{
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(2, 3));
	panel.add(Legs);
	panel.add(Arms);
	panel.add(Core);
	panel.add(Icon1);
	panel.add(Icon2);
	panel.add(Icon3);
	add(panel);
}
public static void main(String[] args) {
		// TODO Auto-generated method stub
JFrame frame = new WorkOutSelection();
frame.setTitle("WorkOutSelectionPlan");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
		
	}

}
