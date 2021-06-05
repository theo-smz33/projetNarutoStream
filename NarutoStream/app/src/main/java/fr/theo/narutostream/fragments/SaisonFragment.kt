package fr.theo.narutostream.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.theo.narutostream.MainActivity
import fr.theo.narutostream.R

class SaisonFragment(private val context: MainActivity): Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // création du fragment qui liste les saison
        return inflater?.inflate(R.layout.fragment_saison, container, false)
    }
}