package cc.niushuai.project.devcontrol.ui.nav.main.device;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.gridlayout.widget.GridLayout;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.databinding.MainNavFragmentDeviceBinding;

/**
 * 设备页面ui
 *
 * @author niushuai
 * @date: 2022/10/13 10:58
 */
public class NavDeviceFragment extends Fragment {

    private MainNavFragmentDeviceBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = MainNavFragmentDeviceBinding.inflate(inflater, container, false);

        NavDeviceViewModel navDeviceViewModel = new ViewModelProvider(this).get(NavDeviceViewModel.class);
        View rootView = binding.getRoot();

//        TextView textView = navFragmentDeviceBinding.navDeviceFragmentTextview;
//
//        navDeviceViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        setDevices();

        return rootView;
    }

    private void setDevices() {

//        GridLayout deviceGridLayout = binding.deviceGridLayout;
        GridView deviceGv = binding.deviceGv;
        deviceGv.setSelector(new ColorDrawable(Color.TRANSPARENT));

        List<HashMap<String, Object>> dataItem = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            HashMap<String, Object> m1 = new HashMap<>();

            m1.put("device_item_cardView_image", R.drawable.ic_device_light_1);
            m1.put("device_item_cardView_text", "卧室灯" + i);
            dataItem.add(m1);
        }

//        SimpleAdapter gvAdapter = new SimpleAdapter(getContext(), dataItem, R.layout.device_item,
//                new String[]{"device_item_cardView_text"}, new int[]{R.id.device_item_cardView_text});

        SimpleAdapter gvAdapter = new SimpleAdapter(getContext(), dataItem, R.layout.device_item,
                new String[]{"device_item_cardView_image", "device_item_cardView_text"}, new int[]{R.id.device_item_cardView_image, R.id.device_item_cardView_text});

        deviceGv.setAdapter(gvAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}