
public class MyConnection {
	
	public final String name;
	public final int id;
	public final int port;
	public final String url;
	
	private MyConnection(String name, int id, int port, String url) {
		this.name = name;
		this.id = id;
		this.port = port;
		this.url = url;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public int getPort() {
		return port;
	}
	
	public String getUrl() {
		return url;
	}
	
	public static class Builder {
		
		private String name;
		private int id;
		private int port;
		private String url;
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setId(int id) {
			this.id = id;
			return this;
		}
		
		public Builder setPort(int port) {
			this.port = port;
			return this;
		}
		
		public Builder setUrl(String url) {
			this.url = url;
			return this;
		}
		
		public MyConnection build() {
			return new MyConnection(this.name,this.id, this.port,this.url);
		}
	}
}
