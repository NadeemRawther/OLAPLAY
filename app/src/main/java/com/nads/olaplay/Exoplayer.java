package com.nads.olaplay;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Exoplayer extends AppCompatActivity {
public static final int play_pos = 1;
protected static final String plo = "ds";
public static final String play_url = "https://";
    public Exoplayer() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exoplayer_play);
        Intent intent = getIntent();
        int valur = intent.getIntExtra(String.valueOf(play_pos),play_pos);
        String valur2 = intent.getStringExtra(play_url);
        Handler mainHandler = new Handler();
        Uri f =  Uri.parse("http://hck.re/Rh8KTk");
        DefaultBandwidthMeter andwidthMeter = new DefaultBandwidthMeter();
        //BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory =
        new AdaptiveTrackSelection.Factory(andwidthMeter);
        TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);
        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(Exoplayer.this, trackSelector);
        SimpleExoPlayerView simpleExoPlayerView =(SimpleExoPlayerView)findViewById(R.id.exoplayer);
        simpleExoPlayerView.setPlayer(player);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
        Util.getUserAgent(this, "OLAPLAY"), andwidthMeter);
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        if(f.isAbsolute()){
            Toast toast = Toast.makeText(this,"gotch",Toast.LENGTH_LONG);
            toast.show();}
        ExtractorMediaSource videoSource = new ExtractorMediaSource(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4")/*Uri.parse("http://hck.re/Rh8KTk")*/,dataSourceFactory,extractorsFactory,null, null);
        player.prepare(videoSource);
        player.setPlayWhenReady(true);
    }
}
