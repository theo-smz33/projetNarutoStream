package fr.theo.narutostream

import android.app.Dialog
import android.content.Context
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import fr.theo.narutostream.adapter.NarutoAdapter
import fr.theo.narutostream.fragments.AccueilFragment
import fr.theo.narutostream.fragments.ModifEpisodeFragment
import fr.theo.narutostream.fragments.SaisonFragment

// méthode d"appel du fragment popup (détail de l'épisode)
class DetailEpisode(
    private val adapter: NarutoAdapter,
    private val currentEpisode: EpisodeModel
    ) : Dialog(adapter.context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_detail_episode)
        setupCloseButton()
        setupComponents()
        setupModifButton()
        setupDeleteButton()
    }

    private fun setupComponents(){
        //actualiser le titre de l'épisode
        findViewById<TextView>(R.id.detail_nom_episode).text = currentEpisode.titre

        //actualiser la description de l'épisode
        findViewById<TextView>(R.id.details_descriptionEpisode_sub).text = currentEpisode.description

        //actualiser la durée de l'épisode
        findViewById<TextView>(R.id.details_dureeEpisode_sub).text = currentEpisode.duree

        //actualiser le numéro de l'épisode
        findViewById<TextView>(R.id.details_numeroEpisode_sub).text = currentEpisode.numero

        //actualiser la saison de l'épisode
        findViewById<TextView>(R.id.details_saison_sub).text = currentEpisode.saison

    }

    private fun setupCloseButton(){
        //fermeture de la popup lorsque l'on click sur la croix (dans la popup)
        findViewById<ImageView>(R.id.close_bouton_detail).setOnClickListener{
            // fermer le popup
            dismiss()
        }
    }

    private fun setupDeleteButton(){
        findViewById<ImageView>(R.id.ic_trash).setOnClickListener {
            //supprime la plante de la bdd
            val repo = EpisodeRepository()
            repo.deleteEpisode(currentEpisode)
        }
    }

    private fun setupModifButton(){
        findViewById<ImageView>(R.id.ic_trash).setOnClickListener {
            //supprime la plante de la bdd
            val repo = EpisodeRepository()
            repo.deleteEpisode(currentEpisode)
        }
    }

}
