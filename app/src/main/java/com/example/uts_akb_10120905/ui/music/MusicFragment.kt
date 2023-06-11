package com.example.uts_akb_10120905.ui.music

import MusicAdapter
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_akb_10120905.R

class MusicFragment : Fragment(R.layout.fragment_music) {

    private val musicAdapter = MusicAdapter()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val music = listOf(
            MusicModel(R.drawable.albumpic1, "Mardy Bum", "Arctic Monkeys",R.raw.mardybum),
            MusicModel(R.drawable.albumpic2, "The Moments", "Tame Impala",R.raw.themoment),
            MusicModel(R.drawable.albumpic2, "Eventually", " Tame Impala",R.raw.eventually),
            MusicModel(R.drawable.albumpic4, "Die For You", "Joji",R.raw.dieforyou),
            MusicModel(R.drawable.albumpic3, "Out of Time", "The Weeknd",R.raw.outoftime),
        )
        val rvmusic = getView()?.findViewById<RecyclerView>(R.id.rvmusic)
        val videoView = getView()?.findViewById<VideoView>(R.id.videoView)
        val videoPath = "android.resource://" + requireActivity().packageName + "/" + R.raw.video1

        val uri = Uri.parse(videoPath)
        videoView?.setVideoURI(uri)

        val mediaController = MediaController(requireContext())
        videoView?.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)
        mediaController.requestFocus()

        val imageButton = getView()?.findViewById<ImageButton>(R.id.play_button)
        imageButton?.setOnClickListener {
            if (!videoView?.isPlaying!!) {
                videoView.start()
                imageButton.visibility = View.GONE
            }
        }
        rvmusic?.adapter = musicAdapter
        musicAdapter.differ.submitList(music)


    }
}