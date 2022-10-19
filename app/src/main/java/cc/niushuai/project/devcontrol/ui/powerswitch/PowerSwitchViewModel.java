package cc.niushuai.project.devcontrol.ui.powerswitch;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cc.niushuai.project.devcontrol.base.entity.device.DeviceInfo;

public class PowerSwitchViewModel extends ViewModel {

    private MutableLiveData<DeviceInfo> deviceInfo;

    public PowerSwitchViewModel() {
    }

    public MutableLiveData<DeviceInfo> getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(MutableLiveData<DeviceInfo> deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}
