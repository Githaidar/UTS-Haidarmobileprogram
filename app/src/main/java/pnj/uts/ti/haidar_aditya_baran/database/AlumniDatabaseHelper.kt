package pnj.uts.ti.haidar_aditya_baran.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AlumniDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "alumni.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "alumni"
        const val COLUMN_ID = "id"
        const val COLUMN_NIM = "nim"
        const val COLUMN_NAMA = "nama"
        const val COLUMN_TEMPAT_TANGGAL_LAHIR = "tempat_tanggal_lahir"
        const val COLUMN_TANGGAL_LAHIR = "tanggal_lahir"
        const val COLUMN_ALAMAT = "alamat"
        const val COLUMN_AGAMA = "agama"
        const val COLUMN_NO_HP = "no_hp"
        const val COLUMN_TAHUN_MASUK = "tahun_masuk"
        const val COLUMN_TAHUN_LULUS = "tahun_lulus"
        const val COLUMN_PEKERJAAN = "pekerjaan"
        const val COLUMN_JABATAN = "jabatan"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = ("CREATE TABLE $TABLE_NAME ("
                + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$COLUMN_NIM TEXT, "
                + "$COLUMN_NAMA TEXT, "
                + "$COLUMN_TEMPAT_TANGGAL_LAHIR TEXT, "
                + "$COLUMN_TANGGAL_LAHIR TEXT, "
                + "$COLUMN_ALAMAT TEXT, "
                + "$COLUMN_AGAMA TEXT, "
                + "$COLUMN_NO_HP TEXT, "
                + "$COLUMN_TAHUN_MASUK TEXT, "
                + "$COLUMN_TAHUN_LULUS TEXT, "
                + "$COLUMN_PEKERJAAN TEXT, "
                + "$COLUMN_JABATAN TEXT)")
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}