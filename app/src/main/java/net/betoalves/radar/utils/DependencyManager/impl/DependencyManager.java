package net.betoalves.radar.utils.DependencyManager.impl;

import net.betoalves.radar.mvp.implementation.TodosPresenter;
import net.betoalves.radar.mvp.interfaces.ITodosPresenter;

/**
 * Created by beto on 02/01/2018.
 */

public class DependencyManager extends BaseDependencyManger {
    @Override
    protected void linkDependecies() {
        //link(VendaGeradorMvp.IVendaFirstPagePresenter.class, VendaFirstPagePresenter.class);
        link(ITodosPresenter.class, TodosPresenter.class);

    }

    private static DependencyManager instance;

    public static DependencyManager getInstance() {
        if(instance == null){
            instance = new DependencyManager();
        }
        return instance;
    }
}
