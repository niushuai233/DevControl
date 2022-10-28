package cc.niushuai.project.devcontrol.ui.powerswitch;

import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.ui.BaseActivity;
import cc.niushuai.project.devcontrol.base.util.ActivityUtil;
import cc.niushuai.project.devcontrol.base.util.Global;
import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.base.util.ToastUtil;
import cc.niushuai.project.devcontrol.databinding.ActivityPowerSwitchSetBinding;

public class PowerSwitchSetActivity extends BaseActivity {

    private ActivityPowerSwitchSetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPowerSwitchSetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.init();
        this.addListener();
    }

    @Override
    protected void init() {
        this.device = Global.getDeviceInfo(getIntentDeviceId());
        super.setTitle(getString(R.string.set), null);
    }

    @Override
    protected void addListener() {

        super.activityButtonBackClickListener(this);
        super.activityButtonMoreSetClickListener(false, null, null, null);

        binding.powerSwitchSetActivityItemIconChangeOutside.setOnClickListener(this::outsideIconChangeClickListener);
        binding.powerSwitchSetActivityItemParamSetOutside.setOnClickListener(this::outsideParamSetClickListener);
        binding.powerSwitchSetActivityItemLogViewOutside.setOnClickListener(this::outsideLogViewClickListener);
    }

    private void outsideIconChangeClickListener(View view) {
        ToastUtil.show(this, "更换图标暂未实现哦");
    }

    private void outsideParamSetClickListener(View view) {

        HashMap<String, String> withData = new HashMap<>(1);
        withData.put(Keys.ID, device.getId());
        ActivityUtil.startActivityForResult(this, PowerSwitchSetParamActivity.class, withData, Keys.RequestCode.GENERAL);
    }

    private void outsideLogViewClickListener(View view) {
        ToastUtil.show(this, "日志暂未实现哦");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}