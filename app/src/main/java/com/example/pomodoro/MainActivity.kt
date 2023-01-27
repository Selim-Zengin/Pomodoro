package com.example.pomodoro

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Vibrator


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    private var bundle: Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaPlayer = MediaPlayer.create(this, R.raw.muzik)

        activity2Button.setOnClickListener {
            var intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }


        startButton.setOnClickListener {

            var timer = object : CountDownTimer(1500000, 1000) {

                override fun onTick(millisUntilFinished: Long) {


                    var timeResult =
                        "${(millisUntilFinished / 1000 / 60).toString().padStart(2, '0')}:" +

                                "${
                                    (millisUntilFinished / 1000 % 60).toString()
                                        .padStart(2, '0')
                                } "

                    textView.text = " $timeResult"
                    startButton.isInvisible = true
                    resetButton.isInvisible = false

                }

                override fun onFinish() {
                    textView.text = "BİTTİ"
                    startButton.isInvisible = false
                    resetButton.isInvisible = true
                    mediaPlayer?.start()

                    val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
// Vibrate for 500 milliseconds
// Vibrate for 500 milliseconds
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        v.vibrate(
                            VibrationEffect.createOneShot(
                                300,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    } else {
                        //deprecated in API 26
                        v.vibrate(300)
                    }



                }

            }

         resumeButton.setOnClickListener {

         }
            pauseButton.setOnClickListener {
            timer.cancel()
            }


                resetButton.setOnClickListener {
                    timer.cancel()
                    timer.onFinish()
                    textView.text = "25:00"
                    mediaPlayer?.pause()


                }

                timer.start()
                textView.text = "$timer"
            }
        }
    }




