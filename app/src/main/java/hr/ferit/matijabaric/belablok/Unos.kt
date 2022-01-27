package hr.ferit.matijabaric.belablok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged

class Unos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unos)
        val igrami = findViewById<EditText>(R.id.igrami)
        val igravi = findViewById<EditText>(R.id.igravi)
        val zvanjemi = findViewById<EditText>(R.id.zvanjemi)
        val zvanjevi = findViewById<EditText>(R.id.zvanjevi)
        val bodovimi = findViewById<TextView>(R.id.bodovi1)
        val bodovivi = findViewById<TextView>(R.id.bodovi2)
        val unesi = findViewById<Button>(R.id.prebaci)
        val provjeri = findViewById<Button>(R.id.provjeri)

        var igramainmi = intent.getIntExtra("mainmi",0)
        var igramainvi = intent.getIntExtra("mainvi",0)
        var zbrojmi = Sum("zbrmi",igramainmi)
        var zbrojvi = Sum("zbrvi",igramainvi)
        var rezultatmi = intent.getIntExtra("rezmi",0)
        var rezmi = Sum("ukupnirezultatigreMI",rezultatmi)
        var rezultatvi = intent.getIntExtra("rezvi",0)
        var rezvi = Sum("ukupnirezultatigrevI",rezultatvi)

        igrami.doOnTextChanged { text, start, before, count ->
            val rez1 = (162 - (igrami.text.toString().toIntOrNull() ?: 0)).toString()
            if (igravi.text.toString() != rez1) {
                igravi.setText(rez1)
            }
            val uk1 = ((igrami.text.toString().toIntOrNull()?:0) + (zvanjemi.text.toString().toIntOrNull()?:0)).toString()
            if(bodovimi.text.toString() != uk1)
            {
                bodovimi.text = uk1
            }
        }

        zvanjemi.doOnTextChanged { text, start, before, count ->
            val uk1 = ((igrami.text.toString().toIntOrNull()?:0) + (zvanjemi.text.toString().toIntOrNull()?:0)).toString()
            if(bodovimi.text.toString() != uk1)
            {
                bodovimi.text = uk1
            }
        }

        igravi.doOnTextChanged { text, start, before, count ->
            val rez2 = (162 - (igravi.text.toString().toIntOrNull() ?: 0)).toString()
            if(igrami.text.toString() != rez2){
                igrami.setText(rez2)
            }
            val uk2 = ((igravi.text.toString().toIntOrNull()?:0) + (zvanjevi.text.toString().toIntOrNull()?:0)).toString()
            if(bodovivi.text.toString() != uk2)
            {
                bodovivi.text = uk2
            }
        }

        zvanjevi.doOnTextChanged { text, start, before, count ->
            val uk2 = ((igravi.text.toString().toIntOrNull()?:0) + (zvanjevi.text.toString().toIntOrNull()?:0)).toString()
            if(bodovivi.text.toString() != uk2)
            {
                bodovivi.text = uk2
            }
        }

        provjeri.setOnClickListener {
            bodovimi.text = ((igrami.text.toString().toIntOrNull()?:0)?.plus((zvanjemi.text.toString().toIntOrNull())?:0)).toString()
            bodovivi.text =((igravi.text.toString().toIntOrNull())?:0
                ?.plus(zvanjevi.text.toString().toIntOrNull()?:0)).toString()

        }

        unesi.setOnClickListener {
            val intent2 = Intent(this, MainActivity::class.java)
            zbrojmi.zbroj += (igrami.text.toString().toIntOrNull()?:0) + (zvanjemi.text.toString().toIntOrNull()?:0)
            zbrojvi.zbroj += (igravi.text.toString().toIntOrNull()?:0) + (zvanjevi.text.toString().toIntOrNull()?:0)
            if(usporedi(zbrojmi.zbroj)) {
                zbrojmi.zbroj = 0
                zbrojvi.zbroj = 0
                rezmi.zbroj += 1
            }
            if(usporedi(zbrojvi.zbroj)) {
                zbrojmi.zbroj = 0
                zbrojvi.zbroj = 0
                rezvi.zbroj += 1
            }

                intent2.putExtra("igrami", zbrojmi.zbroj)
                intent2.putExtra("igravi", zbrojvi.zbroj)
                intent2.putExtra("povecajVi", rezvi.zbroj)
                intent2.putExtra("povecajMi", rezmi.zbroj)
                startActivity(intent2)

            }

    }
      private fun usporedi(i: Int): Boolean {
        if(i>=1001) {
            return true
        }
         return false
    }


}