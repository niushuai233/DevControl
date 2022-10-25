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

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.util.GlobalVariables;
import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.databinding.DeviceItemBinding;
import cc.niushuai.project.devcontrol.databinding.MainNavFragmentDeviceBinding;
import cc.niushuai.project.devcontrol.vo.DeviceInfo;

/**
 * 设备页面ui
 *
 * @author niushuai
 * @date: 2022/10/13 10:58
 */
public class NavDeviceFragment extends Fragment {

    private MainNavFragmentDeviceBinding binding;
    private DeviceItemBinding deviceItemBinding;
    private List<DeviceInfo> deviceInfoList;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = MainNavFragmentDeviceBinding.inflate(inflater, container, false);
        deviceItemBinding = DeviceItemBinding.inflate(inflater, container, false);

        NavDeviceViewModel navDeviceViewModel = new ViewModelProvider(this).get(NavDeviceViewModel.class);
        View rootView = binding.getRoot();

//        TextView textView = navFragmentDeviceBinding.navDeviceFragmentTextview;
//
//        navDeviceViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        setDevices();

        this.addListener();

        return rootView;
    }


    private void addListener() {
        binding.deviceAdd.setOnClickListener(this::deviceAddClickListener);
    }

    private void deviceAddClickListener(View view) {

        DeviceAddDialogFragment dialogFragment = new DeviceAddDialogFragment();
        dialogFragment.show(getActivity().getSupportFragmentManager(), DeviceAddDialogFragment.class.getName());
    }

    private void setDevices() {

        deviceInfoList = GlobalVariables.DEVICE_INFO_MAP.values()
                .stream()
                .sorted(Comparator.comparingInt(DeviceInfo::getOrder))
                .collect(Collectors.toList());

//        GridLayout deviceGridLayout = binding.deviceGridLayout;
        GridView deviceGv = binding.deviceGv;
        deviceGv.setSelector(new ColorDrawable(Color.TRANSPARENT));

        deviceGv.setOnItemClickListener(this::onItemClick);

//        SimpleAdapter gvAdapter = new SimpleAdapter(getContext(), dataItem, R.layout.device_item,
//                new String[]{"device_item_cardView_text"}, new int[]{R.id.device_item_cardView_text});

        List<HashMap<String, Object>> data = loadDeviceInfo();
        SimpleAdapter gvAdapter = new SimpleAdapter(getContext(), data, R.layout.device_item,
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
//        List<DeviceInfo> list = DeviceInfo.mock(RandomUtil.randomInt(9, 27), R.drawable.ic_device_light_1);

        // 循环处理数据
        for (DeviceInfo deviceInfo : deviceInfoList) {

            HashMap<String, Object> m1 = new HashMap<>();
            // 设置当前设备的图标和名称
            m1.put("device_item_cardView_id", deviceInfo.getId());
            m1.put("device_item_cardView_image", deviceInfo.getIconId());
            m1.put("device_item_cardView_text", deviceInfo.getDeviceName());

            // 统一添加到data中
            gvData.add(m1);
        }
        return gvData;
    }

    /**
     * 条目点击事件
     *
     * @param parent   父view
     * @param view     被点击的view
     * @param position 当前view中的位置顺序
     * @param id       组件id
     * @author niushuai
     * @date: 2022/10/19 11:13
     */
    private void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textId = view.findViewById(R.id.device_item_cardView_id);

        Intent intent = new Intent(getActivity(), GlobalVariables.getDeviceOperateActivity(textId.getText().toString()));
        intent.putExtra(Keys.ID, textId.getText());
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        deviceItemBinding = null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.
     */
    @Override
    public void onResume() {
        super.onResume();
        // 重新初始化值
        GlobalVariables.initDeviceInfoMap();
        this.setDevices();
    }
}