package com.mailprojectteam.memorizelic.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mailprojectteam.memorizelic.R
import com.mailprojectteam.memorizelic.ui.AccountData

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val signInButton: Button = root.findViewById(R.id.button_sign_in);

        signInButton.setOnClickListener{
            val intent = Intent(requireContext(), AccountData::class.java)
            val userName: EditText = root.findViewById(R.id.account_real_username)
            userName.text.toString()
            val email: EditText = root.findViewById(R.id.account_real_email)
            email.text.toString()
            val password: EditText = root.findViewById(R.id.account_real_password)
            password.text.toString()
            intent.putExtra("username", userName.text.toString())
            intent.putExtra("email", email.text.toString())
            intent.putExtra("password", password.text.toString())
            startActivity(intent)
        }
        return root
    }
}