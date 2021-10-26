package com.softradix.templis.ui.fragments.details

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.softradix.templis.R
import com.softradix.templis.databinding.DetailsFragmentBinding
import java.io.IOException


class DetailsFragment : Fragment() {

    companion object {
        fun newInstance() = DetailsFragment()
    }


    private lateinit var viewModel: DetailsViewModel
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var binding: DetailsFragmentBinding
    private var holder: SurfaceHolder? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailsFragmentBinding.inflate(layoutInflater, container, false)
//        if (mediaPlayer == null) {
        mediaPlayer = MediaPlayer()

//        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        onClickEvents()

        try {
            val path =
                "android.resource://" + requireActivity().packageName + "/" + R.raw.sinner_promo
            mediaPlayer?.setDataSource(requireActivity(), Uri.parse(path))
            holder = binding.videoView.holder
            holder?.addCallback(object : SurfaceHolder.Callback {
                override fun surfaceCreated(holder: SurfaceHolder) {
                    mediaPlayer?.setDisplay(holder)
                }

                override fun surfaceChanged(
                    holder: SurfaceHolder,
                    format: Int,
                    width: Int,
                    height: Int
                ) {
                }

                override fun surfaceDestroyed(holder: SurfaceHolder) {}
            })
            mediaPlayer?.prepare()
            mediaPlayer?.seekTo(/*2*60**/1000)
            mediaPlayer?.setOnPreparedListener { mp ->

                mp.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING)
                mediaPlayer?.start()

                mediaPlayer?.isLooping = true
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    override fun onPause() {
        super.onPause()
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    private fun onClickEvents() {
        binding.backBtn.setOnClickListener { findNavController().navigateUp() }

        binding.moreTxt.setOnClickListener {
            val action = DetailsFragmentDirections.actionDetailsFragmentToCastingDetailsFragment()
            findNavController().navigate(action)

        }


        binding.watchNowBtn.setOnClickListener {
            val action = DetailsFragmentDirections.actionDetailsFragmentToSelectQualityFragment()
            findNavController().navigate(action)
        }
    }

}