package pnj.uts.ti.haidar_aditya_baran.model

data class Alumni(
    val id: Long = 0,
    val nim: String,
    val nama: String,
    val tempatTanggalLahir: String,
    val tanggalLahir: String,
    val alamat: String,
    val agama: String,
    val noHp: String,
    val tahunMasuk: String,
    val tahunLulus: String,
    val pekerjaan: String,
    val jabatan: String
)