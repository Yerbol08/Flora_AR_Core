package com.enu.flora.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.enu.flora.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class VideoAdapter(private val videoIds: Array<String>, private val lifecycle: Lifecycle) :RecyclerView.Adapter<VideoAdapter.ViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoAdapter.ViewHolder {
        val youTubePlayerView = LayoutInflater.from(parent.context)
            .inflate(R.layout.video_layout, parent, false) as YouTubePlayerView
        lifecycle!!.addObserver(youTubePlayerView)
        return ViewHolder(youTubePlayerView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.cueVideo(videoIds[position])
    }



    class ViewHolder(private val youTubePlayerView: YouTubePlayerView) : RecyclerView.ViewHolder(
        youTubePlayerView
    ) {
        private var youTubePlayer: YouTubePlayer? = null
        private var currentVideoId: String? = null
        fun cueVideo(videoId: String?) {
            currentVideoId = videoId
            if (youTubePlayer == null) return
            youTubePlayer!!.cueVideo(videoId!!, 0f)
        }

        init {
            youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(initializedYouTubePlayer: YouTubePlayer) {
                    youTubePlayer = initializedYouTubePlayer
                    youTubePlayer!!.cueVideo(currentVideoId!!, 0f)
                }
            })
        }
    }



//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val youTubePlayerView = LayoutInflater.from(parent.context)
//            .inflate(R.layout.video_layout, parent, false) as YouTubePlayerView
//        lifecycle!!.addObserver(youTubePlayerView)
//        return ViewHolder(youTubePlayerView)
//
//    }


    override fun getItemCount(): Int {
        return videoIds.size
    }

}