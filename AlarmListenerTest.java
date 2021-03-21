import cs1.Keyboard;
import java.util.ArrayList;
import java.util.Iterator;

public class AlarmTest {
	
	public static void main( String[] args) {

		// **********************************************************
		// Setup central heating to bring stablise room temperature btw 18 & 20
		Heater	centralHeating = new Heater();
		centralHeating.setState( true);
		
		Thermostat t = new Thermostat( 18, 20);
		t.addAlarmListener( centralHeating);
		
		int roomTemp = 0;
		t.update( roomTemp);
		
		int time = 0;
		while ( time < 100) { 
		//while ( centralHeating.getState() ) { 
		
			// room temperature increases when heating is on, decreases when off...	
			if ( centralHeating.getState() ) 
				roomTemp++;
			else
				roomTemp--;
			
			// sense room temperature & automatically switch heating on/off	
			t.update( roomTemp);
			
			System.out.print( roomTemp + ":" + centralHeating + ", " );
			time++;
		}
		
		System.out.println( "Comfortable room temperature achieved!");
		Keyboard.Wait();
