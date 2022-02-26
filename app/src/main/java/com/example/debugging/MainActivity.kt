package com.example.debugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "this is where the app crashed before")
        val helloTextView: TextView = findViewById(R.id.division_textview)
        Log.d(TAG, "this should be logged if the bug is fixed")
        helloTextView.text = "Hello, debugging!"
        logging()
        division()
    }

    fun division(){
        /* Kotlin utiliza dos palabras clave diferentes para declarar variables: val y var.
        * Usa val para una variable cuyo valor no cambia nunca.
        * No puedes volver a asignar un valor a una variable que se declaró mediante val.
        * Utiliza var para una variable cuyo valor puede cambiar.
        */
        val numerator = 60 //una variable de tipo val no puede cambiar
        var denominator = 4 //una variable de tipo var si puede cambiar (aquí la decrementamos)
        repeat(4){
            Thread.sleep(1)
            findViewById<TextView>(R.id.division_textview).setText("${numerator / denominator}")
            denominator--
        }
    }

    fun logging() {
        Log.e(TAG, "ERROR: a serious error like an app crash")
        Log.w(TAG, "WARN: warns about the potential for serious errors")
        Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
        Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
        Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")
    }
}