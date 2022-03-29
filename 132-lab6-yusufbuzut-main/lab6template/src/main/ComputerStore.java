package main;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import computer.Computer;

public class ComputerStore extends JFrame{
	
	private ArrayList<Computer> computers;
	private final JLabel label1;
	private final JTextField textfield1;
	
	
	public ComputerStore() {
		computers = new ArrayList<Computer>();
		
		setLayout(new FlowLayout());
		label1 = new JLabel("Please press Enter after you write the filter name (wearable or portable)");
		add(label1);
		
		textfield1 = new JTextField(10);
		add(textfield1);
		
		TextFieldHandler handler = new TextFieldHandler();
		textfield1.addActionListener(handler);
	}
	
	public void addComputer(Computer computer) {
		computers.add(computer);
	}
	
	public void listComputers() {
		for(Computer computer: computers) {
			System.out.println(computer);
		}
	}
	
	
	public class LabelTest{
		
	}
	private class TextFieldHandler implements ActionListener{
		@Override 
		public void actionPerformed(ActionEvent event) {
			String string = "";
			
			if(event.getSource() == textfield1) {
				if (event.getActionCommand().equals("wearable")) {
					for (Computer computer : computers) {
						if(computer.isWearable()) {
							System.out.printf("wearable computers:%n");
							System.out.println(computer);
						}
					}
				}
				else if (event.getActionCommand().equals("portable")) {
					for (Computer computer : computers) {
						if(computer.isPortable()) {
							System.out.printf("portable computers:%n");
							System.out.println(computer);
						}
					}
				}
				else {
					System.out.println("Unknown command");
				}
			}
		}
	}
}
