package tr.mfk.cafereservation.ui.utils

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


fun View.visible(){
    this.visibility = View.VISIBLE
}

fun View.invisible(){
    this.visibility = View.INVISIBLE
}

fun View.gone(){
    this.visibility = View.GONE
}

fun Fragment.customNavigate(navigateId:Int,bundle: Bundle ?= null){
    bundle?.let {
        findNavController().navigate(navigateId,bundle)
    }?:run {
        findNavController().navigate(navigateId)
    }
}