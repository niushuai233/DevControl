package cc.niushuai.project.devcontrol.ui.device;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import cc.niushuai.project.devcontrol.databinding.DeviceOperateBinding;
/**
 * 设备操作页面
 *
 * @author niushuai
 * @date: 2022/10/17 17:41
 * @return: {@link }
 */
public class DeviceOperate extends Fragment {

    private DeviceOperateBinding thisBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        thisBinding = DeviceOperateBinding.inflate(inflater, container, false);

        CharSequence text = thisBinding.deviceOperateFullInfo.getText();
        System.out.println(text);

        return thisBinding.getRoot();
    }

}
