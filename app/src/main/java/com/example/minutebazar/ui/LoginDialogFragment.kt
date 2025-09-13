package com.example.minutebazar.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.minutebazar.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginDialogFragment : DialogFragment() {

    interface OnLoginListener {
        fun onLogin(name: String, phone: String)
    }

    private var listener: OnLoginListener? = null

    private lateinit var etName: TextInputEditText
    private lateinit var etPhone: TextInputEditText
    private lateinit var cbTerms: CheckBox
    private lateinit var btnLoginOtp: MaterialButton
    private lateinit var btnClose: ImageButton
    private lateinit var tvHelp: TextView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = try {
            context as OnLoginListener
        } catch (e: ClassCastException) {
            null // You can handle this if listener is mandatory
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login_dialog, container, false)

        // Initialize views matching your XML IDs
        etName = view.findViewById(R.id.etName)
        etPhone = view.findViewById(R.id.etPhone)
        cbTerms = view.findViewById(R.id.cbTerms)
        btnLoginOtp = view.findViewById(R.id.btnLoginOtp)
        btnClose = view.findViewById(R.id.btnClose)
        tvHelp = view.findViewById(R.id.tvHelp)

        // Close button dismisses dialog
        btnClose.setOnClickListener {
            dismiss()
        }

        // Login button click
        btnLoginOtp.setOnClickListener {
            val name = etName.text?.toString()?.trim() ?: ""
            val phone = etPhone.text?.toString()?.trim() ?: ""

            when {
                name.isEmpty() -> {
                    etName.error = "Please enter your name"
                }
                phone.isEmpty() -> {
                    etPhone.error = "Please enter your phone number"
                }
                !cbTerms.isChecked -> {
                    Toast.makeText(requireContext(), "Please agree to privacy and policy", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    listener?.onLogin(name, phone)
                    dismiss()
                }
            }
        }

        // Help text click (optional)
        tvHelp.setOnClickListener {
            Toast.makeText(requireContext(), "Help will be provided shortly.", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }
}
