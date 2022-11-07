package com.happiestminds.fragmentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class LoginFragment : Fragment() {

    lateinit var submitButton: Button
    lateinit var usernameEditText: EditText
    lateinit var passEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.supportFragmentManager?.setFragmentResultListener("credentials",
            this){ key, bundle ->
            val username = bundle.getString("email", "")
            val password = bundle.getString("password", "")

            usernameEditText.setText(username)
            passEditText.setText(password)
        }


//        arguments?.let {
//            userid = it.getString("username", "")
//            password = it.getString("password", "")
//        }
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        usernameEditText = view.findViewById(R.id.unameE)
        passEditText = view.findViewById(R.id.passE)

//        usernameEditText.setText(userid)
//        passEditText.setText(password)

        submitButton = view.findViewById(R.id.button)
        submitButton.setOnClickListener {
            val userid = usernameEditText.text.toString()
            val password = passEditText.text.toString()

            Toast.makeText(activity, "You entered: $userid, $password",
                Toast.LENGTH_LONG).show()

            (activity as MainActivity).loginDone()

            val bundle = Bundle()
            bundle.putString("userid", userid)

            activity?.supportFragmentManager?.setFragmentResult("loggedIn", bundle)
        }

        return view
    }


}