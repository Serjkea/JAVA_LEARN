
public class Main {
	
	public static void main(String[] args) {
		MyConnection connection = new MyConnection.Builder()
													.setName("Connection1")
													.setId(1)
													.setPort(80)
													.setUrl("url")
													.build();
		System.out.println(connection.getName());
		System.out.println(connection.getId());
		System.out.println(connection.getPort());
		System.out.println(connection.getUrl());
		
		MyConnection connectionNew = MyConnectionFabric.getMyConnection()
														.setName("Connection2")
														.setId(2)
														.setPort(90)
														.setUrl("urlNew")
														.build();
		System.out.println(connectionNew.getName());
		System.out.println(connectionNew.getId());
		System.out.println(connectionNew.getPort());
		System.out.println(connectionNew.getUrl());
		
		}

}
