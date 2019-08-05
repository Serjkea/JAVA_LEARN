import java.util.*;

public class TaskStore {
	
	private Map<Integer,Task> taskStore = new HashMap<Integer,Task>();
	
	private static int id = 0;
	private static TaskStore instance;
	
	private TaskStore() {
	}

	public static TaskStore getTaskStore() {
		if(instance==null) instance = new TaskStore();
		return instance;
	}
	
	public void addTask(Task newTask) {
		newTask.setId(++id);
		taskStore.put(id, newTask);
	}
	
	public void delTask(int id) {
		if(taskStore.containsKey(id)) taskStore.remove((Integer)id);
		else System.out.println("No task with id: " + id);
	}
	
	public String showMostPriorityTask() {
		Task mpt = null;
		int maxTime = 0;
		for(Task tmp: taskStore.values()) {
			if((maxTime<tmp.getTimeLimit())&&tmp.isActive()) {
				maxTime = tmp.getTimeLimit();
				mpt = tmp;
			}
		}
		return mpt.toString();
	}
	
	public Task getMostPriorityTask() {
		Task mpt = null;
		int maxTime = 0;
		for(Task tmp: taskStore.values()) {
			if(maxTime<tmp.getTimeLimit()) {
				maxTime = tmp.getTimeLimit();
				mpt = tmp;
			}
		}
		return mpt;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(taskStore.values().toString());
		while(sb.indexOf(",")!=-1)
		sb.replace(sb.indexOf(", "),sb.indexOf(",")+2," \n");
		sb.deleteCharAt(sb.indexOf("["));
		sb.deleteCharAt(sb.indexOf("]"));
		return sb.toString();
	}
	
}
