package com.example.kidsdrawingapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.core.view.get
import com.example.kidsdrawingapp.databinding.ActivityMainBinding
import com.example.kidsdrawingapp.databinding.DialogBrushSizeBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var brushBinding : DialogBrushSizeBinding

    private var mImageButtonCurrentPaint: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.drawingView.setSizeForBrush(20.toFloat())

        mImageButtonCurrentPaint = binding.llPaintColors[1] as ImageButton;
        mImageButtonCurrentPaint!!.setImageDrawable(
            ContextCompat.getDrawable(this,R.drawable.pallet_pressed)
        )

        binding.ibBrush.setOnClickListener{
            showBrushSizeChooserDialog()
        }
    }

    private fun showBrushSizeChooserDialog(){
        brushBinding = DialogBrushSizeBinding.inflate(layoutInflater)
        val brushDialog= Dialog(this)
        brushDialog.setContentView(brushBinding.root)
        brushDialog.setTitle("Brush Size: ")
        val smallButton = brushBinding.ibSmallBrush
        smallButton.setOnClickListener {
            binding.drawingView.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }

        val mediumButton = brushBinding.ibMediumBrush
        mediumButton.setOnClickListener {
            binding.drawingView.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }

        val largeButton = brushBinding.ibLargeBrush
        largeButton.setOnClickListener {
            binding.drawingView.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }

        brushDialog.show()
    }
}