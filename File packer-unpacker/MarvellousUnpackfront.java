import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarvellousUnPackFront extends Template implements ActionListener
{
	JButton SUBMIT, PREVIOUS;
	JLabel label1,label2, title;
	final JTextField text1;
	
	public MarvellousUnPackFront()
	{
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		title = new JLabel("UnPacking Portal");
		Dimension size = title.getPreferredSize();
		title.setBounds(40,50,size.width + 60,size.height);
		title.setFont(new Font("Century",Font.BOLD,17));
		title.setForeground(Color.BLUE);
		
		label1 = new JLabel();
		label1.setText("File name");
		label1.setForeground(Color.WHITE);
		label1.setBounds(350,50,size.width,size.height);
		
		text1 = new JTextField(15);
		Dimension tsize = text1.getPreferredSize();
		text1.setBounds(500,50,tsize.width,tsize.height);
		text1.setToolTipText("Enter name of directory");
		
		SUBMIT = new JButton("Extract Here");
		Dimension bsize = SUBMIT.getPreferredSize();
		SUBMIT.setBounds(350,200,bsize.width,bsize.height);
		SUBMIT.addActionListener(this);
		
		PREVIOUS = new JButton("PREVIOUS");
		Dimension b2size = PREVIOUS.getPreferredSize();
		PREVIOUS.setBounds(500,200,b2size.width,b2size.height);
		PREVIOUS.addActionListener(this);
		
		_header.add(this);
		_content.add(label1);
		_content.add(text1);
		_content.add(SUBMIT);
		_content.add(PREVIOUS);
		
		this.setSize(1000,400);
		this.setResizable(false);
		this.setVisible(true);
		text1.requestFocusInWindow();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == exit)
		{
			this.setVisible(false);
			System.exit(0);
		}
		if(ae.getSource() == minimise)
		{
			this.setState(this.ICONIFIED);
		}
		if(ae.getSource() == SUBMIT)
		{
			try
			{
				MarvellousUnPack obj = new MarvellousUnPack(text1.getText());
				this.dispose();
				NextPage t = new NextPage("admin");
			}
			catch(InvalidFileException obj)
			{
				this.setVisible(false);
				this.dispose();
				
				JOptionPane.showMessageDialog(this,"Invalid Packed File","Error",JOptionPane.ERROR_MESSAGE);
				
				NextPage t = new NextPage("MarvellousAdmin");
			}
			catch(Exception e)
			{}
		}
		if(ae.getSource() == PREVIOUS)
		{
			this.setVisible(false);
			this.dispose();
			NextPage t = new NextPage("admin");
		}
	}
}