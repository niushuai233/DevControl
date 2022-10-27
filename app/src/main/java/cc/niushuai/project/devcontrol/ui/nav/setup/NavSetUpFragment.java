package cc.niushuai.project.devcontrol.ui.nav.setup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModelProvider;

import cc.niushuai.project.devcontrol.base.ui.BaseFragment;
import cc.niushuai.project.devcontrol.databinding.MainNavFragmentSetUpBinding;

public class NavSetUpFragment extends BaseFragment {

    private MainNavFragmentSetUpBinding navFragmentSetUpBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        navFragmentSetUpBinding = MainNavFragmentSetUpBinding.inflate(getLayoutInflater());

        View rootView = navFragmentSetUpBinding.getRoot();

        this.init();
        this.addListener();

        rootView.requestLayout();
        return rootView;
    }

    private void addListener() {

    }

    private void init() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        navFragmentSetUpBinding = null;
    }
}