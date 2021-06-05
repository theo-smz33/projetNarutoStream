package fr.theo.narutostream

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import fr.theo.narutostream.fragments.AccueilFragment
import fr.theo.narutostream.fragments.ModifEpisodeFragment
import fr.theo.narutostream.fragments.SaisonFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // déclaration de la premiere page qui s'ouvre lorsqu'on lance l'application
        loadFragment(AccueilFragment(this), R.string.accueil_nomPage)

        // importation de la barre de navigation
        val navbar = findViewById<BottomNavigationView>(R.id.navbar)
        navbar.setOnNavigationItemReselectedListener {
            // when est l'équivalent de switch en java
            when (it.itemId) {
                // charge le fragment accueil quand on click sur accueil dans la navbar
                R.id.navbar_accueil -> {
                    // appel la méthode loadFragment() qui définie quel fragment appeler
                    loadFragment(AccueilFragment(this), R.string.accueil_nomPage)
                    true
                }
                // charge le fragment saison quand on click sur saison dans la navbar
                R.id.navbar_saison -> {
                    // appel la méthode loadFragment() qui définie quel fragment appeler
                    loadFragment(SaisonFragment(this), R.string.saison_nomPage)
                    true
                }
            }
        }
    }

    //la méthode loadFragment()  définie quel fragment appeler, dans ce cas: AccueilFragment
    private fun loadFragment(fragment: AccueilFragment, string: Int) {
        //charger le repository
        val repo = EpisodeRepository()

        //actualisation du titre de la page
        findViewById<TextView>(R.id.page_title).text = resources.getString(string)

        //mettre à jour la liste des épisodes
        repo.updateData {
            // injection du fragment "accueil" dans l'espace dédier (fragment_container qui se trouve dans activity main)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }


    //la méthode loadFragment()  définie quel fragment appeler, dans ce cas: SaisonFragment
    private fun loadFragment(fragment: SaisonFragment, string: Int) {

        //actualisation du titre de la page
        findViewById<TextView>(R.id.page_title).text = resources.getString(string)

        // injection du fragment "saison" dans l'espace dédier (fragment_container qui se trouve dans activity main)
        val transaction = supportFragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

