package com.ashish.aggrobuddy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.ashish.aggrobuddy.R

class DescriptionActivity : AppCompatActivity() {

    lateinit var txtFarmerName: TextView
    lateinit var textRate: TextView
    lateinit var textPhoneNumber: TextView
    lateinit var textFarmerRating: TextView
    lateinit var imgFarmerProduct: ImageView
    lateinit var textFarmerDescription: TextView
    lateinit var btnAddToFav: Button
    lateinit var progressBar: ProgressBar
    lateinit var processLayout: RelativeLayout

    var farmerId: String? = "100"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        txtFarmerName = findViewById(R.id.textFaremername)
        textRate = findViewById(R.id.textRateOfTheProduct)
        textPhoneNumber = findViewById(R.id.textPhoneNumber)
        textFarmerRating = findViewById(R.id.rating)
        imgFarmerProduct = findViewById(R.id.imageofframerproduct)
        textFarmerDescription = findViewById(R.id.textAboutFaremerProduct)
        btnAddToFav = findViewById(R.id.btnAddToFavourites)
        progressBar = findViewById(R.id.progressbar)
        progressBar.visibility = View.VISIBLE
        processLayout = findViewById(R.id.ProgressBarLayout)
        processLayout.visibility = View.VISIBLE


        if (intent != null) {
            farmerId = intent.getStringExtra("farmer_id")
        } else {
            finish()
            Toast.makeText(
                this@DescriptionActivity,
                "Some Unexpected Error Occured",
                Toast.LENGTH_LONG
            ).show()
        }
        if (farmerId == "100") {
            finish()
            Toast.makeText(
                this@DescriptionActivity,
                "Some unecpected error Occured !!",
                Toast.LENGTH_LONG
            )
                .show()
        }

    }
}