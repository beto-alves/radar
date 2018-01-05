package net.betoalves.radar.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import net.betoalves.radar.R;
import net.betoalves.radar.fragments.FragmentAvisos;
import net.betoalves.radar.fragments.FragmentBiz;
import net.betoalves.radar.fragments.FragmentConfira;
import net.betoalves.radar.fragments.FragmentEscola;
import net.betoalves.radar.fragments.FragmentTodos;
import net.betoalves.radar.utils.StringResourceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beto on 02/01/18.
 * Adapter do ViewPager, exibe os fragments dentro da main activity
 * fornecendo a navegação entre as abas
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    //Titulo das abas
    private final String[] tabTitles = new String[] {
            StringResourceUtil.getInstance().getString(R.string.todos),
            StringResourceUtil.getInstance().getString(R.string.escola),
            StringResourceUtil.getInstance().getString(R.string.avisos),
            StringResourceUtil.getInstance().getString(R.string.biz),
            StringResourceUtil.getInstance().getString(R.string.confira)
    };

    private List<Fragment> tabs = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initializeTabs();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    //retorna os titulos das abas
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    //Inicializa os fragments dentro do adapter
    public void initializeTabs() {
        tabs.add(FragmentTodos.newInstance());
        tabs.add(FragmentEscola.newInstance());
        tabs.add(FragmentAvisos.newInstance());
        tabs.add(FragmentBiz.newInstance());
        tabs.add(FragmentConfira.newInstance());
    }
}
