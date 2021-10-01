package com.masai.jiocinmea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.masai.jiocinmea.adapter.BannerMoviePagerAdapter;
import com.masai.jiocinmea.adapter.MainRecyclerAdapter;
import com.masai.jiocinmea.model.AllCategory;
import com.masai.jiocinmea.model.BannerMovies;
import com.masai.jiocinmea.model.CategoryItem;

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
    Timer sliderTimer;
   NestedScrollView nestedScrollView;
   AppBarLayout appBarLayout;

    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecyclerView;
    List<AllCategory> allCategoryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indicatorTab = findViewById(R.id.tabIndicator);
        categoryTab =findViewById(R.id.tabLayout);
        nestedScrollView =findViewById(R.id.nested_scroll);
        appBarLayout =findViewById(R.id.appbar);



        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1,"Gaming Night","https://images-na.ssl-images-amazon.com/images/M/MV5BMjQxMDE5NDg0NV5BMl5BanBnXkFtZTgwNTA5MDE2NDM@._V1_SY500_CR0,0,337,500_AL_.jpg","http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"));
        homeBannerList.add(new BannerMovies(3,"Annihilation","https://images-na.ssl-images-amazon.com/images/M/MV5BNWJmMWIxMjQtZTk0Mi00YTE0LTkyNzAtYzQxYjcwYjE4ZDk2XkEyXkFqcGdeQXVyMTc4MzI2NQ@@._V1_SY500_SX350_AL_.jpg","http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"));
        homeBannerList.add(new BannerMovies(4,"Hannah","https://images-na.ssl-images-amazon.com/images/M/MV5BM2FhM2E1MTktMDYwZi00ODA1LWI0YTYtN2NjZjM3ODFjYmU5XkEyXkFqcGdeQXVyMjY1ODQ3NTA@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"));
        homeBannerList.add(new BannerMovies(5,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4"));
        homeBannerList.add(new BannerMovies(6,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNzhmNmI5MDMtZDEyOC00ODkyLTkwODItODQzODAzY2QyZjVlXkEyXkFqcGdeQXVyMzQwMTY2Nzk@._V1_SY500_CR0,0,357,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));

        tvShowBannerList = new ArrayList<>();
        tvShowBannerList.add(new BannerMovies(1,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNzhmNmI5MDMtZDEyOC00ODkyLTkwODItODQzODAzY2QyZjVlXkEyXkFqcGdeQXVyMzQwMTY2Nzk@._V1_SY500_CR0,0,357,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));
        tvShowBannerList.add(new BannerMovies(2,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));
        tvShowBannerList.add(new BannerMovies(3,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));
        tvShowBannerList.add(new BannerMovies(4,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));
        tvShowBannerList.add(new BannerMovies(5,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));

        movieBannerList = new ArrayList<>();
        movieBannerList.add(new BannerMovies(1,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));
        movieBannerList.add(new BannerMovies(2,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));
        movieBannerList.add(new BannerMovies(3,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));




        setBannerMoviePagerAdapter(homeBannerList);
        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        setScrollDefaultState();

                        setBannerMoviePagerAdapter(movieBannerList);

                            return;
                    case 2:
                        setScrollDefaultState();
                        setBannerMoviePagerAdapter(tvShowBannerList);
                        return;
                    case 3:
                        setScrollDefaultState();
                        setBannerMoviePagerAdapter(homeBannerList);
                        return;
                    case 4:
                        setScrollDefaultState();
                        setBannerMoviePagerAdapter(movieBannerList);
                    default:
                        setScrollDefaultState();
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
        //first we will add Cat_item data
        List<CategoryItem>  homeCatListItem1 = new ArrayList<>();
        homeCatListItem1.add(new CategoryItem(1,"Rahul","https://images-na.ssl-images-amazon.com/images/M/MV5BMjQxMDE5NDg0NV5BMl5BanBnXkFtZTgwNTA5MDE2NDM@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"));
        homeCatListItem1.add(new CategoryItem(2,"lloyd","https://images-na.ssl-images-amazon.com/images/M/MV5BMjQxMDE5NDg0NV5BMl5BanBnXkFtZTgwNTA5MDE2NDM@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"));
        homeCatListItem1.add(new CategoryItem(3,"siddharth","https://images-na.ssl-images-amazon.com/images/M/MV5BMjQxMDE5NDg0NV5BMl5BanBnXkFtZTgwNTA5MDE2NDM@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"));
        homeCatListItem1.add(new CategoryItem(4,"Anurag","https://images-na.ssl-images-amazon.com/images/M/MV5BMjQxMDE5NDg0NV5BMl5BanBnXkFtZTgwNTA5MDE2NDM@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"));
        homeCatListItem1.add(new CategoryItem(5,"Saveen","https://images-na.ssl-images-amazon.com/images/M/MV5BMjQxMDE5NDg0NV5BMl5BanBnXkFtZTgwNTA5MDE2NDM@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"));

        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"Watch next TV and movies",homeCatListItem1));
        allCategoryList.add(new AllCategory(2,"Movies in Hindi",homeCatListItem1));
        allCategoryList.add(new AllCategory(3,"Kids and family movies",homeCatListItem1));
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
    private void setScrollDefaultState(){
        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0,0);
        appBarLayout.setExpanded(true);
    }
}