
public class GreenHouseController {
	
	public static void main(String[] args) {
		GreenHouseControls gc = new GreenHouseControls();
		gc.addEvent(gc.new Bell(20));
		Event[] eventList = {gc.new ThermostatNight(0),
				             gc.new LightOn(300),
				             gc.new LightOff(500),
				             gc.new WaterOn(700),
				             gc.new WaterOff(1000),
        					 gc.new ThermostatDay(1600)};
		gc.addEvent(gc.new Restart(1000,eventList));
		gc.run();
//		gc.addEvent(new GreenHouseControls.Terminate(2000));
		gc.run();
		eventList = new Event[] {gc.new ThermostatNight(0),
	             gc.new LightOn(300),
	             gc.new LightOff(500),
	             gc.new WaterOn(700),
	             gc.new WaterOff(1000),
				 gc.new ThermostatDay(1600),
				 new Hummidity().new HumOn(3000),
				 new Hummidity().new HumOff(4000)};
		gc.addEvent(gc.new Restart(1000,eventList));
		gc.addEvent(new Hummidity().new HumOn(3000));
		gc.run();
		gc.addEvent(new GreenHouseControls.Terminate(2000));
		
	}

}
