package cc.niushuai.project.devcontrol.ui.nav.device;

import android.app.Dialog;
import android.content.DialogInterface;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.enums.DeviceTypeEnum;
import cc.niushuai.project.devcontrol.base.util.ActivityUtil;
import cc.niushuai.project.devcontrol.databinding.DeviceAddBinding;

public class DeviceAddDialogFragment extends DialogFragment {

    private DeviceAddBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DeviceAddBinding.inflate(getLayoutInflater());

        this.init();

        return binding.getRoot();
    }

    /**
     * 初始化入口
     *
     * @author niushuai
     * @date: 2022/10/20 17:00
     */
    private void init() {

        this.initDeviceTypeList();
    }

    /**
     * 初始化设备列表页面
     *
     * @author niushuai
     * @date: 2022/10/20 16:59
     */
    private void initDeviceTypeList() {
        GridView deviceAddGridView = binding.deviceTypeListGridView;

        SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), getDeviceTypeList(), R.layout.device_type_list,
                new String[]{
                        "device_type_list_key",
                        "device_type_list_icon",
                        "device_type_list_text"},
                new int[]{
                        R.id.device_type_list_key,
                        R.id.device_type_list_icon,
                        R.id.device_type_list_text}
        );

        deviceAddGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        deviceAddGridView.setOnItemClickListener(this::deviceTypeListItemClickListener);
        deviceAddGridView.setAdapter(simpleAdapter);
    }

    /**
     * 设备列表grid item点击事件
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     * @author niushuai
     * @date: 2022/10/20 16:59
     */
    private void deviceTypeListItemClickListener(AdapterView<?> parent, View view, int position, long id) {
        TextView keyView = view.findViewById(R.id.device_type_list_key);

        ActivityUtil.startActivity(getActivity(), DeviceTypeEnum.matchByValue(keyView.getText().toString()).getDeviceAddActivity());
    }

    /**
     * 加载初始化设备类型列表
     *
     * @author niushuai
     * @date: 2022/10/20 16:59
     * @return: {@link List<? extends Map<String,?>>}
     */
    private List<? extends Map<String, ?>> getDeviceTypeList() {

        DeviceTypeEnum[] allDeviceType = DeviceTypeEnum.values();

        List<HashMap<String, Object>> gvData = new ArrayList<>(allDeviceType.length);

        for (DeviceTypeEnum deviceType : allDeviceType) {
            HashMap<String, Object> item = new HashMap<>(3);
            item.put("device_type_list_key", deviceType.getValue());
            item.put("device_type_list_icon", deviceType.getResId());
            item.put("device_type_list_text", deviceType.getText());
            gvData.add(item);
        }

        return gvData;
    }
}
