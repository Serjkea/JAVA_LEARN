
abstract class AbstractLogger {
	
	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;
	
	protected int level;
	
	protected AbstractLogger nextLogger;
	
	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger = nextLogger;
	}
	
	public void logMessage(int level, String message) {
		if(this.level <= level){
			write(message);
		}
		if(nextLogger != null){
			nextLogger.logMessage(level, message);
		}
	}
	
	abstract protected void write(String message);
	
}

class ConsoleLogger extends AbstractLogger {
	
	public ConsoleLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Standart Console::Logger: " + message);
	}
	
}

class FileLogger extends AbstractLogger {
	
	public FileLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("File::Logger: " + message);
	}
	
}

class ErrorLogger extends AbstractLogger {
	
	public ErrorLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Error console::Logger: " + message);
	}
	
}

public class ChainOfResponsibilityPattern {
	
	private static AbstractLogger getChainOfLoggers(){
		
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
		
		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
		
		return errorLogger;
	}
	
	public static void main(String[] args) {
		AbstractLogger loggerChain = getChainOfLoggers();
		loggerChain.logMessage(AbstractLogger.INFO, "INFO level message");
		loggerChain.logMessage(AbstractLogger.DEBUG,"DEBUG level message");
		loggerChain.logMessage(AbstractLogger.ERROR, "ERROR level message");
	}

}
