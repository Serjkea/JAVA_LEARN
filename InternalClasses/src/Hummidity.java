
public class Hummidity extends GreenHouseControls{
	
	private boolean hummidity = false;
	
	public class HumOn extends Event {

		public HumOn(long delayTime) {
			super(delayTime);
		}
		
		public void action() {
			hummidity = true;
		}
		
		public String toString() {
			return "Hummidity is ON";
		}
		
	}
	
	public class HumOff extends Event {

		public HumOff(long delayTime) {
			super(delayTime);
		}
		
		public void action() {
			hummidity = false;
		}
		
		public String toString() {
			return "Hummidity is OFF";
		}
		
	}

}
