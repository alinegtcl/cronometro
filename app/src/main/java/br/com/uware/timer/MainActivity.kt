package br.com.uware.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    val time: Long = 60000
    var timer = Timer(time)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart.setOnClickListener {
            initTimer()
        }
    }
    private fun initTimer(){
        if(btnStart.text == "Start")
            timer.start()
    }

    inner class Timer(miliis:Long) : CountDownTimer(miliis,2){
        var millisUntilFinished:Long = 0

        override fun onTick(millisUntilFinished: Long) {
            this.millisUntilFinished = millisUntilFinished
            val passTime = time + millisUntilFinished
            val f = DecimalFormat("00")
            val sec = passTime / 1000 % 60
            tvTime.text = f.format(sec)
        }

        override fun onFinish() {
            tvMensagem.text = "Acabaram os 60 segundos"
        }
    }
}

