
interface Payment {
	void setNext(Payment payment);
	void pay();
}

class VisaPayment implements Payment {
	
	private Payment payment;
	
	public void setNext(Payment payment) {
		this.payment = payment;
	}
	
	public void pay() {
		System.out.println("VISA Payment");
	}
	
}

class PayPalPayment implements Payment {
	
	private Payment payment;
	
	public void setNext(Payment payment) {
		this.payment = payment;
	}
	
	public void pay() {
		System.out.println("PayPal Payment");
	}
	
}

class MasterCardPayment implements Payment {
	
	private Payment payment;
	
	public void setNext(Payment payment) {
		this.payment = payment;
	}
	
	public void pay() {
		System.out.println("MasterCard Payment");
	}
	
}

public class ChainOfResponsobilityNew {
	
	public static void main(String[] args) {
		Payment visa = new VisaPayment();
		Payment payPal = new PayPalPayment();
		Payment masterCard = new MasterCardPayment();
		visa.setNext(payPal);
		payPal.setNext(masterCard);
		visa.pay();
		payPal.pay();
		masterCard.pay();
		
	}

}
