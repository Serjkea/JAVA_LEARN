interface Phone {
	long getPrice();
}

interface PhoneAbsFactory {
	Phone getApplePhone();
	Phone getSamsungPhone();
	Phone getLenovoPhone();
}

class uaApplePhone implements Phone{
	public long getPrice() {
		return 1000l;
	}
}

class uaSamsungPhone implements Phone {
	public long getPrice() {
		return 800l;
	}
}

class uaLenovoPhone implements Phone {
	public long getPrice() {
		return 500l;
	}
}

class uaPhoneFactory implements PhoneAbsFactory {
	public Phone getApplePhone() {
		return new uaApplePhone();
	}
	public Phone getSamsungPhone() {
		return new uaSamsungPhone();
	}
	public Phone getLenovoPhone() {
		return new uaLenovoPhone();
	}
}

class ruApplePhone implements Phone{
	public long getPrice() {
		return 1100l;
	}
}

class ruSamsungPhone implements Phone {
	public long getPrice() {
		return 900l;
	}
}

class ruLenovoPhone implements Phone {
	public long getPrice() {
		return 600l;
	}
}

class ruPhoneFactory implements PhoneAbsFactory {
	public Phone getApplePhone() {
		return new ruApplePhone();
	}
	public Phone getSamsungPhone() {
		return new ruSamsungPhone();
	}
	public Phone getLenovoPhone() {
		return new ruLenovoPhone();
	}
}

public class AbstractFactoryPattern {
	
	public static void main(String[] argss) {
		PhoneAbsFactory factory = new uaPhoneFactory();
		System.out.println(factory.getApplePhone().getPrice());
		System.out.println(factory.getSamsungPhone().getPrice());
		System.out.println(factory.getLenovoPhone().getPrice());
		factory = new ruPhoneFactory();
		System.out.println(factory.getApplePhone().getPrice());
		System.out.println(factory.getSamsungPhone().getPrice());
		System.out.println(factory.getLenovoPhone().getPrice());
	}

}
