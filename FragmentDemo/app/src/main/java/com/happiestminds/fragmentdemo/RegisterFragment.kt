package com.happiestminds.fragmentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {

    lateinit var submitButton: Button
    lateinit var emailEditText: EditText
    lateinit var passEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_register, container, false)

        emailEditText = view.findViewById(R.id.emailE)
        passEditText = view.findViewById(R.id.passwordE)
        submitButton = view.findViewById(R.id.submitB)
        submitButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passEditText.text.toString()

            val bundle = Bundle()
            bundle.putString("email", email)
            bundle.putString("password", password)

            activity?.supportFragmentManager?.setFragmentResult("credentials",bundle)

            Toast.makeText(activity, "Registeration Done..", Toast.LENGTH_LONG).show()

            activity?.supportFragmentManager?.popBackStack()
            (activity as MainActivity).registerDone()



        }
        return view
    }



}