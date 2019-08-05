package ru.practics.taskmanager;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskStore implements Iterable<Task>{
	
	private static TaskStore store;
	
	private static int id = 0;
	private List<Task> tasks;
	
	private TaskStore() {
	}
	
	public static TaskStore getTaskStore() {
		if(store == null) store = new TaskStore();
		return store;
	}
	
	public void addTask(String name, String description) {
		if(tasks == null) tasks = new LinkedList<Task>();
		tasks.add(new Task.Builder()
						.setName(name)
						.setDescription(description)
						.setId(++id)
						.build()
						);
	}
	
	public Task getTask(int id) {
		if(!tasks.isEmpty() && tasks != null) {
			for(Task task: tasks) {
				if(task.getId() == id) return task;
			}
		}
		return null;
	}
	
	public Task getTask(String name) {
		if(!tasks.isEmpty() && tasks != null) {
			for(Task task: tasks) {
				if(task.getName().equals(name)) return task;
			}
		}
		return null;
	}
	
	public void removeTask(Task task) {
		if(tasks.contains(task)) 
			tasks.remove(task);
	}
	
	public void removeAllTasks() {
		if(!tasks.isEmpty() && tasks != null) 
			tasks.clear();
	}
	
	public String[] getTasksNames() {
		String[] list = new String[tasks.size()];
		for(int i=0;i<tasks.size();i++){
			list[i] = tasks.get(i).getName();
		}
		return list;
	}
	
	public int size() {
		if (tasks==null) return 0;
		return tasks.size();
	}
	
	public void restoreTasks(List<Task> restoredTasks) {
		this.tasks = restoredTasks;
	}
	
	public List<Task> saveTasks() {
		return this.tasks;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Task task : tasks) {
			sb.append(task+"\n\n");
		}
		return sb.toString();
	}
	
	public class TaskStoreIterator  implements Iterator<Task>  {

		private int pointer = 0;
		private boolean isEmpty = (tasks.size() == 0);
		
		@Override
		public boolean hasNext() {
			return pointer < tasks.size();
		}

		@Override
		public Task next() {
			if(hasNext()) return tasks.get(pointer++);
			else {
				isEmpty = true;
				return null;
			}
		}

		@Override
		public void remove() {
			if(!isEmpty) tasks.remove(pointer--);
		}
		
	}

	@Override
	public Iterator<Task> iterator() {
		return new TaskStoreIterator();
	}


}
