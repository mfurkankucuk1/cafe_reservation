package tr.mfk.cafereservation.ui.role

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import tr.mfk.cafereservation.R
import tr.mfk.cafereservation.databinding.FragmentRoleBinding
import tr.mfk.cafereservation.ui.MainActivity
import tr.mfk.cafereservation.ui.utils.customNavigate

@AndroidEntryPoint
class RoleFragment : Fragment() {

    private var _binding: FragmentRoleBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView()

    }

    private fun initializeView() {
        _binding = FragmentRoleBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).bottomNavigationVisibility(false)
        handleClickEvents()
    }

    private fun handleClickEvents() {
        binding.apply {
            mcMerchant.setOnClickListener {
                setupChangeMenuAndNavigate(isMerchant = true)
            }
            mcCustomer.setOnClickListener {
                setupChangeMenuAndNavigate(isMerchant = false)
            }
        }

    }

    private fun setupChangeMenuAndNavigate(isMerchant: Boolean) {
        (requireActivity() as MainActivity).setupBottomNavigationMenu(isMerchant)
        if (isMerchant) {
            customNavigate(R.id.action_roleFragment_to_merchantFragment)
        } else {
            customNavigate(R.id.action_roleFragment_to_customerFragment)
        }
    }


}