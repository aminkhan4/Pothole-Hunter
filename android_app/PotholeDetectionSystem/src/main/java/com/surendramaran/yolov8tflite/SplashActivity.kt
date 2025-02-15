// SplashActivity.kt
package com.surendramaran.yolov8tflite

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private var repeatCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val lottieAnimation = findViewById<LottieAnimationView>(R.id.lottieAnimation)
        lottieAnimation.setAnimation("lottie/CarLoading.json")

        lottieAnimation.repeatCount = LottieDrawable.INFINITE
        lottieAnimation.playAnimation()

        lottieAnimation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {
                repeatCount++
                if (repeatCount >= 3) {
                    lottieAnimation.cancelAnimation()
                    startActivity(Intent(this@SplashActivity, WelcomeActivity::class.java))
                    finish()
                }
            }
            override fun onAnimationEnd(animation: Animator) {}
        })
    }
}