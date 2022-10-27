package cc.niushuai.project.devcontrol.ui.nav.log;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.util.Global;
import cc.niushuai.project.devcontrol.databinding.MainNavFragmentLogBinding;
import cn.hutool.core.io.FileUtil;


public class NavLogFragment extends Fragment {

    private MainNavFragmentLogBinding navFragmentLogBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        navFragmentLogBinding = MainNavFragmentLogBinding.inflate(inflater, container, false);

        View rootView = navFragmentLogBinding.getRoot();

        TextView textView = navFragmentLogBinding.navLogFragmentTextview;
        textView.setText(FileUtil.readUtf8String(Global.logAbsolutePath()));

        rootView.requestLayout();

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        navFragmentLogBinding = null;
    }

}