package com.mfelipe.app_drinks.cenario_splashScreen

import android.content.Intent
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mfelipe.app_drinks.cenario_lista.ListaDrinksActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler().postDelayed({
            startActivity(Intent(baseContext, ListaDrinksActivity::class.java))
            finish()
        }, 4000)

    }
}
