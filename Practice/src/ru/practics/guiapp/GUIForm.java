package ru.practics.guiapp;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUIForm {
	
	public static void createGUI(final TaskManager taskManager) {
		JFrame frame = new JFrame("guiapp");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JList list  = new JList();
		list.setListData(taskManager.taskList.toArray());
		frame.getContentPane().add(list);
		frame.setPreferredSize(new Dimension(500,300));
		frame.pack();
		frame.setVisible(true);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				taskManager.delTask();
			}
			
		});
	}
}
