package com.softradix.templis.ui.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.softradix.templis.R
import com.softradix.templis.databinding.ActivityMainBinding
import com.softradix.templis.ui.fragments.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setTheme(R.style.FullScreen)

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.statusBarColor = ContextCompat.getColor(this,R.color.black);
        binding.root.apply { setContentView(this) }


        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val graphInflater = navHostFragment.navController.navInflater
        val navGraph = graphInflater.inflate(R.navigation.dashboard_nav_graph)
        val navController = navHostFragment.navController
        navGraph.startDestination = R.id.homeFragment
        navController.graph = navGraph


        binding.navigationViewBtn.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        val navOptions = NavOptions.Builder()
//            .setLaunchSingleTop(true)
//            .setEnterAnim(R.anim.fade_in)
//            .setExitAnim(R.anim.fade_out)
//            .setPopEnterAnim(R.anim.fade_in)
//            .setPopExitAnim(R.anim.fade_out)
            .setPopUpTo(navController.graph.startDestination, true)
            .build()


        binding.tabsLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
//                    0 -> navController.navigate(R.id.homeFragment, null, navOptions)
//                    1 -> navController.navigate(R.id.homeFragment, null, navOptions)
//                    2 -> navController.navigate(R.id.homeFragment, null, navOptions)
                /*
                    1 -> navController.navigate(R.id.tvFragment, null, navOptions)
                    2 -> navController.navigate(R.id.moviesFragment, null, navOptions)
                    3 -> navController.navigate(R.id.sportsFragment, null, navOptions)*/
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        onClickEvents(navController)

        fun setUi(imageView: AppCompatImageView, textView: AppCompatTextView) {
            binding.nav.icHome.background = ContextCompat.getDrawable(this, R.drawable.gray_bg)
            binding.nav.icProfile.background = ContextCompat.getDrawable(this, R.drawable.gray_bg)
            binding.nav.icPayment.background = ContextCompat.getDrawable(this, R.drawable.gray_bg)
            binding.nav.icTicket.background = ContextCompat.getDrawable(this, R.drawable.gray_bg)
            binding.nav.icLive.background = ContextCompat.getDrawable(this, R.drawable.gray_bg)
            binding.nav.icPrivacyPolicy.background =
                ContextCompat.getDrawable(this, R.drawable.gray_bg)

            imageView.background = ContextCompat.getDrawable(this, R.drawable.button_bg)

            binding.nav.tvHome.setTextColor(ContextCompat.getColor(this, R.color.grayColor))
            binding.nav.tvProfile.setTextColor(ContextCompat.getColor(this, R.color.grayColor))
            binding.nav.tvPayment.setTextColor(ContextCompat.getColor(this, R.color.grayColor))
            binding.nav.tvMyTickets.setTextColor(ContextCompat.getColor(this, R.color.grayColor))
            binding.nav.tvLive.setTextColor(ContextCompat.getColor(this, R.color.grayColor))
            binding.nav.tvPrivacyPolicy.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.grayColor
                )
            )

            textView.setTextColor(ContextCompat.getColor(this, R.color.orange))

        }
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.detailsFragment -> {
                    binding.appBar.visibility = View.GONE
                }
                R.id.homeFragment -> {
                    Handler(Looper.getMainLooper()).postDelayed({
                        binding.appBar.visibility = View.VISIBLE
                        setUi(binding.nav.icHome, binding.nav.tvHome)
                    }, 300)

                }
                R.id.paymentsFragment -> {
                    binding.appBar.visibility = View.GONE
                    setUi(binding.nav.icPayment, binding.nav.tvPayment)

                }
                R.id.myTicketsFragment -> {
                    binding.appBar.visibility = View.GONE
                    setUi(binding.nav.icTicket, binding.nav.tvMyTickets)

                }
                R.id.privacyPolicyFragment -> {
                    binding.appBar.visibility = View.GONE
                    setUi(binding.nav.icPrivacyPolicy, binding.nav.tvPrivacyPolicy)
                }
                R.id.liveFragment -> {
                    binding.appBar.visibility = View.GONE
                    setUi(binding.nav.icLive, binding.nav.tvLive)

                }
            }
        }

    }

    private fun onClickEvents(navController: NavController) {
        binding.nav.homeBtn.setOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            navController.navigate(R.id.homeFragment)

        }
        binding.nav.profileBtn.setOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
//            navController.navigate(R.id.profileFragment)

        }
        binding.nav.paymentBtn.setOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
//            val action = HomeFragmentDirections
//            navController.navigate(R.id.paymentsFragment)

        }
        binding.nav.myTicketsBtn.setOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            val action = HomeFragmentDirections.actionHomeFragmentToMyTicketsFragment()
            navController.navigate(action)

        }
        binding.nav.liveBtn.setOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            val action = HomeFragmentDirections.actionHomeFragmentToLiveFragment2()
            navController.navigate(action)

        }
        binding.nav.privacyPolicyBtn.setOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
//            navController.navigate(R.id.privacyPolicyFragment)

        }
        binding.nav.logoutBtn.setOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)

        }
    }
}