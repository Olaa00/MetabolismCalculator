package pl.beczkowska.metabolismcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // refernecje do pol z pliku layoutu activity_main.xml
        val weightText = findViewById<EditText>(R.id.editweight)
        val heightText = findViewById<EditText>(R.id.editheight)
        val ageText = findViewById<EditText>(R.id.editage)
        val buttoncalc = findViewById<Button>(R.id.button)

        buttoncalc.setOnClickListener {
            val weight = weightText.text.toString()
            val height = heightText.text.toString()
            val age = ageText.text.toString()

            //obliczanie bmi
            val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat()/100))

            //wynik z dwoma miejscami po przecinku
            val bmi2Digits = String.format("%.2f", bmi).toFloat()

            //obliczanie metabolizmu
            val metabolism = ((10 * weight.toFloat()) +(6.25 *height.toFloat()) - (5 *age.toFloat()) +5)
        }

    }
    private fun Result



}
/* TODO
        BMI
MASA  CIALA(kg)/ WZROST^2
       TODO METABOLISM
PPM [kcal] = (10 ×masa ciała w kg) + (6,25 × wzrost w cm) – (5 × wiek w latach) + 5
*/
