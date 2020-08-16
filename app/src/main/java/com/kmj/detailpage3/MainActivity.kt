package com.kmj.detailpage3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab_layout.addTab(tab_layout.newTab().setText("에땅"))
        tab_layout.addTab(tab_layout.newTab().setText("comment"))

        tab_layout.getTabAt(0)?.setIcon(R.drawable.home)
        tab_layout.getTabAt(1)?.setIcon(R.drawable.comment)

        val pagerAdapter = PagerAdapter(supportFragmentManager, 2)
        view_pager.adapter = pagerAdapter

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position
            }
        })
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
    }
}

    class PagerAdapter(
        fragmentManager: FragmentManager,
        val tabCount: Int
    ) : FragmentStatePagerAdapter(fragmentManager) {

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> {
                    return Detail_page3()
                }
                1 -> {
                    return CommentTemp()
                }

                else -> return Detail_page3()
            }
        }

        override fun getCount(): Int {
            return tabCount
        }
    }
