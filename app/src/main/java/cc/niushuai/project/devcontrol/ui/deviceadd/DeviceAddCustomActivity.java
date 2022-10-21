package cc.niushuai.project.devcontrol.ui.deviceadd;

import android.os.Bundle;

import cc.niushuai.project.devcontrol.base.ui.BaseActivity;
import cc.niushuai.project.devcontrol.databinding.ActivityDeviceAddCustomBinding;

public class DeviceAddCustomActivity extends BaseActivity {

    private ActivityDeviceAddCustomBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDeviceAddCustomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.init();
        this.addListener();
    }

    /**
     * 初始化方法
     *
     * @author niushuai
     * @date: 2022/10/19 15:54
     */
    @Override
    protected void init() {

    }

    /**
     * 监听器事件统一设置入口
     *
     * @author niushuai
     * @date: 2022/10/19 17:31
     */
    @Override
    protected void addListener() {
        super.addListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}