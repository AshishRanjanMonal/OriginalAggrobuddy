package com.ashish.aggrobuddy.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ashish.aggrobuddy.R


class TransactionHistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this com.ashish.aggrobuddy.fragment
        return inflater.inflate(R.layout.fragment_transaction_history, container, false)
    }


}