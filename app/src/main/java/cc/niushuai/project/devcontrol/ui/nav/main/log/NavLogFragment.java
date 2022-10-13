package cc.niushuai.project.devcontrol.ui.nav.main.log;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import cc.niushuai.project.devcontrol.databinding.MainNavFragmentLogBinding;


public class NavLogFragment extends Fragment {

    private MainNavFragmentLogBinding navFragmentLogBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        navFragmentLogBinding = MainNavFragmentLogBinding.inflate(inflater, container, false);

        NavLogViewModel navLogViewModel = new ViewModelProvider(this).get(NavLogViewModel.class);
        View rootView = navFragmentLogBinding.getRoot();

        TextView textView = navFragmentLogBinding.navLogFragmentTextview;

        navLogViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        navFragmentLogBinding = null;
    }

}