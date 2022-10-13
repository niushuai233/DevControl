package cc.niushuai.project.devcontrol.ui.nav.main.device;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import cc.niushuai.project.devcontrol.databinding.MainNavFragmentDeviceBinding;

/**
 * 设备页面ui
 *
 * @author niushuai
 * @date: 2022/10/13 10:58
 */
public class NavDeviceFragment extends Fragment {

    private MainNavFragmentDeviceBinding navFragmentDeviceBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        navFragmentDeviceBinding = MainNavFragmentDeviceBinding.inflate(inflater, container, false);

        NavDeviceViewModel navDeviceViewModel = new ViewModelProvider(this).get(NavDeviceViewModel.class);
        View rootView = navFragmentDeviceBinding.getRoot();

        TextView textView = navFragmentDeviceBinding.navDeviceFragmentTextview;

        navDeviceViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        navFragmentDeviceBinding = null;
    }
}