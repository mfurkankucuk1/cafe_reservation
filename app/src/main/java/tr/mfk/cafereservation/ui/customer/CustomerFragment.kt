package tr.mfk.cafereservation.ui.customer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import tr.mfk.cafereservation.R
import tr.mfk.cafereservation.databinding.FragmentCustomerBinding
import tr.mfk.cafereservation.databinding.FragmentMerchantBinding
import tr.mfk.cafereservation.ui.MainActivity

@AndroidEntryPoint
class CustomerFragment : Fragment() {

    private var _binding: FragmentCustomerBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView()
    }

    private fun initializeView() {
        _binding = FragmentCustomerBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).bottomNavigationVisibility(true)
    }
}