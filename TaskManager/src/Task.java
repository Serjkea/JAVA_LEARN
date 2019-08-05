import java.util.Date;
import java.util.Formatter;

public class Task implements Cloneable {
	
	private String taskName;
	private int timeLimit;
	private boolean isActive;
	private Date createDate;
	private int id;
	
	Task(String taskName, int timeLimit) {
		this.taskName = taskName;
		this.timeLimit = timeLimit;
		this.isActive = true;
		this.createDate = new Date();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void activateTask() {
		this.isActive = true;
	}
	
	public void disactivateTask() {
		this.isActive = false;
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public String getTaskName() {
		return this.taskName;
	}
	
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	
	public int getTimeLimit() {
		return this.timeLimit;
	}
	
	public Date getCreateDate() {
		return this.createDate;
	}
	
	public boolean isActive() {
		return this.isActive;
	}
	
	@Override
	public String toString() {
		Formatter f = new Formatter();
		f.format("id: %d | Task name: %10s | Time limit: %5d | Active: %3s | Create date: %s", id, taskName, timeLimit, (isActive)?"yes":"no", createDate.toString());
		return f.toString();
	}
	
	@Override
	public boolean equals(Object link) {
		if(link==null) return false;
		if(link==this) return true;
		if(link instanceof Task) {
			Task temp = (Task)link;
			return this.taskName.equals(temp.taskName)&&
			       this.timeLimit==temp.timeLimit&&
			       this.isActive==temp.isActive&&
			       this.createDate==temp.createDate&&
			       this.id==temp.id;
		} return false;
	}
	
	@Override
	public int hashCode() {
		return 31*this.taskName.hashCode()+31*this.timeLimit+31*this.createDate.hashCode()+31*this.id;
	}
	
	@Override
	public Task clone() throws CloneNotSupportedException {
		return (Task)super.clone();
	}

}
