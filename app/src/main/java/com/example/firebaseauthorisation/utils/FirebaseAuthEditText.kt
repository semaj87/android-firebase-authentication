package com.example.firebaseauthorisation.utils

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class FirebaseAuthEditText(context: Context, attributeSet: AttributeSet) : AppCompatEditText(context, attributeSet) {

    init {
        applyFont()
    }

    private fun applyFont() {
        // Used to get the file assets folder and set it to the title textview
        val typeface: Typeface = Typeface.createFromAsset(context.assets, "Montserrat-Bold.ttf")
        setTypeface(typeface)
    }
}