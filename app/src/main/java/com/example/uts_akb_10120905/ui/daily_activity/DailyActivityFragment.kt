package com.example.uts_akb_10120905.ui.daily_activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_akb_10120905.R
import com.google.android.material.tabs.TabLayout

class DailyActivityFragment : Fragment(R.layout.fragment_daily_activity) {

    private val friendAdapter = FriendAdapter()
    private val dailyAdapter = DailyAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val friend = listOf(
            FriendModel(R.drawable.friendpic1,"Mustapha","devops Engineer"),
            FriendModel(R.drawable.friendpic2,"Dennie","UI Developer"),
            FriendModel(R.drawable.friendpic3,"Rizka","Mobile Developer"),
            FriendModel(R.drawable.friendpic4,"Alvin","Web Developer"),
            FriendModel(R.drawable.friendpic5,"Ristian","Mobile Developer"),
        )

        val daily = listOf(
            DailyModel(R.drawable.dailypic1,"Study","Casual Study\nfor exam"),
            DailyModel(R.drawable.dailypic2,"Badminton","Weekly Badminton"),
            DailyModel(R.drawable.dailypic3,"Freelancing","Small work to\nadd experience"),
            DailyModel(R.drawable.dailypic4,"Jogging","Jog around the\ntown in the morning"),
            DailyModel(R.drawable.dailypic5,"Netflix and Chill","Watch some show\nto relax")
        )

        val rvfriend = getView()?.findViewById<RecyclerView>(R.id.rvfriend)
        rvfriend?.adapter = friendAdapter
        friendAdapter.differ.submitList(friend)

        val rvdaily = getView()?.findViewById<RecyclerView>(R.id.rvdailyactivities)
        rvdaily?.adapter = dailyAdapter
        dailyAdapter.differ.submitList(daily)
    }
}
