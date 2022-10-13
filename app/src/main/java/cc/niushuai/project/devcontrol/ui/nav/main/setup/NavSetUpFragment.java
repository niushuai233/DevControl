package cc.niushuai.project.devcontrol.ui.nav.main.setup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import cc.niushuai.project.devcontrol.databinding.MainNavFragmentSetUpBinding;


public class NavSetUpFragment extends Fragment {

    private MainNavFragmentSetUpBinding navFragmentSetUpBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        navFragmentSetUpBinding = MainNavFragmentSetUpBinding.inflate(inflater, container, false);

        NavSetUpViewModel navSetUpViewModel = new ViewModelProvider(this).get(NavSetUpViewModel.class);
        View rootView = navFragmentSetUpBinding.getRoot();

        TextView textView = navFragmentSetUpBinding.navSetupFragmentTextview;

        navSetUpViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        navFragmentSetUpBinding = null;
    }
}