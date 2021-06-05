package fr.theo.narutostream.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class NarutoEpisodeEspacement:RecyclerView.ItemDecoration() {

    // définie l'espace entre les episode dans la liste sur l'accueil
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.bottom = 20
    }

}