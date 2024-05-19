package pnj.uts.ti.haidar_aditya_baran

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edtusername:EditText
    lateinit var edtpassword:EditText
    lateinit var btnlogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        edtusername = findViewById(R.id.editTextText3)
        edtpassword = findViewById(R.id.editPassword)
        btnlogin = findViewById(R.id.button)


        btnlogin.setOnClickListener {
            if (edtusername.text.toString().equals("haidar")&& edtpassword.text.toString().equals("1234")) {
                var data = getSharedPreferences("Profile", Context.MODE_PRIVATE)
                var edit = data.edit()
                edit.putString("email", "haidar.aditya.baran.tik22@mhsw.pnj.ac.id")
                edit.putString("nim", "2207411028")
                edit.putString("nama", "Haidar")
                edit.putString("kelas", "TI4A")
                edit.putBoolean("IsLogin", true)
                edit.commit()

                var pindah = Intent(applicationContext, realhome::class.java)
                startActivity(pindah)
                finish()
            } else{
                Toast.makeText(applicationContext,"loginsalah",Toast.LENGTH_SHORT).show()
            }
        }

    }
}