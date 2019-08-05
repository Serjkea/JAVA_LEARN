import java.util.*;

interface Drawable {
	void draw(Context context);
}

class Point implements Drawable {
	
	public void draw(Context context) {
		System.out.println("Point " + context.color + " " + context.x + " " + context.y);
	}
}

class Circle implements Drawable {
	
	private int radius;
	
	Circle(int radius) {
		this.radius = radius;
	}
	
	public void draw(Context context) {
		System.out.println("Circle with radius = " + radius + " " + context.color + " " + context.x + " " + context.y);
	}
}

class Square implements Drawable {
	
	private int weight;
	private int height;
	
	Square(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}
	
	public void draw(Context context) {
		this.weight = context.x;
		this.height = context.y;
		System.out.println("Square with weight = " + weight + " height = " + height + " " + context.color + " " + context.x + " " + context.y);
	}
}

class Picture implements Drawable {
	
	private List<Drawable> primitives;
	
	Picture(Drawable[] primitives) {
		this.primitives = new LinkedList<Drawable>();
		this.primitives.addAll(Arrays.asList(primitives));
	}
	
	public void draw(Context context) {
		for(Drawable primitive: primitives) {
			primitive.draw(context);
		}
	}
}

abstract class PrimitiveFactory {
	
	private static Point onePoint;
	private static Map<Integer,Circle> circles;
	private static Map<Integer,Square> squares;
	
	static {
		circles = new HashMap<Integer,Circle>();
		squares = new HashMap<Integer,Square>();
	}
	
	public static Picture createPicture(Drawable[] childrens) {
		return new Picture(childrens);
	}
	
	public static Circle createCircle(int radius) {
		if(circles.get(radius) == null) {
			circles.put(radius, new Circle(radius));
		}
		return circles.get(radius);
	}
	
	public static Square createSquare(int x, int y) {
		if(squares.get(x*y) == null) {
			squares.put(x*y, new Square(x,y));
		}
		return squares.get(x*y);
	}
	
	public static Point createPoint() {
		if(onePoint == null) {
			onePoint = new Point();
		}
		return onePoint;
	}
	
}

final class Context {
	
	public int x;
	public int y;
	public String color;
	
	Context(int x, int y, String color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
}

public class FlyweightPattern {
	
	public static void main(String[] args) {
		Drawable[] primitives = {
				PrimitiveFactory.createPoint(),
				PrimitiveFactory.createCircle(20),
				PrimitiveFactory.createSquare(10, 20),
				PrimitiveFactory.createCircle(50),
				PrimitiveFactory.createPoint(),
				PrimitiveFactory.createSquare(20, 20),
				PrimitiveFactory.createCircle(20)
		};
		Picture picture = new Picture(primitives);
		Context context = new Context(5,5,"red");
		picture.draw(context);
	}

}
