package com.itacademy.mobilewallet.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.itacademy.mobilewallet.App
import com.itacademy.mobilewallet.databinding.FragmentPaymentsBinding
import com.itacademy.mobilewallet.ui.entities.Payments


class PaymentsFragment : Fragment() {
    private var _binding: FragmentPaymentsBinding? = null
    private val binding get() = _binding!!
    private val args: PaymentsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleTransaction.text = args.servicesName
        val dbPayment = App.instance?.getDatabase()?.PaymentsDao()

        binding.payBtn.setOnClickListener {
            val payments = Payments(
                idTransaction = null,
                nameTransaction = args.servicesName,
                personalAccount = binding.personalAccount.text.toString().toInt(),
                sumTransaction = binding.transactionSum.text.toString().toInt()
            )
            dbPayment?.addPayments(payments)
            Log.d("DDDD", "${dbPayment?.getAllPayments()}")
        }
    }
}