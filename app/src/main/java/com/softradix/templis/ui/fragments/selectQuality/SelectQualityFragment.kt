package com.softradix.templis.ui.fragments.selectQuality

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.softradix.templis.R
import com.softradix.templis.databinding.SelectQualityFragmentBinding
import com.softradix.templis.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectQualityFragment : Fragment() {

    companion object {
        fun newInstance() = SelectQualityFragment()
    }

    private var video = 0
    private var audio = 0
    private var ticket = 0
    private var total = 0

    private val viewModel: SelectQualityViewModel by viewModels()

    private lateinit var binding: SelectQualityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        viewModel = ViewModelProvider(this)[SelectQualityViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.select_quality_fragment, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setUps()
        return binding.root
    }

    private fun setUps() {
        when (video) {
            10 -> {
                setUiVideo(binding.selectHq)
            }
            20 -> {
                setUiVideo(binding.selectHd)
            }
            30 -> {
                setUiVideo(binding.selectFullHD)
            }
            40 -> {
                setUiVideo(binding.select4K)
            }
        }

        when (audio) {
            5 -> {
                setUiAudio(binding.selectStandard)
            }
            10 -> {
                setUiAudio(binding.select51)
            }
            15 -> {
                setUiAudio(binding.selectDolby)
            }
        }
        when (ticket) {
            5 -> {
                setUiTicket(binding.selectOne)
            }
            10 -> {
                setUiTicket(binding.selectTwo)
            }
            15 -> {
                setUiTicket(binding.selectThree)
            }
            20 -> {
                setUiTicket(binding.selectFour)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickEvent()

    }

    private fun onClickEvent() {
        binding.payNowBtn.setOnClickListener {
            if (binding.priceTxt.text.toString() != "$0") {
                val action =
                    SelectQualityFragmentDirections.actionSelectQualityFragmentToPaymentsFragment()
                findNavController().navigate(action)
                /* Handler(Looper.getMainLooper()).postDelayed({
                     viewModel.totalMutableLiveData.value = "$0"
                 }, 500)*/
            } else {
                toast("Please select your choices.")
            }
        }

        /**************** Selection for Video Quality ***************/
        binding.selectHq.setOnClickListener {
            video = 10
            setUiVideo(binding.selectHq)
            viewModel.totalPriceData(video, audio, ticket)
        }
        binding.selectHd.setOnClickListener {
            video = 20
            setUiVideo(binding.selectHd)
            viewModel.totalPriceData(video, audio, ticket)
        }
        binding.selectFullHD.setOnClickListener {
            video = 30

            setUiVideo(binding.selectFullHD)
            viewModel.totalPriceData(video, audio, ticket)

        }
        binding.select4K.setOnClickListener {
            video = 40
            setUiVideo(binding.select4K)
            viewModel.totalPriceData(video, audio, ticket)

        }
        val video1 = view?.findViewById<TextView>(R.id.selectHq)

        Log.e("TAG", "onClickEvent: ${video1?.text}")
        /**************** Selection for Audio Quality ***************/
        binding.selectStandard.setOnClickListener {
            audio = 5
            setUiAudio(binding.selectStandard)
            viewModel.totalPriceData(video, audio, ticket)

        }
        binding.select51.setOnClickListener {
            audio = 10
            setUiAudio(binding.select51)
            viewModel.totalPriceData(video, audio, ticket)
        }
        binding.selectDolby.setOnClickListener {
            audio = 15
            setUiAudio(binding.selectDolby)
            viewModel.totalPriceData(video, audio, ticket)

        }

        /**************** Selection for Tickets ***************/
        binding.selectOne.setOnClickListener {
            ticket = 5
            setUiTicket(binding.selectOne)
            viewModel.totalPriceData(video, audio, ticket)
            binding.one.visibility = View.VISIBLE
            binding.two.visibility = View.GONE
            binding.four.visibility = View.GONE
        }

        binding.selectTwo.setOnClickListener {
            ticket = 10
            setUiTicket(binding.selectTwo)
            viewModel.totalPriceData(video, audio, ticket)
            binding.one.visibility = View.GONE
            binding.two.visibility = View.VISIBLE
            binding.four.visibility = View.GONE
        }
//        binding.selectThree.setOnClickListener {
//            ticket = 15
//            setUiTicket(binding.selectThree)
//            viewModel.totalPriceData(video, audio, ticket)
//
//        }
        binding.selectFour.setOnClickListener {
            ticket = 20

            binding.one.visibility = View.GONE
            binding.two.visibility = View.GONE
            binding.four.visibility = View.VISIBLE
            setUiTicket(binding.selectFour)
            viewModel.totalPriceData(video, audio, ticket)

        }

        binding.ivBack.setOnClickListener { findNavController().navigateUp() }

    }

    private fun setUiVideo(textView: TextView) {
        binding.selectHq.background =
            ContextCompat.getDrawable(requireActivity(), R.drawable.gray_bg)
        binding.selectHd.background =
            ContextCompat.getDrawable(requireActivity(), R.drawable.gray_bg)
        binding.selectFullHD.background =
            ContextCompat.getDrawable(requireActivity(), R.drawable.gray_bg)
        binding.select4K.background =
            ContextCompat.getDrawable(requireActivity(), R.drawable.gray_bg)
        textView.background = ContextCompat.getDrawable(requireActivity(), R.drawable.button_bg)
    }


    private fun setUiAudio(textView: TextView) {
        binding.selectStandard.background =
            ContextCompat.getDrawable(requireActivity(), R.drawable.gray_bg)
        binding.select51.background =
            ContextCompat.getDrawable(requireActivity(), R.drawable.gray_bg)
        binding.selectDolby.background =
            ContextCompat.getDrawable(requireActivity(), R.drawable.gray_bg)
        textView.background = ContextCompat.getDrawable(requireActivity(), R.drawable.button_bg)
    }

    private fun setUiTicket(textView: TextView) {
        binding.selectOne.background =
            ContextCompat.getDrawable(requireActivity(), R.drawable.gray_bg)
        binding.selectTwo.background =
            ContextCompat.getDrawable(requireActivity(), R.drawable.gray_bg)
        binding.selectThree.background =
            ContextCompat.getDrawable(requireActivity(), R.drawable.gray_bg)
        binding.selectFour.background =
            ContextCompat.getDrawable(requireActivity(), R.drawable.gray_bg)
        textView.background = ContextCompat.getDrawable(requireActivity(), R.drawable.button_bg)
    }


}