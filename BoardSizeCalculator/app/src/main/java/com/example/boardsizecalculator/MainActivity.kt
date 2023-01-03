package com.example.boardsizecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.boardsizecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //To allow for binding between this and the xml
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Elements from the xml are binded to this code, so can define min and max
        //for the pickers
        binding.ShoePicker.minValue=35
        binding.ShoePicker.maxValue=52

        binding.HeightPicker.minValue=100
        binding.HeightPicker.maxValue=250

        binding.ShoePicker.setOnValueChangedListener{_,_,_ ->
            calculateSize()
        }

        binding.HeightPicker.setOnValueChangedListener{_,_,_ ->
            calculateSize()
        }
    }

    private fun calculateSize()
    {
        val height = binding.HeightPicker.value
        val shoeSize = binding.ShoePicker.value

        //Initializing deck size
        var deckSize = 7.1

        if (shoeSize in 35..37 || height in 100..150)
            deckSize =7.75
        else if (shoeSize in 38..40 || height in 160..170)
            deckSize=8.0
        else if (shoeSize in 41..42 || height in 171..180)
            deckSize=8.125
        else if (shoeSize in 43..45 || height in 181..190)
            deckSize=8.25
        else if (shoeSize>=46 || height >=190)
            deckSize = 8.5
        else
            deckSize = 8.5

        binding.DeckSizeTv.text = String.format("Your recommended deck size is: %.2f", deckSize)

    }
}