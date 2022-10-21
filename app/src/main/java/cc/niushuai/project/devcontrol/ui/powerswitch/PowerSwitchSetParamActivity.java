package cc.niushuai.project.devcontrol.ui.powerswitch;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.ui.BaseActivity;
import cc.niushuai.project.devcontrol.base.util.GlobalVariables;
import cc.niushuai.project.devcontrol.databinding.ActivityPowerSwitchSetParamBinding;


public class PowerSwitchSetParamActivity extends BaseActivity {

    private ActivityPowerSwitchSetParamBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPowerSwitchSetParamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.init();
        this.addListener();
    }

    @Override
    protected void init() {
        device = GlobalVariables.getDeviceInfo(getIntentDeviceId());

        super.setTitle(getString(R.string.power_switch_set_paramSet), null);
    }

    @Override
    protected void addListener() {

        // 隐藏更多按钮
        super.activityButtonBackClickListener(this);
        super.activityButtonMoreSetClickListener(false, null, null, null);

        // 保存监听事件
        binding.powerSwitchSetActivityItemParamSetBtnSave.setOnClickListener(this::btnSaveParamClickListener);
    }

    private void btnSaveParamClickListener(View view) {

        Toast.makeText(this, "已保存", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
