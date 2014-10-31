/***********************************************************************
 Program Name: Index2.java
 Programmer's Name: Steven Bennett
 Program Description: Program accepts string of text in text area from
 user. Pressing Submit button will display counts of every letter in
 alphabet.
 ***********************************************************************/ 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Index2 extends JFrame{
	
	//declare instance variables
		private JFrame mainFrame;
		private JLabel textAreaLabel;
		private JTextArea stringToSearch;
		private JTextArea displayResults;
		private JButton submitButton;
		private String[] letterArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		
		//Index2 constructor
		public Index2()
		{
			//instantiate mainFrame, JTextArea, JLabel, JButton and JTextField objects.
			mainFrame = new JFrame("Index2 Lab");
			textAreaLabel = new JLabel("Enter text to be searched: ");
			stringToSearch = new JTextArea("Enter text here...", 5, 15);
			displayResults = new JTextArea(26,15);
			submitButton = new JButton("Count Occurrences of Each Letter");
			
			//create mainframe, set layout for program, add event to close program with "X" window button.
			Container c = mainFrame.getContentPane();
			c.setLayout(new FlowLayout());
			mainFrame.setBounds(800, 300, 250, 600);
			mainFrame.setVisible(true);
			mainFrame.addWindowListener(
					new WindowAdapter()
					{
						public void windowClosing(WindowEvent e)
						{
							System.exit(0);
						}
					});
			
			//add components to container
			c.add(textAreaLabel);
			c.add(stringToSearch);
			c.add(submitButton);
			c.add(displayResults);
			
			//set properties of JTextArea
			stringToSearch.setLineWrap(true);
			stringToSearch.setWrapStyleWord(true);
			displayResults.setLineWrap(true);
			displayResults.setWrapStyleWord(true);
			
			
			//add event handler to searchCharField. Allow user to press Enter submit.
			SubmitButtonHandler sbHandler = new SubmitButtonHandler();
			submitButton.addActionListener(sbHandler);
		}
		
		
		//add event handler to user input JTextField press enter to display results
		
		class SubmitButtonHandler implements ActionListener{
			public void actionPerformed (ActionEvent e)
			{
				
				String textAreaString = stringToSearch.getText();  //string to hold input from JTextArea.
				
				int start = 0;     //used to keep track of current index in string.
				int counter = 0;  //used to count number of occurrences of specific character.
				
				textAreaString = textAreaString.toLowerCase();//changes input text to lower case.
				
				for(int i = 25; i > -1; i--)
				{
					while(true)
					{
						start = textAreaString.indexOf(letterArray[i], start);
						if(start < 0)
							break;
						start++;
						counter++;
					}
					displayResults.insert(letterArray[i] + ":     " + counter + "\n", 0);
					
					//reset counters.
					counter = 0;
					start = 0;
				}
			}
		}
}
