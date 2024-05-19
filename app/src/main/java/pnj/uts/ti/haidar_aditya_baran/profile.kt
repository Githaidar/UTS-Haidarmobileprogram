//package pnj.uts.ti.haidar_aditya_baran
//
//import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import android.widget.TextView
//
//class profile : AppCompatActivity() {
//    lateinit var tvEmail: TextView
//    lateinit var tvNim: TextView
//    lateinit var tvNama: TextView
//    lateinit var tvKelas: TextView
//    lateinit var tvIsLogin: TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_profile) // Replace with your actual layout resource ID
//
//        tvEmail = findViewById(R.id.textViewEmail) // Update IDs as needed
//        tvNim = findViewById(R.id.textViewNim)
//        tvNama = findViewById(R.id.textViewNama)
//        tvKelas = findViewById(R.id.textViewKelas)
//        tvIsLogin = findViewById(R.id.textViewIsLogin)
//
//        // Retrieve SharedPreferences data
//        val sharedPref = getSharedPreferences("Profile", Context.MODE_PRIVATE)
//        val email = sharedPref.getString("email", "")
//        val nim = sharedPref.getString("nim", "")
//        val nama = sharedPref.getString("nama", "")
//        val kelas = sharedPref.getString("kelas", "")
//        val isLogin = sharedPref.getBoolean("IsLogin", false)
//
//        // Update TextViews with retrieved data
//        tvEmail.text = email
//        tvNim.text = nim
//        tvNama.text = nama
//        tvKelas.text = kelas
//        tvIsLogin.text = isLogin.toString()
//    }
//}