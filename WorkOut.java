import sun.audio.*;
//http://stackoverflow.com/questions/11919009/using-javax-sound-sampled-clip-to-play-loop-and-stop-mutiple-sounds-in-a-game
import java.io.FileInputStream;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class WorkOut extends JFrame
{
	String song = "";
	private JLabel animation;
	private JButton play,stop;
	boolean start =false;
	
	public static void main(String [] args)
	{
		WorkOut f =  new WorkOut();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public WorkOut()
	{
		createGui();   
		createGui();
		createPanel();
		
	   	setTitle(" Work Out");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        createGui();   
		createGui();
		createPanel();
	}

	private void createGui() 
	{
		play =  new JButton("Play");
		stop = new JButton("Stop");
		ActionListener pl = new startListner();
		ActionListener st = new stopListner();
		play.addActionListener(pl);
		stop.addActionListener(st);
		animation = new JLabel();
		
		ImageIcon img =  new ImageIcon("resources/leg.jpg");
		animation.setIcon(img);
	}
	class startListner implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			start =true;
			music();
		}
	}
	class stopListner implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			start = false;
			music();
		}
	}
	@SuppressWarnings("restriction")
	public void music()
	{
		AudioPlayer player = AudioPlayer.player;
		AudioStream stream;
		AudioData audio;
		ContinuousAudioDataStream loop = null;
		
		try
		{
			stream =  new AudioStream(new FileInputStream(song));
			audio = stream.getData();
			loop = new ContinuousAudioDataStream(audio);
			if(start=false)
			{
				player.stop(loop);				
			}
			else
			{
				player.start(loop);
			}
		}
		catch(IOException error)
		{
			
		}
		
	}
	private void createPanel() 
	{
		JPanel panel = new JPanel();
        
		GridBagConstraints gbc= new GridBagConstraints();
		panel.setLayout(new GridBagLayout());
		 
		panel.setBackground(Color.CYAN);
		 
		gbc.insets = new Insets(5,5,5,5);
		 
		gbc.gridx = 0;
		gbc.gridx = 0;
		  
		panel.add(play,gbc);
		 
		gbc.gridy = 0;
		gbc.gridy = 1;

		panel.add(stop,gbc);
		
		add(panel);
	}

}
