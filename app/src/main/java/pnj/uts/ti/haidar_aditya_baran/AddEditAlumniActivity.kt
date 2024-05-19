package pnj.uts.ti.haidar_aditya_baran

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import pnj.uts.ti.haidar_aditya_baran.model.Alumni
import  pnj.uts.ti.haidar_aditya_baran.repository.AlumniRepository
import java.util.*

class AddEditAlumniActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ALUMNI_ID = "alumni_id"
    }

    private lateinit var alumniRepository: AlumniRepository

    private lateinit var etNim: EditText
    private lateinit var etNama: EditText
    private lateinit var etTempatTanggalLahir: EditText
    private lateinit var etTanggalLahir: EditText
    private lateinit var etAlamat: EditText
    private lateinit var etAgama: EditText
    private lateinit var etNoHp: EditText
    private lateinit var etTahunMasuk: EditText
    private lateinit var etTahunLulus: EditText
    private lateinit var etPekerjaan: EditText
    private lateinit var etJabatan: EditText
    private lateinit var btnSave: Button

    private var alumniId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_alumni)

        alumniRepository = AlumniRepository(this)

        etNim = findViewById(R.id.etNim)
        etNama = findViewById(R.id.etNama)
        etTempatTanggalLahir = findViewById(R.id.etTempatTanggalLahir)
        etTanggalLahir = findViewById(R.id.etTanggalLahir)
        etAlamat = findViewById(R.id.etAlamat)
        etAgama = findViewById(R.id.etAgama)
        etNoHp = findViewById(R.id.etNoHp)
        etTahunMasuk = findViewById(R.id.etTahunMasuk)
        etTahunLulus = findViewById(R.id.etTahunLulus)
        etPekerjaan = findViewById(R.id.etPekerjaan)
        etJabatan = findViewById(R.id.etJabatan)
        btnSave = findViewById(R.id.btnSave)

        val intent = intent
        if (intent.hasExtra(EXTRA_ALUMNI_ID)) {
            alumniId = intent.getLongExtra(EXTRA_ALUMNI_ID, 0)
            val alumni = alumniRepository.getAllAlumni().find { it.id == alumniId }
            alumni?.let { populateFields(it) }
        }

        etTanggalLahir.setOnClickListener {
            showDatePickerDialog()
        }

        btnSave.setOnClickListener {
            saveAlumni()
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            etTanggalLahir.setText(date)
        }, year, month, day).show()
    }

    private fun populateFields(alumni: Alumni) {
        etNim.setText(alumni.nim)
        etNama.setText(alumni.nama)
        etTempatTanggalLahir.setText(alumni.tempatTanggalLahir)
        etTanggalLahir.setText(alumni.tanggalLahir)
        etAlamat.setText(alumni.alamat)
        etAgama.setText(alumni.agama)
        etNoHp.setText(alumni.noHp)
        etTahunMasuk.setText(alumni.tahunMasuk)
        etTahunLulus.setText(alumni.tahunLulus)
        etPekerjaan.setText(alumni.pekerjaan)
        etJabatan.setText(alumni.jabatan)
    }

    private fun saveAlumni() {
        val nim = etNim.text.toString()
        val nama = etNama.text.toString()
        val tempatTanggalLahir = etTempatTanggalLahir.text.toString()
        val tanggalLahir = etTanggalLahir.text.toString()
        val alamat = etAlamat.text.toString()
        val agama = etAgama.text.toString()
        val noHp = etNoHp.text.toString()
        val tahunMasuk = etTahunMasuk.text.toString()
        val tahunLulus = etTahunLulus.text.toString()
        val pekerjaan = etPekerjaan.text.toString()
        val jabatan = etJabatan.text.toString()

        val alumni = Alumni(
            id = alumniId,
            nim = nim,
            nama = nama,
            tempatTanggalLahir = tempatTanggalLahir,
            tanggalLahir = tanggalLahir,
            alamat = alamat,
            agama = agama,
            noHp = noHp,
            tahunMasuk = tahunMasuk,
            tahunLulus = tahunLulus,
            pekerjaan = pekerjaan,
            jabatan = jabatan
        )

        if (alumniId == 0L) {
            alumniRepository.addAlumni(alumni)
        } else {
            alumniRepository.updateAlumni(alumni)
        }

        finish()
    }
}