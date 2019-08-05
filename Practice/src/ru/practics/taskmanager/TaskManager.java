package ru.practics.taskmanager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TaskManager {
	
	private static final String CONFIG_FILENAME = "config";
	private static final String BACKUP_FILENAME = "tasks";
	private static final String LOGGER_FILENAME = "taskmngr";
	private static final String PREFIX_PATHNAME = "/home/kostenko/Projects/Java/TaskManager/";
	private static final String SUFFIX_DATANAME = ".dat";
	private static final String SUFFIX_CNFGNAME = ".cfg";
	private static final String SUFFIX_PRNTNAME = ".txt";
	
	private static Properties properties = new Properties();
	
	private static boolean reminderIsActive = false;
	
	private static TaskStore taskStore = TaskStore.getTaskStore();
	
	private static Logger logger = new Logger(PREFIX_PATHNAME, LOGGER_FILENAME);
	
	public static void completeTask(int id) {
		taskStore.getTask(id).complete();
	}
	
	public static void activateTask(int id) {
		taskStore.getTask(id).activate();
	}
	
	public static void disactivateTask(int id) {
		taskStore.getTask(id).disactivate();
	}
	
	public static void removeCompletedTasks() {
		for(Task task: taskStore) {
			if(task.isCompleted) taskStore.removeTask(task);
		}
	}
	
	public static void removeTask(int id) {
		for(Task task: taskStore) {
			if(task.getId() == id) taskStore.removeTask(task);
		}
	}

	public static void saveToFile() {
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PREFIX_PATHNAME+BACKUP_FILENAME+SUFFIX_DATANAME));
			oos.writeObject(taskStore.saveTasks());
			oos.close();
			if(taskStore.size()!=0) {
				logger.write("Tasks was saved");
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadFromFile() {
		if (taskStore.size() != 0) taskStore.removeAllTasks();
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PREFIX_PATHNAME+BACKUP_FILENAME+SUFFIX_DATANAME));
			try {
				taskStore.restoreTasks((List<Task>)ois.readObject());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			ois.close();
			logger.write("Tasks was restored");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setReminder(Reminder reminder) {
		new Thread(reminder).start();
	}
	
	public static void createMainForm() {
		final JFrame frame = new JFrame("Task Manager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400,300));
		frame.setLocation(500, 400);
		
		final JPanel mainPanel = new JPanel(new BorderLayout());
		final JPanel listPanel = new JPanel(new BorderLayout());
		final JPanel infoPanel = new JPanel(new BorderLayout());
		final JPanel cmdPanel = new JPanel(new GridLayout(8,1,5,5));
		listPanel.setBounds(100,100, 100, 200);
		
		final JCheckBox cmbShowCompleted = new JCheckBox("Show completed tasks");
		final JCheckBox cmbShowActive = new JCheckBox("Show active tasks");
		cmbShowCompleted.setSelected((Boolean)properties.get("show_completed"));
		cmbShowActive.setSelected((Boolean)properties.get("show_active"));
		
		final DefaultListModel model = new DefaultListModel();
		
		if((Boolean)properties.get("backup")) {
			loadFromFile();
			for(Task task: taskStore) {
				if(cmbShowCompleted.isSelected() && cmbShowActive.isSelected() && (task.isCompleted || task.isActive)) model.addElement(task.getName());
				else if(cmbShowCompleted.isSelected() && !cmbShowActive.isSelected() && task.isCompleted && !task.isActive) model.addElement(task.getName());
				else if(!cmbShowCompleted.isSelected() && cmbShowActive.isSelected() && !task.isCompleted && task.isActive) model.addElement(task.getName());
				else if(!cmbShowCompleted.isSelected() && !cmbShowActive.isSelected() && !task.isCompleted && !task.isActive) model.addElement(task.getName());
			}
		}
		final JList taskList = new JList(model);	
		
		JButton btnPerform = new JButton("Perform");
		JButton btnDelete = new JButton("Delete");
		JButton btnDeleteAll = new JButton("Delete All");
		JButton btnAdd = new JButton("Add");
		JButton btnClose = new JButton("Close");
		JButton btnPrint = new JButton("Print");
		JLabel lbInfo = new JLabel("Tasks list");
		JLabel lbText = new JLabel("Description");
		final JTextPane tpDescription = new JTextPane();
		tpDescription.setEditable(false);
		
		infoPanel.add(lbText, BorderLayout.NORTH);
		infoPanel.add(tpDescription, BorderLayout.SOUTH);
		listPanel.add(lbInfo, BorderLayout.NORTH);
		listPanel.add(taskList, BorderLayout.CENTER);
		listPanel.add(infoPanel, BorderLayout.SOUTH);	
		
		cmdPanel.add(btnAdd);		
		cmdPanel.add(btnPerform);
		cmdPanel.add(btnDelete);
		cmdPanel.add(btnDeleteAll);
		cmdPanel.add(btnPrint);
		cmdPanel.add(cmbShowCompleted);
		cmdPanel.add(cmbShowActive);
		cmdPanel.add(btnClose);
		
		mainPanel.add(listPanel,BorderLayout.CENTER);
		mainPanel.add(cmdPanel,BorderLayout.EAST);
				
		frame.add(mainPanel);
		frame.pack();
		frame.setVisible(true);
		
		taskList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(taskList.getSelectedValue()!=null) {
					tpDescription.setText(taskStore.getTask(taskList.getSelectedValue().toString()).getDescription());
				} else {
					tpDescription.setText("");
				}
			}
		});
				
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showAddForm();
			}
		});
		
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				properties.put("backup", true);
				saveConfig();
				saveToFile();
				logger.write("Exit");
				logger.stop();
				frame.dispose();
			}
		});
		
		btnPerform.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = 0;
				for(Task task: taskStore) {
					if(taskList.getSelectedIndex() == index) {
						task.complete();
						logger.write("Task " + task.getName() + " was completed");
						model.removeAllElements();
						for(Task task1: taskStore) {
							if(cmbShowCompleted.isSelected() && cmbShowActive.isSelected() && (task1.isCompleted || task1.isActive)) model.addElement(task1.getName());
							else if(cmbShowCompleted.isSelected() && !cmbShowActive.isSelected() && task1.isCompleted && !task1.isActive) model.addElement(task1.getName());
							else if(!cmbShowCompleted.isSelected() && cmbShowActive.isSelected() && !task1.isCompleted && task1.isActive) model.addElement(task1.getName());
							else if(!cmbShowCompleted.isSelected() && !cmbShowActive.isSelected() && !task1.isCompleted && !task1.isActive) model.addElement(task1.getName());
						}
						break;
					}
					index++;
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = 0;
				for(Task task: taskStore) {
					if(taskList.getSelectedValue().toString().equals(task.getName())) {
						taskStore.removeTask(task);
						model.remove(taskList.getSelectedIndex());
						logger.write("Task " + task.getName() + " was deleted");
						break;
					}
					index++;
				}
			}
		});
		
		btnDeleteAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				taskStore.removeAllTasks();
				logger.write("All taskes was deleted");
				model.removeAllElements();
				for(Task task: taskStore) {
					if(cmbShowCompleted.isSelected() && cmbShowActive.isSelected() && (task.isCompleted || task.isActive)) model.addElement(task.getName());
					else if(cmbShowCompleted.isSelected() && !cmbShowActive.isSelected() && task.isCompleted && !task.isActive) model.addElement(task.getName());
					else if(!cmbShowCompleted.isSelected() && cmbShowActive.isSelected() && !task.isCompleted && task.isActive) model.addElement(task.getName());
					else if(!cmbShowCompleted.isSelected() && !cmbShowActive.isSelected() && !task.isCompleted && !task.isActive) model.addElement(task.getName());
				}
			}
		});
		
		frame.addWindowFocusListener(new WindowFocusListener() {
			@Override
			public void windowGainedFocus(WindowEvent arg0) {
				model.removeAllElements();
				model.clear();
				if (taskStore.size()!=0) {
				for(Task task: taskStore) {
					if(cmbShowCompleted.isSelected() && cmbShowActive.isSelected() && (task.isCompleted || task.isActive)) model.addElement(task.getName());
					else if(cmbShowCompleted.isSelected() && !cmbShowActive.isSelected() && task.isCompleted && !task.isActive) model.addElement(task.getName());
					else if(!cmbShowCompleted.isSelected() && cmbShowActive.isSelected() && !task.isCompleted && task.isActive) model.addElement(task.getName());
					else if(!cmbShowCompleted.isSelected() && !cmbShowActive.isSelected() && !task.isCompleted && !task.isActive) model.addElement(task.getName());
				}
				}
			}
			@Override
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		
		
		cmbShowCompleted.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				properties.put("show_completed",cmbShowCompleted.isSelected());
				logger.write("Property name: show_completed = " + cmbShowCompleted.isSelected());
				model.removeAllElements();
				model.clear();
				if (taskStore.size()!=0) {
					for(Task task: taskStore) {
						if(cmbShowCompleted.isSelected() && cmbShowActive.isSelected() && (task.isCompleted || task.isActive)) model.addElement(task.getName());
						else if(cmbShowCompleted.isSelected() && !cmbShowActive.isSelected() && task.isCompleted && !task.isActive) model.addElement(task.getName());
						else if(!cmbShowCompleted.isSelected() && cmbShowActive.isSelected() && !task.isCompleted && task.isActive) model.addElement(task.getName());
						else if(!cmbShowCompleted.isSelected() && !cmbShowActive.isSelected() && !task.isCompleted && !task.isActive) model.addElement(task.getName());
					}
				}
			}
		});
		
		cmbShowActive.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				properties.put("show_active",cmbShowActive.isSelected());
				logger.write("Property name: show_active = " + cmbShowActive.isSelected());
				model.removeAllElements();
				model.clear();
				if (taskStore.size()!=0) {
					for(Task task: taskStore) {
						if(cmbShowCompleted.isSelected() && cmbShowActive.isSelected() && (task.isCompleted || task.isActive)) model.addElement(task.getName());
						else if(cmbShowCompleted.isSelected() && !cmbShowActive.isSelected() && task.isCompleted && !task.isActive) model.addElement(task.getName());
						else if(!cmbShowCompleted.isSelected() && cmbShowActive.isSelected() && !task.isCompleted && task.isActive) model.addElement(task.getName());
						else if(!cmbShowCompleted.isSelected() && !cmbShowActive.isSelected() && !task.isCompleted && !task.isActive) model.addElement(task.getName());
					}
				}
			}
		});
		
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				properties.put("backup", true);
				saveConfig();
				saveToFile();
				logger.write("Exit");
				logger.stop();
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
			}
			
		});
		
		btnPrint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					FileWriter fw = new FileWriter(PREFIX_PATHNAME+BACKUP_FILENAME+SUFFIX_PRNTNAME);
					fw.write(taskStore.toString());
					fw.close();
					logger.write("Tasks was saved to file tasks.txt");
					JOptionPane.showMessageDialog(null, "Print succesfully!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void showAddForm() {
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400,150));
		frame.setLocation(600, 400);
		
		JLabel lbName = new JLabel("Enter task name");
		final JTextField tfName = new JTextField("");
		JLabel lbDescription = new JLabel("Enter task description");
		final JTextField tfDescription = new JTextField("");
		
		JButton btnAdd = new JButton("Add");
		JButton btnBack = new JButton("Back");
		
		JPanel panel = new JPanel(new GridLayout(3,1,5,5));
		panel.add(lbName);
		panel.add(tfName);
		panel.add(lbDescription);
		panel.add(tfDescription);
		panel.add(btnAdd);
		panel.add(btnBack);
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				taskStore.addTask(tfName.getText(), tfDescription.getText());
				logger.write("New task " + tfName.getText() + " was add");
				frame.dispose();
			}			
		});
		
	}
	
	public static void loadConfig() {
		try{
			try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PREFIX_PATHNAME+CONFIG_FILENAME+SUFFIX_CNFGNAME));
			try {
				Properties temp = null;
				if ((temp = (Properties)ois.readObject())!=null) {
					properties = temp;
					logger.write("Saved configuration was loaded");
				}
				else {
					properties.put("backup", false);
					properties.put("show_completed", false);
					properties.put("show_active", true);
					properties.put("reminder", false);
					properties.put("saved_config", false);
					logger.write("Default configuration was loaded");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			ois.close();
		} catch(FileNotFoundException e) {
			properties.put("backup", false);
			properties.put("show_completed", false);
			properties.put("show_active", true);
			properties.put("reminder", false);
			properties.put("saved_config", false);
			logger.write("Default configuration was loaded");
//			e.printStackTrace();
		}
			} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void saveConfig() {
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PREFIX_PATHNAME+CONFIG_FILENAME+SUFFIX_CNFGNAME));
			oos.writeObject(properties);
			oos.close();
			logger.write("Configuration was saved");
			} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		logger.write(new Date().toString());
		logger.write("Loading configuration...");
		loadConfig();
		JFrame.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createMainForm();
				logger.write("TaskManager was running...");
			}
		});
	}

}
