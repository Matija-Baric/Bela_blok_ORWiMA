package hr.ferit.matijabaric.belablok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ukupnomi = findViewById<TextView>(R.id.bodovimi)
        val ukupnovi = findViewById<TextView>(R.id.bodovivi)
        val rezultatmi = findViewById<TextView>(R.id.rezultatmi)
        val rezultatvi = findViewById<TextView>(R.id.rezultatvi)
        val obrisi = findViewById<Button>(R.id.obrisibutton)


        var sum1 = intent.getIntExtra("igrami",0)
        var sum2 = intent.getIntExtra("igravi",0)
        ukupnomi.text = sum1.toString()
        ukupnovi.text = sum2.toString()

        var pobjedaMi = intent.getIntExtra("povecajMi",0)
        var pobjedaVi = intent.getIntExtra("povecajVi",0)
        rezultatmi.text = pobjedaMi.toString()
        rezultatvi.text = pobjedaVi.toString()

        val button = findViewById<Button>(R.id.noviunos)
        button.setOnClickListener {
            val intent1 = Intent(this, Unos::class.java)
            intent1.putExtra("mainmi", sum1)
            intent1.putExtra("mainvi", sum2)
            intent1.putExtra("rezmi",pobjedaMi)
            intent1.putExtra("rezvi",pobjedaVi)
            startActivity(intent1)
        }

        obrisi.setOnClickListener {
            ukupnomi.text = "0"
            ukupnovi.text = "0"
            rezultatmi.text = "0"
            rezultatvi.text = "0"
            sum1 = 0
            sum2 = 0
            pobjedaMi = 0
            pobjedaVi = 0
        }

    }
}