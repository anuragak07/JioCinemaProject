package com.masai.jiocinmea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.masai.jiocinmea.adapter.BannerMoviePagerAdapter;
import com.masai.jiocinmea.adapter.MainRecyclerAdapter;
import com.masai.jiocinmea.model.AllCategory;
import com.masai.jiocinmea.model.BannerMovies;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    BannerMoviePagerAdapter bannerMoviePagerAdapter;
    TabLayout indicatorTab,categoryTab;

    ViewPager bannerMoviesViewPager2;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> movieBannerList;
    List<BannerMovies> tvShowBannerList;
    List<BannerMovies> kidsBannerList;

    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecyclerView;
    List<AllCategory> allCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indicatorTab = findViewById(R.id.tabIndicator);

        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1,"test","",""));
        homeBannerList.add(new BannerMovies(1,"test","",""));
        homeBannerList.add(new BannerMovies(1,"test","",""));
        homeBannerList.add(new BannerMovies(1,"test","",""));
        homeBannerList.add(new BannerMovies(1,"test","",""));
        homeBannerList.add(new BannerMovies(1,"test","",""));

        tvShowBannerList = new ArrayList<>();
        tvShowBannerList.add(new BannerMovies(1,"test","",""));
        tvShowBannerList.add(new BannerMovies(1,"test","",""));
        tvShowBannerList.add(new BannerMovies(1,"test","",""));
        tvShowBannerList.add(new BannerMovies(1,"test","",""));
        tvShowBannerList.add(new BannerMovies(1,"test","",""));

        movieBannerList = new ArrayList<>();
        movieBannerList.add(new BannerMovies(1,"test","",""));
        movieBannerList.add(new BannerMovies(1,"test","",""));
        movieBannerList.add(new BannerMovies(1,"test","",""));

        kidsBannerList.add(new BannerMovies(1,"test","",""));
        kidsBannerList.add(new BannerMovies(1,"test","",""));
        kidsBannerList.add(new BannerMovies(1,"test","",""));
        kidsBannerList.add(new BannerMovies(1,"test","",""));

        setBannerMoviePagerAdapter(homeBannerList);
        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        setBannerMoviePagerAdapter(movieBannerList);
                            return;
                    case 2:
                        setBannerMoviePagerAdapter(tvShowBannerList);
                        return;
                    case 3:
                        setBannerMoviePagerAdapter(kidsBannerList);
                        return;
                    default:
                        setBannerMoviePagerAdapter(homeBannerList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"Bollywood"));
        allCategoryList.add(new AllCategory(2,"Hollywood"));
        allCategoryList.add(new AllCategory(3,"Kids"));
        //set recycler Method
        setMainRecyclerView(allCategoryList);
    }
    private  void setBannerMoviePagerAdapter(List<BannerMovies> bannerMoviesList){
        bannerMoviesViewPager2 =findViewById(R.id.banner_Viewpager);
        bannerMoviePagerAdapter = new BannerMoviePagerAdapter(this,bannerMoviesList);
        bannerMoviesViewPager2.setAdapter(bannerMoviePagerAdapter);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager2);

        Timer sliderTimer  = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlide(),4000,6000);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager2,true);



    }
    class AutoSlide extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(() -> {
                if (bannerMoviesViewPager2.getCurrentItem() < homeBannerList.size() - 1) {
                    bannerMoviesViewPager2.setCurrentItem(bannerMoviesViewPager2.getCurrentItem() + 1);

                } else {
                    bannerMoviesViewPager2.setCurrentItem(0);

                }

            });
        }
    }
    public  void setMainRecyclerView(List<AllCategory> allCategoryList){
        mainRecyclerView =findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mainRecyclerView.setLayoutManager(layoutManager);
        mainRecyclerAdapter =  new MainRecyclerAdapter(this,allCategoryList);
        mainRecyclerView.setAdapter(mainRecyclerAdapter);
    }
}