package fr.theo.narutostream.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.theo.narutostream.*
import fr.theo.narutostream.EpisodeRepository.Singleton.episodeList
import fr.theo.narutostream.fragments.Episode

class  NarutoAdapter(
        val context: MainActivity,
        private val episodeList: List<EpisodeModel>,
        private val layoutId: Int
) : RecyclerView.Adapter<NarutoAdapter.ViewHolder>(){

    // boîte pour ranger tout les composants à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        //image de l'episode
        val episodeImage = view.findViewById<ImageView>(R.id.image_item)
        val episodeTitre:TextView? = view.findViewById(R.id.nom_episode)
        val episodeDescription:TextView? = view.findViewById(R.id.description_episode)
        val episodeDuree:TextView? = view.findViewById(R.id.details_dureeEpisode)
        val episodeNumero:TextView? = view.findViewById(R.id.details_numeroEpisode)
        val episodeSaison:TextView? = view.findViewById(R.id.description_episode)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //récupère les information de l'épisode
        val currentEpisode = episodeList[position]

        //récupère le repository
        var repo = EpisodeRepository()

        //mise à jour des composants des épisodes
        holder.episodeTitre?.text = currentEpisode.titre
        holder.episodeDescription?.text = currentEpisode.description

        holder.itemView.setOnClickListener {
            //affichage de la popup detail
            DetailEpisode(this, currentEpisode).show()
        }
        repo.updateEpisode(currentEpisode)
    }

    // donnée temporaire: affiche le nombre d'épisode à lister sur l'accueil. Cela sera remplacé plus tard par les épisodes récupérés dans le sgbd
    override fun getItemCount(): Int = episodeList.size

}