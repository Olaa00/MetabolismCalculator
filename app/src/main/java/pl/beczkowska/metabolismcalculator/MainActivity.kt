package pl.beczkowska.metabolismcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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
//
//            //obliczanie metabolizmu
//            val metabolism = ((10 * weight.toFloat()) +(6.25 *height.toFloat()) - (5 *age.toFloat()) +5)
//            //wynik z dwoma miejscami po przecinku
//            val metaboDigits = String.format("%", metabolism).toFloat()
            Result(bmi2Digits)
//            Result(metaboDigits)
        }

    }
    private fun Result(bmi:Float){

        // Pobranie referencji do pól TextView z pliku layoutu activity_main.xml
        val bmival = findViewById<TextView>(R.id.bmivalue)
        val normdescription = findViewById<TextView>(R.id.norm)
        val textinf = findViewById<TextView>(R.id.normtext)
//       val dailmetab = findViewById<TextView>(R.id.dailymetabo)
//        val mataboval = findViewById<TextView>(R.id.metabolismvalue)


        bmival.text = bmi.toString()
        textinf.text = "normal range 18.5-24.9"
//        mataboval.text = metabolism.toString
        var resultText = ""
        var color = 0
    }



}
/* TODO
        BMI
MASA  CIALA(kg)/ WZROST^2
       TODO METABOLISM
PPM [kcal] = (10 ×masa ciała w kg) + (6,25 × wzrost w cm) – (5 × wiek w latach) + 5
*/
