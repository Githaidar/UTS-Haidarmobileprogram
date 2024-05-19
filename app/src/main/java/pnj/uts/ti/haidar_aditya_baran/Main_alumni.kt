package pnj.uts.ti.haidar_aditya_baran

import android.os.Bundle
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pnj.uts.ti.haidar_aditya_baran.model.Alumni
import pnj.uts.ti.haidar_aditya_baran.repository.AlumniRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Main_alumni : AppCompatActivity() {
    private lateinit var alumniRepository: AlumniRepository
    private lateinit var alumniAdapter: AlumniAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_alumni)

        val btnAddAlumni: FloatingActionButton = findViewById(R.id.btnAddAlumni)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        alumniRepository = AlumniRepository(this)
        alumniAdapter = AlumniAdapter { alumni, action ->
            when (action) {
                "edit" -> editAlumni(alumni)
                "delete" -> deleteAlumni(alumni)
            }
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = alumniAdapter

        btnAddAlumni.setOnClickListener {
            startActivity(Intent(this, AddEditAlumniActivity::class.java))
        }

        loadAlumni()
    }

    private fun loadAlumni() {
        val alumniList = alumniRepository.getAllAlumni()
        alumniAdapter.submitList(alumniList)
    }

    private fun editAlumni(alumni: Alumni) {
        val intent = Intent(this, AddEditAlumniActivity::class.java)
        intent.putExtra(AddEditAlumniActivity.EXTRA_ALUMNI_ID, alumni.id)
        startActivity(intent)
    }

    private fun deleteAlumni(alumni: Alumni) {
        alumniRepository.deleteAlumni(alumni)
        loadAlumni()
    }

    override fun onResume() {
        super.onResume()
        loadAlumni()
    }
}