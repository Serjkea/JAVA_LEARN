package ru.practics.taskmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Reminder implements Runnable {

	private int millis;
	private TaskStore taskStore;
	
	Reminder(TaskStore taskStore,int millis) {
		this.millis = millis;
		this.taskStore = taskStore;
	}
	
	@Override
	public void run() {
		new Timer(millis, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(taskStore.iterator().next().getName());
				JOptionPane.showMessageDialog(null,taskStore.iterator().next().getName());
			}
		}).start();		
	}

}
