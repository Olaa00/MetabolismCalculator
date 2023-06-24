package pl.beczkowska.metabolismcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

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
            if (validation(weight, height, age)) {

                //obliczanie bmi
                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))

                //wynik z dwoma miejscami po przecinku
                val bmi2Digits = String.format("%.2f", bmi).toFloat()

                Result(bmi2Digits)

            //obliczanie metabolizmu
            val metabolism = ((10 * weight.toFloat()) +(6.25 *height.toFloat()) - (5 *age.toFloat()) +5)
            //wynik bezprzecinkowy
            val metaboDigits = String.format("%.0f", metabolism).toFloat()
            Result2(metaboDigits)
        }}

            }
            private fun Result(bmi: Float) {

                // Pobranie referencji do pól TextView z pliku layoutu activity_main.xml
                val bmival = findViewById<TextView>(R.id.bmivalue)
                val normdescription = findViewById<TextView>(R.id.norm)
                val textinf = findViewById<TextView>(R.id.normtext) //staly text

                bmival.text = bmi.toString()
                textinf.text = "haelthy range: 18.5-24.9"

                var resultText = ""
                var color = 0

                when {
                    bmi < 18.50 -> {
                        resultText = "UNDERWEIGHT"
                        color = R.color.under_weight
                    }

                    bmi in 18.50..24.99 -> {
                        resultText = "HEALTHY"
                        color = R.color.healthy
                    }

                    bmi in 25.00..29.99 -> {
                        resultText = "OVERWEIGHT"
                        color = R.color.over_weight
                    }

                    bmi >= 29.99 -> {
                        resultText = "OBESE"
                        color = R.color.obese
                    }

                }
                normdescription.setTextColor(ContextCompat.getColor(this, color))
                normdescription.text = resultText
            }
    private fun Result2(metabolism :Float){
        val dailmetab = findViewById<TextView>(R.id.dailymetabo)
        val metaboval = findViewById<TextView>(R.id.metabolismvalue)

        val metabolismWithUnit = "$metabolism kcal"

        // Przypisanie wyniku z jednostką do pola TextView
        metaboval.text = metabolismWithUnit
    }


            //jesli waga wiek lub wzrost sa puste -> komunikat
            private fun validation(weight: String?, height: String?, age: String?): Boolean {
                return when {
                    height.isNullOrEmpty() -> {
                        Toast.makeText(
                            this,
                            "Height is empty. Enter your height",
                            Toast.LENGTH_LONG
                        ).show()
                        return false
                    }

                    weight.isNullOrEmpty() -> {
                        Toast.makeText(
                            this,
                            "Weight is empty. Enter your weight",
                            Toast.LENGTH_LONG
                        ).show()
                        return false
                    }

                    age.isNullOrEmpty() -> {
                        Toast.makeText(this, "Age is empty. Enter your age", Toast.LENGTH_SHORT)
                            .show()
                        return false
                    }

                    else -> {
                        return true

                }
                }}}




/* TODO
        BMI
MASA  CIALA(kg)/ WZROST^2
<18,5	niedowaga
18,5 – 24,9	masa ciała prawidłowa
25,0 – 29,9 	nadwaga
30 – 34,9	I stopień otyłości
       TODO METABOLISM
PPM [kcal] = (10 ×masa ciała w kg) + (6,25 × wzrost w cm) – (5 × wiek w latach) + 5
*/
