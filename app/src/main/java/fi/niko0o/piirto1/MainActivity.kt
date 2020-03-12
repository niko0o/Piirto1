package fi.niko0o.piirto1

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener {

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSensorChanged(event: SensorEvent) {
        textView2.text = "x: " + event.values[0].toString()
        textView.text = "y: " + event.values[1].toString()
        textView3.text = "z: " + event.values[2].toString()

        myView.setXY(event.values[0] * -3, event.values[1] * 3)

    }

    lateinit var sensorManager: SensorManager
    private var mSensor: Sensor? = null

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}
