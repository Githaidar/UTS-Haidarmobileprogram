package pnj.uts.ti.haidar_aditya_baran.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import pnj.uts.ti.haidar_aditya_baran.database.AlumniDatabaseHelper
import pnj.uts.ti.haidar_aditya_baran.model.Alumni

class AlumniRepository(context: Context) {

    private val dbHelper = AlumniDatabaseHelper(context)

    fun addAlumni(alumni: Alumni): Long {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(AlumniDatabaseHelper.COLUMN_NIM, alumni.nim)
            put(AlumniDatabaseHelper.COLUMN_NAMA, alumni.nama)
            put(AlumniDatabaseHelper.COLUMN_TEMPAT_TANGGAL_LAHIR, alumni.tempatTanggalLahir)
            put(AlumniDatabaseHelper.COLUMN_TANGGAL_LAHIR, alumni.tanggalLahir)
            put(AlumniDatabaseHelper.COLUMN_ALAMAT, alumni.alamat)
            put(AlumniDatabaseHelper.COLUMN_AGAMA, alumni.agama)
            put(AlumniDatabaseHelper.COLUMN_NO_HP, alumni.noHp)
            put(AlumniDatabaseHelper.COLUMN_TAHUN_MASUK, alumni.tahunMasuk)
            put(AlumniDatabaseHelper.COLUMN_TAHUN_LULUS, alumni.tahunLulus)
            put(AlumniDatabaseHelper.COLUMN_PEKERJAAN, alumni.pekerjaan)
            put(AlumniDatabaseHelper.COLUMN_JABATAN, alumni.jabatan)
        }
        return db.insert(AlumniDatabaseHelper.TABLE_NAME, null, values)
    }

    fun getAllAlumni(): List<Alumni> {
        val alumniList = mutableListOf<Alumni>()
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val cursor: Cursor = db.query(
            AlumniDatabaseHelper.TABLE_NAME,
            null, null, null, null, null,
            "${AlumniDatabaseHelper.COLUMN_NAMA} ASC"
        )

        with(cursor) {
            while (moveToNext()) {
                val alumni = Alumni(
                    id = getLong(getColumnIndexOrThrow(AlumniDatabaseHelper.COLUMN_ID)),
                    nim = getString(getColumnIndexOrThrow(AlumniDatabaseHelper.COLUMN_NIM)),
                    nama = getString(getColumnIndexOrThrow(AlumniDatabaseHelper.COLUMN_NAMA)),
                    tempatTanggalLahir = getString(getColumnIndexOrThrow(AlumniDatabaseHelper.COLUMN_TEMPAT_TANGGAL_LAHIR)),
                    tanggalLahir = getString(getColumnIndexOrThrow(AlumniDatabaseHelper.COLUMN_TANGGAL_LAHIR)),
                    alamat = getString(getColumnIndexOrThrow(AlumniDatabaseHelper.COLUMN_ALAMAT)),
                    agama = getString(getColumnIndexOrThrow(AlumniDatabaseHelper.COLUMN_AGAMA)),
                    noHp = getString(getColumnIndexOrThrow(AlumniDatabaseHelper.COLUMN_NO_HP)),
                    tahunMasuk = getString(getColumnIndexOrThrow(AlumniDatabaseHelper.COLUMN_TAHUN_MASUK)),
                    tahunLulus = getString(getColumnIndexOrThrow(AlumniDatabaseHelper.COLUMN_TAHUN_LULUS)),
                    pekerjaan = getString(getColumnIndexOrThrow(AlumniDatabaseHelper.COLUMN_PEKERJAAN)),
                    jabatan = getString(getColumnIndexOrThrow(AlumniDatabaseHelper.COLUMN_JABATAN))
                )
                alumniList.add(alumni)
            }
        }
        cursor.close()
        return alumniList
    }

    fun updateAlumni(alumni: Alumni): Int {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(AlumniDatabaseHelper.COLUMN_NIM, alumni.nim)
            put(AlumniDatabaseHelper.COLUMN_NAMA, alumni.nama)
            put(AlumniDatabaseHelper.COLUMN_TEMPAT_TANGGAL_LAHIR, alumni.tempatTanggalLahir)
            put(AlumniDatabaseHelper.COLUMN_TANGGAL_LAHIR, alumni.tanggalLahir)
            put(AlumniDatabaseHelper.COLUMN_ALAMAT, alumni.alamat)
            put(AlumniDatabaseHelper.COLUMN_AGAMA, alumni.agama)
            put(AlumniDatabaseHelper.COLUMN_NO_HP, alumni.noHp)
            put(AlumniDatabaseHelper.COLUMN_TAHUN_MASUK, alumni.tahunMasuk)
            put(AlumniDatabaseHelper.COLUMN_TAHUN_LULUS, alumni.tahunLulus)
            put(AlumniDatabaseHelper.COLUMN_PEKERJAAN, alumni.pekerjaan)
            put(AlumniDatabaseHelper.COLUMN_JABATAN, alumni.jabatan)
        }
        return db.update(AlumniDatabaseHelper.TABLE_NAME, values, "${AlumniDatabaseHelper.COLUMN_ID} = ?", arrayOf(alumni.id.toString()))
    }

    fun deleteAlumni(alumni: Alumni): Int {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        return db.delete(AlumniDatabaseHelper.TABLE_NAME, "${AlumniDatabaseHelper.COLUMN_ID} = ?", arrayOf(alumni.id.toString()))
    }
}