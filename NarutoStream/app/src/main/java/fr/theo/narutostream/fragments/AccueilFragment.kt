package fr.theo.narutostream.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.theo.narutostream.EpisodeModel
import fr.theo.narutostream.EpisodeRepository.Singleton.episodeList

import fr.theo.narutostream.MainActivity
import fr.theo.narutostream.R
import fr.theo.narutostream.adapter.NarutoAdapter
import fr.theo.narutostream.adapter.NarutoEpisodeEspacement


class   AccueilFragment(private val context: MainActivity):Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_accueil, container, false)


        // récupération du recycler view qui liste les épisodes
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = NarutoAdapter(context, episodeList, R.layout.item_vertical_naruto)
        verticalRecyclerView.addItemDecoration(NarutoEpisodeEspacement())

        return view
    }

}