package net.betoalves.radar.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import net.betoalves.radar.R;
import net.betoalves.radar.adapters.ViewPagerAdapter;
import net.betoalves.radar.mvp.interfaces.ITodosFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by beto on 01/01/18.
 */

public class MainActivity extends AppCompatActivity {

    /**
     * Instancia e realiza o bind das views da tela principal
     * utilizando a biblioteca butterknife
     */
    @BindView(R.id.toolbar_main_activity) Toolbar mToolbar;
    @BindView(R.id.tabLayout_main_activity) TabLayout mTablayout;
    @BindView(R.id.viewPager_main_activity) ViewPager mViewpager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        //Inicializa o tablayout com o viewpager para setar as abas do mesmo.
        mTablayout.setupWithViewPager(mViewpager);
        //define o espaçamento dos elementos do viewpager na tela
        mTablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Seta o adapter para o view pager
        mViewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }

}