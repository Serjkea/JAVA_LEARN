
public class TaskManager {

	public static void main(String[] args) {
		TaskStore tstore = TaskStore.getTaskStore();
		tstore.addTask(new Task("Task1", 10));
		tstore.addTask(new Task("Task2", 20));
		tstore.addTask(new Task("Task3", 20));
		tstore.addTask(new Task("Task4", 40));
		tstore.addTask(new Task("Task5", 50));
		System.out.println(tstore);
		System.out.println();
		tstore.delTask(2);
		System.out.println(tstore);
		System.out.println();
		System.out.println(tstore.showMostPriorityTask());
		tstore.getMostPriorityTask().disactivateTask();
		System.out.println();
		System.out.println(tstore);
		System.out.println();
		System.out.println(tstore.showMostPriorityTask());		
	}
	


}
