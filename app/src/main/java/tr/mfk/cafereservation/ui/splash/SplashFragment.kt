package tr.mfk.cafereservation.ui.splash

import android.content.res.AssetManager
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import tr.mfk.cafereservation.R
import tr.mfk.cafereservation.databinding.FragmentSplashBinding
import tr.mfk.cafereservation.ui.MainActivity
import tr.mfk.cafereservation.ui.utils.customNavigate
import java.io.IOException
import java.io.InputStream
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


@AndroidEntryPoint
class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView()
    }

    private fun initializeView() {
        _binding = FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).bottomNavigationVisibility(false)
        populateUI()
        setupNavigateToRole()
    }

    private fun setupNavigateToRole() {
        Executors.newSingleThreadScheduledExecutor().schedule({
           customNavigate(R.id.action_splashFragment_to_roleFragment)
        }, 750, TimeUnit.MILLISECONDS)
    }


    private fun populateUI() {
        val assetManager: AssetManager = requireActivity().assets
        try {
            val ims: InputStream = assetManager.open("splash_bg.jpg")
            val d = Drawable.createFromStream(ims, null)
            binding.imgSplash.setImageDrawable(d)
        } catch (ex: IOException) {
            return
        }
    }


}