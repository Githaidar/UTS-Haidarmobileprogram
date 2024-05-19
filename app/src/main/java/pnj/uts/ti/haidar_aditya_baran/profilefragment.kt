package pnj.uts.ti.haidar_aditya_baran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.content.Context
import android.content.Intent


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [profilefragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class profilefragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profilefragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve data from SharedPreferences
        val sharedPreferences =
            requireActivity().getSharedPreferences("Profile", Context.MODE_PRIVATE)
        val email = sharedPreferences.getString("email", "N/A")
        val nim = sharedPreferences.getString("nim", "N/A")
        val nama = sharedPreferences.getString("nama", "N/A")
        val kelas = sharedPreferences.getString("kelas", "N/A")

        // Update UI with retrieved data
        view.findViewById<TextView>(R.id.tvemail).text = "Email: $email"
        view.findViewById<TextView>(R.id.tvnim).text = "NIM: $nim"
        view.findViewById<TextView>(R.id.tvnama).text = "Nama: $nama"
        view.findViewById<TextView>(R.id.tvkelas).text = "Kelas: $kelas"

        view.findViewById<Button>(R.id.logut).setOnClickListener {
            logout()
        }
        view.findViewById<Button>(R.id.btnalumni).setOnClickListener {
            cekdataalumni()
        }

    }
    private fun logout() {
        val sharedPreferences = requireActivity().getSharedPreferences("Profile", Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()

        // Redirect to LoginActivity
        val intent = Intent(requireActivity(), MainActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
    private fun cekdataalumni(){

        // Redirect to LoginActivity
        val intent = Intent(requireActivity(), Main_alumni::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment profilefragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            profilefragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}