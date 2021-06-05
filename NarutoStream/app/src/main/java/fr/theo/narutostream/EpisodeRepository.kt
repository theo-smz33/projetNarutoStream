package fr.theo.narutostream

import com.google.firebase.database.*
import fr.theo.narutostream.EpisodeRepository.Singleton.databaseRef
import fr.theo.narutostream.EpisodeRepository.Singleton.episodeList
import fr.theo.narutostream.fragments.Episode

class EpisodeRepository {

    // permet d'avoir accès aux deux valeurs suivantes dans toute l'apllication
    object Singleton {
        // connexion à la référence "episodes" dans la bdd
        val databaseRef = FirebaseDatabase.getInstance("https://narutostream-a538b-default-rtdb.firebaseio.com/").getReference("episodes")

        // créer la liste qui va contenir les épisodes
        val episodeList = arrayListOf<EpisodeModel>()
    }

    fun updateData(callback:()->Unit){
        // récupère les données depuis la databaseRef pour les intégrer dans la liste d'épisodes
        databaseRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                // retirer les anciens épisodes
                episodeList.clear()
                // récupération de la liste
                for(ds in snapshot.children) {
                    // construit un objet épisode
                    val episode = ds.getValue(EpisodeModel::class.java)

                    //vérification de l'episode (si il n'est pas null)
                    if (episode != null){
                        //ajout de l'épisode dans la liste
                        episodeList.add(episode)
                    }
                }
                // actionner le callback
                callback()
            }

            override fun onCancelled(snapshot: DatabaseError) {}
        })
    }

    //mettre à jour un objet episode dans la bdd
    fun updateEpisode(episode: EpisodeModel){
        databaseRef.child(episode.id).setValue(episode)
    }

    //suppprimer un episode dans la bdd
    fun deleteEpisode(episode: EpisodeModel){
        databaseRef.child(episode.id).removeValue()
    }
}






