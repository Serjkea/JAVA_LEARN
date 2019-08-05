package ru.practics.guiapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
	
	public static void main(String[] args) {
		final TaskManager taskManager = new TaskManager();
		taskManager.addTask(new Task("Do something good"));
		taskManager.addTask(new Task("Do something bad"));
		taskManager.addTask(new Task("Do something cool"));
		taskManager.addTask(new Task("Do something agile"));
		taskManager.addTask(new Task("Do something else"));
		JFrame.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUIForm.createGUI(taskManager);
			}
		});
		Timer timer = new Timer(5000,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(taskManager.getTask());
			}
		});
		timer.start();
	}
	
}
