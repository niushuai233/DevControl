package cc.niushuai.project.devcontrol.ui.nav.device;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.entity.device.DeviceInfo;
import cc.niushuai.project.devcontrol.databinding.DeviceItemBinding;
import cc.niushuai.project.devcontrol.databinding.MainNavFragmentDeviceBinding;
import cc.niushuai.project.devcontrol.ui.device.DeviceActivity;
import cn.hutool.core.util.RandomUtil;

/**
 * 设备页面ui
 *
 * @author niushuai
 * @date: 2022/10/13 10:58
 */
public class NavDeviceFragment extends Fragment {

    private MainNavFragmentDeviceBinding deviceBinding;
    private DeviceItemBinding deviceItemBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        deviceBinding = MainNavFragmentDeviceBinding.inflate(inflater, container, false);
        deviceItemBinding = DeviceItemBinding.inflate(inflater, container, false);

        NavDeviceViewModel navDeviceViewModel = new ViewModelProvider(this).get(NavDeviceViewModel.class);
        View rootView = deviceBinding.getRoot();

//        TextView textView = navFragmentDeviceBinding.navDeviceFragmentTextview;
//
//        navDeviceViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        setDevices();

        return rootView;
    }

    private void setDevices() {

//        GridLayout deviceGridLayout = binding.deviceGridLayout;
        GridView deviceGv = deviceBinding.deviceGv;
        deviceGv.setSelector(new ColorDrawable(Color.TRANSPARENT));

        deviceGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View text = view.findViewById(R.id.device_item_cardView_id);
                String x = ";";
                if (text != null) {
                    x = ((TextView) text).getText().toString();
                }
                Toast.makeText(getContext(), "Item Clicked" + x, Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getActivity(), DeviceActivity.class));
            }
        });

//        SimpleAdapter gvAdapter = new SimpleAdapter(getContext(), dataItem, R.layout.device_item,
//                new String[]{"device_item_cardView_text"}, new int[]{R.id.device_item_cardView_text});

        SimpleAdapter gvAdapter = new SimpleAdapter(getContext(), loadDeviceInfo(), R.layout.device_item,
                new String[]{"device_item_cardView_id", "device_item_cardView_image", "device_item_cardView_text"},
                new int[]{R.id.device_item_cardView_id, R.id.device_item_cardView_image, R.id.device_item_cardView_text});

        deviceGv.setAdapter(gvAdapter);
    }

    /**
     * 读取数据 加载数据库信息
     *
     * @author niushuai
     * @date: 2022/10/17 16:58
     * @return: {@link List<HashMap<String, Object>>}
     */
    private List<HashMap<String, Object>> loadDeviceInfo() {
        List<HashMap<String, Object>> gvData = new ArrayList<>();

        // 此处数据要加载为真实数据
        List<DeviceInfo> list = DeviceInfo.mock(RandomUtil.randomInt(9, 27), R.drawable.ic_device_light_1);

        // 循环处理数据
        for (DeviceInfo deviceInfo : list) {

            HashMap<String, Object> m1 = new HashMap<>();
            // 设置当前设备的图标和名称
            m1.put("device_item_cardView_id", deviceInfo.getId());
            m1.put("device_item_cardView_image", deviceInfo.getIconId());
            m1.put("device_item_cardView_text", deviceInfo.getName());

            // 统一添加到data中
            gvData.add(m1);
        }
        return gvData;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        deviceBinding = null;
        deviceItemBinding = null;
    }
}