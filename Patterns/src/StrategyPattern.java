
interface Strategy {
	void download(String file);
}

class DownloadWindowsStrategy implements Strategy {
	public void download(String file) {
		System.out.println("Windows download: " + file);
	}
}

class DownloadLinuxStrategy implements Strategy {
	public void download(String file) {
		System.out.println("Linux download: " + file);
	}
}

class Context {
	
	private Strategy strategy;
	
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void download(String file) {
		strategy.download(file);
	}
}

public class StrategyPattern {
	
	public static void main(String[] args) {
		Context context = new Context(new DownloadWindowsStrategy());
		context.download("myfile.txt");
		context = new Context(new DownloadLinuxStrategy());
		context.download("myfile.txt");
	}


}
