package ru.practics.guiapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskManager {
	
	public List<Task> taskList;
	private static long uid = 0;
	
	public TaskManager() {
		taskList = new ArrayList<Task>();
	}
	
	public void addTask(Task task) {
		task.setId(++uid);
		taskList.add(task);
	}
	
	public Task getTask() {
		Iterator iterator = taskList.iterator();
		if(iterator.hasNext()) {
			return (Task) iterator.next();
		}
		return null;
	}
	
	public void delTask() {
		if (taskList!=null)
		taskList.remove(0);
	}
	
	public void getAllsTasks() {
		for(Task task: taskList) {
			System.out.println(task);
		}
	}
}
