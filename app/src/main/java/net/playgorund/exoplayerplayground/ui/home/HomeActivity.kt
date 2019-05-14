package net.playgorund.exoplayerplayground.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import net.playgorund.exoplayerplayground.R
import javax.inject.Inject

class HomeActivity : AppCompatActivity() , HasSupportFragmentInjector {


    @Inject
    lateinit var fragmentInjector  : DispatchingAndroidInjector<Fragment>
    private lateinit var navController: NavController




    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        initNavigationController()
    }



    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }



    private fun initNavigationController() {

        navController = Navigation.findNavController(this , R.id.nav_host_fragment)

    }


}
