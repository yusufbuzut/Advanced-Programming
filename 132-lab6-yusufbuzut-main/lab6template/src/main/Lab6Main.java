package main;

import javax.swing.JFrame;

import component.CPU;
import component.Display;
import computer.Desktop;
import computer.Laptop;
import computer.SmartWatch;

public class Lab6Main {

	public static void main(String[] args) {
		//prelab();
		inlab();
		
		
	}
	
	
	/*
	public static void prelab() {
		ComputerStore store = new ComputerStore();
		store.addComputer(new Desktop(new CPU(2.3, Math.pow(10, 9)), new Display(1920,1080), "Intel"));
		store.addComputer(new Desktop(new CPU(2.5, 2 * Math.pow(10, 9)), new Display(2560,1440), "AMD"));
		store.addComputer(new Laptop(new CPU(2.1, Math.pow(10, 9)), new Display(1366,768), "Dell", 50));
		store.addComputer(new SmartWatch(new CPU(1.6, Math.pow(10, 9)), new Display(220,176), "Xiaomi", 100));
		store.listComputers();
	}
	*/
	
	public static void inlab() {
		ComputerStore store = new ComputerStore();
		store.addComputer(new Desktop(new CPU(2.3, Math.pow(10, 9)), new Display(1920,1080), "Intel"));
		store.addComputer(new Desktop(new CPU(2.5, 2 * Math.pow(10, 9)), new Display(2560,1440), "AMD"));
		store.addComputer(new Laptop(new CPU(2.1, Math.pow(10, 9)), new Display(1366,768), "Dell", 50));
		store.addComputer(new SmartWatch(new CPU(1.6, Math.pow(10, 9)), new Display(220,176), "Xiaomi", 100));
		store.setSize(500, 100);
		store.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		store.setVisible(true);
	}
	
}
