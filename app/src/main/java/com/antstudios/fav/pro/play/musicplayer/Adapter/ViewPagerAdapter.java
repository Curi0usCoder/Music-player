package com.antstudios.fav.pro.play.musicplayer.Adapter;

import android.content.ContentResolver;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.antstudios.fav.pro.play.musicplayer.Fragments.AllSongFragment;
import com.antstudios.fav.pro.play.musicplayer.Fragments.CurrentSongFragment;
import com.antstudios.fav.pro.play.musicplayer.Fragments.FavSongFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ContentResolver contentResolver;
    private String title[] = {"All SONGS","CURRENT PLAYLIST", "FAVORITES"};

    public ViewPagerAdapter(FragmentManager fm, ContentResolver contentResolver) {
        super(fm);
        this.contentResolver = contentResolver;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AllSongFragment.getInstance(position, contentResolver);
            case 1:
                return CurrentSongFragment.getInstance(position);
            case 2:
                return FavSongFragment.getInstance(position);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
