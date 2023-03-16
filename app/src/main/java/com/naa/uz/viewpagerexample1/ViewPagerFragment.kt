package com.naa.uz.viewpagerexample1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naa.uz.viewpagerexample1.databinding.FragmentViewPagerBinding
import com.naa.uz.viewpagerexample1.model.ModelViewPager


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ViewPagerFragment : Fragment() {

    private var param1: ModelViewPager? = null
    private var param2: String? = null
    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable(ARG_PARAM1) as ModelViewPager

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)

        binding.image.setImageResource(param1!!.background)
        binding.titleTv.text = param1?.title
        binding.textTv.text = param1?.text

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: ModelViewPager) =
            ViewPagerFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)

                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}