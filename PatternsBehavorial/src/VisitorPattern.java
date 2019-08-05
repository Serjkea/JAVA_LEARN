
interface Visitor {
	void visit(ConcreteObjectOne object);
	void visit(ConcreteObjectTwo object);
	void visit(ConcreteObjectThree object);
}

interface Accept {
	void accept(Visitor visitor);
}

class ConcreteObjectOne implements Accept {
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class ConcreteObjectTwo implements Accept {
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class ConcreteObjectThree implements Accept {
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class ConcreteVisitor implements Visitor {

	public void visit(ConcreteObjectOne object) {
		System.out.println("I'm visiter in Object One");
	}

	public void visit(ConcreteObjectTwo object) {
		System.out.println("I'm visiter in Object Two");
	}

	public void visit(ConcreteObjectThree object) {
		System.out.println("I'm visiter in Object Three");
	}
	
}

public class VisitorPattern {
	
	public static void main(String[] args) {
		Accept obj1 = new ConcreteObjectOne();
		Accept obj2 = new ConcreteObjectTwo();
		Accept obj3 = new ConcreteObjectThree();
		Visitor visitor = new ConcreteVisitor();
		obj1.accept(visitor);
		obj2.accept(visitor);
		obj3.accept(visitor);
	}
	

}
