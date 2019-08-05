package ru.practics.taskmanager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaskManagerTest {

	TaskStore taskStore;
	
	@Before
	public void setUp() {
		taskStore = TaskStore.getTaskStore();
	}
	
	@Test
	public void addTaskTest() {
		taskStore.addTask("task1", "description1");
		if (taskStore.getTask("task1") == null) fail("Task name failed");
		if (!taskStore.getTask("task1").getDescription().equals("description1")) fail("Task description failed");
	}
	
	@Test
	public void removeAllTasksTest() {
		taskStore.addTask("task1", "description1");
		taskStore.removeAllTasks();
		if(taskStore.size() != 0) fail("Remove all tasks failure");
	}
	
	@Test
	public void removeTaskTest() {
		taskStore.addTask("task1", "description1");
		taskStore.removeTask(taskStore.getTask("task1"));
		if(taskStore.size() != 0) fail("Remove task failure");
	}
	
	@Test
	public void getTasksNamesTest() {
		taskStore.addTask("name1"," descriptio1n1");
		taskStore.addTask("name2"," descriptio1n2");
		taskStore.addTask("name3"," descriptio1n3");
		if(taskStore.getTasksNames().toString().indexOf("name1")==0||
				taskStore.getTasksNames().toString().indexOf("name2")==0||
				taskStore.getTasksNames().toString().indexOf("name3")==0)
			fail("Tasks names failure");
	}
	
	@Test
	public void sizeTest() {
		taskStore.removeAllTasks();
		if(taskStore.size()==0) {
			taskStore.addTask("name1", "description1");
			if(taskStore.size()!=1) fail("Size failure");
			taskStore.addTask("name2", "description2");
			if(taskStore.size()!=2) fail("Size failure");
			taskStore.addTask("name3", "description3");
			if(taskStore.size()!=3) fail("Size failure");
			taskStore.addTask("name4", "description4");
			if(taskStore.size()!=4) fail("Size failure");
			taskStore.addTask("name5", "description5");
			if(taskStore.size()!=5) fail("Size failure");
		} else {fail("Size failure");}
	}
	
}
