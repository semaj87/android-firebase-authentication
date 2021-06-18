package com.example.firebaseauthorisation.utils

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class FirebaseAuthButton(context: Context, attributeSet: AttributeSet) : AppCompatButton(context, attributeSet) {

    init {
        applyFont()
    }

    private fun applyFont() {
        // Used to get the file assets folder and set it to the title textview
        val typeface: Typeface = Typeface.createFromAsset(context.assets, "Montserrat-Bold.ttf")
        setTypeface(typeface)
    }
}