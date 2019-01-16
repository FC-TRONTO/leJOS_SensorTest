/*!
 * @file SensorTest.java
 * @brief センサーテスト用プログラム
 * 
 */

import lejos.hardware.BrickFinder;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;
import lejos.utility.Delay;

public class SensorTest {

    public static void main(String[] args) {
	// TODO 自動生成されたメソッド・スタブ
	EV3 ev3 = (EV3) BrickFinder.getLocal();
	TextLCD lcd = ev3.getTextLCD();
	SensorSample sensorSample = new SensorSample();
	// LCD表示
	lcd.drawString("Sensor Sample", 1, 0);
	while(true) {
	    lcd.drawString("Distans = " + sensorSample.getSonarDistance(), 1, 1);
	    lcd.drawString("Angle = " + sensorSample.getIrSeekerAngle(), 1, 2);
	    Delay.msDelay(2000);
	}
    }

}
