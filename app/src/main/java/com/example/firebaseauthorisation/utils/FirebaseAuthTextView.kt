package com.example.firebaseauthorisation.utils

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class FirebaseAuthTextView(context: Context, attributeSet: AttributeSet) : AppCompatTextView(context, attributeSet){
    init {
        // Applying fonts to the components
        applyFont()
    }

    private fun applyFont() {
        // Used to get the file assets folder and set it to the title textview
        val typeface: Typeface = Typeface.createFromAsset(context.assets, "Montserrat-Regular.ttf")
        setTypeface(typeface)
    }
}