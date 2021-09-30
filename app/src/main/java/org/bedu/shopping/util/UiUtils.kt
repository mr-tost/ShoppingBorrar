package org.bedu.shopping.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

object UiUtils {

    fun showSnackbar(view: View, textId: Int, actionTextId: Int ){
        Snackbar.make(
            view,
            textId,
            Snackbar.LENGTH_LONG
        )
            .setAction(
                actionTextId
            ) { }
            .show()
    }

}