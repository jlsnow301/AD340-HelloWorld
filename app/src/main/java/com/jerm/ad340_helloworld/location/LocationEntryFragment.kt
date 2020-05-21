package com.jerm.ad340_helloworld.location

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.jerm.ad340_helloworld.AppNavigator
import com.jerm.ad340_helloworld.DailyForecast
import com.jerm.ad340_helloworld.R
import com.jerm.ad340_helloworld.details.ForecastDetailsActivity

/**
 * A simple [Fragment] subclass.
 */
class LocationEntryFragment : Fragment() {

    private lateinit var appNavigator: AppNavigator

    override fun onAttach(context: Context) {
        super.onAttach(context)
        appNavigator = context as AppNavigator
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_location_entry, container, false)

        // Update UI
        val zipcodeEditText: EditText = view.findViewById(R.id.zipcodeEditText)
        val enterButton: Button = view.findViewById(R.id.enterButton)

        enterButton.setOnClickListener{
            val zipcode: String = zipcodeEditText.text.toString()
            if(zipcode.length != 5){
                Toast.makeText(requireContext(), R.string.zipcode_error, Toast.LENGTH_SHORT).show()
            } else {
                appNavigator.navigateToCurrentForecast(zipcode)
            }
        }
        return view
    }

}
