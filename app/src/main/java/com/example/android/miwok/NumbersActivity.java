package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    /* The listener gets triggered when the @link MediaPlayer has completed playing
    the audio file
     */
    private AudioManager mAudioManager;


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_lists);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //<Word> word objects instead of strings

        final ArrayList<Word> words = new ArrayList<Word>(); //contain word objects

        //this was the way below to add string such as 1
        // words.add("one");    //was <String> now <words> due to the custom class

        words.add(new Word("one", "Lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "oriiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na'aacha", R.drawable.number_eight, R.raw.number_ten));

        /*words.add("two");
        words.add("ten"); */

        //returns a view
        //getView gives to listView
        // LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
        //was ArrayAdapter now it's WordAdapter
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);
        //was simple_list_item_1 but was replaced with list-view, and android.
        // and words is replaced by
        //creating a custom class
        ListView listView = (ListView) findViewById(R.id.list);
        //listView.setAdapter(adapter);

        //TextView object stored in wordview and data type is textview

        //int index = 0; //counter variable
        //seting up while loop. You don't have to update size if used 10 you would have to

        //for(int index = 0; index < words.size(); index++){
        //  TextView wordView = new TextView(this);
        //wordView.setText(words.get(0));
        //rootView.addView(wordView);

        //ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this,
        //  android.R.layout.simple_list_item_1, words);

        //GridView listView = (GridView) findViewById(R.id.list);

        // listView.setAdapter(itemsAdapter);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Word word = words.get(position);

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }


        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        //when the activity is stopped, release the media player resources because we
        //won't be playing anymore sound.
        releaseMediaPlayer();
        //this is needed again. The other is more based on logic
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }

    }

}
