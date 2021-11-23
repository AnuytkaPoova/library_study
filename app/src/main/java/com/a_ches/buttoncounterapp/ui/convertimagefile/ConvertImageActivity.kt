package com.a_ches.buttoncounterapp.ui.convertimagefile

import android.app.AlertDialog
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import com.a_ches.buttoncounterapp.R
import com.a_ches.buttoncounterapp.databinding.ActivityConvertImageBinding
import com.a_ches.buttoncounterapp.model.convertimagefile.FileStorage
import com.a_ches.buttoncounterapp.model.convertimagefile.ImageConvertor
import com.a_ches.buttoncounterapp.presenter.convertimagefile.ConvertImagePresenter
import com.a_ches.buttoncounterapp.presenter.convertimagefile.IConvertImageView
import com.a_ches.buttoncounterapp.presenter.convertimagefile.ImageConversionButtonStates
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class ConvertImageActivity : MvpAppCompatActivity(), IConvertImageView {

    private val binding: ActivityConvertImageBinding by lazy {
        ActivityConvertImageBinding.inflate(layoutInflater)
    }

    private val presenter: ConvertImagePresenter by moxyPresenter {
        ConvertImagePresenter(
            FileStorage(application),
            ImageConvertor
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.convertPicture.setOnClickListener {
            presenter.startConvertFile()
        }
    }

    override fun loadImageFromFile(bytesOfBmp: ByteArray) {
        BitmapFactory.decodeByteArray(bytesOfBmp, 0, bytesOfBmp.size)
            ?.let { binding.picture.setImageBitmap(it) }
            ?: Toast.makeText(applicationContext, "Error of loading", Toast.LENGTH_LONG).show()
    }

    override fun showAlert(message: String) {
        AlertDialog.Builder(this)
            .setTitle("Error")
            .setMessage(message)
            .create()
            .show()
    }

    override fun showState(message: String) {
        binding.textStates.text = binding.textStates.text.let {
            if (message.isBlank()) {
                ""
            } else {
                "$it\n$message"
            }
        }.trim()
    }

    override fun setStateOfButton(state: ImageConversionButtonStates) {
        if (state == ImageConversionButtonStates.STOPPED) {
            R.string.convert_picture_to_png_from_jpeg
        } else {
            R.string.stop_converting
        }.let { binding.convertPicture.text = getString(it) }
    }
}