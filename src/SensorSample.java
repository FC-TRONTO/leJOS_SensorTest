/*!
 * @file SensorSample.java
 * @brief センサーテスト用プログラム
 * 
 * 参考ページ：https://github.com/ETrobocon/etroboEV3
 * 
 */

import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;			// センサー用ポート
import lejos.hardware.sensor.EV3UltrasonicSensor;	// 距離センサー
import lejos.robotics.SampleProvider;
import lejos.hardware.sensor.HiTechnicIRSeekerV2;

public class SensorSample {
    
    // 定数定義
    private static final Port  SENSORPORT_IRSEEKER  = SensorPort.S1;  // 赤外線センサーポート
    private static final Port  SENSORPORT_SONAR     = SensorPort.S2;  // 超音波センサーポート
    
    // 超音波センサー
    private EV3UltrasonicSensor sonar;
    private SampleProvider distanceMode;  // 距離検出モード
    private float[] sampleDistance;
    
    // 赤外線センサー
    private HiTechnicIRSeekerV2 irSeeker;
    private SampleProvider modulatedMode;  // 変調モード
    private float[] sampleAngle;
    
    /*!
     * コンストラクタ
     */
    public SensorSample() {
	// 超音波センサー
	sonar = new EV3UltrasonicSensor(SENSORPORT_SONAR);
	distanceMode = sonar.getDistanceMode(); // 距離検出モード
	sampleDistance = new float[distanceMode.sampleSize()];
	sonar.enable();
	
	// 赤外線センサー
	irSeeker = new HiTechnicIRSeekerV2(SENSORPORT_IRSEEKER);
	modulatedMode = irSeeker.getModulatedMode(); // 変調モード
	sampleAngle = new float[modulatedMode.sampleSize()];
    }
    
    /*!
     * 超音波センサーにより障害物との距離を取得する
     * @return 障害物との距離(m)
     */
    public final float getSonarDistance() {
        distanceMode.fetchSample(sampleDistance, 0);
        return sampleDistance[0];
    }
    
    /*!
     * 赤外線センサーによりボールとの角度を取得する
     * @return ボールとの角度
     */
    public final float getIrSeekerAngle() {
	modulatedMode.fetchSample(sampleAngle, 0);
        return sampleAngle[0];
    }

}
