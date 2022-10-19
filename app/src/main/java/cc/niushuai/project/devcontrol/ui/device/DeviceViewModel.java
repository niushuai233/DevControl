package cc.niushuai.project.devcontrol.ui.device;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cc.niushuai.project.devcontrol.base.entity.device.DeviceInfo;

public class DeviceViewModel extends ViewModel {

    private MutableLiveData<DeviceInfo> deviceInfo;

    public DeviceViewModel() {
    }

    public MutableLiveData<DeviceInfo> getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(MutableLiveData<DeviceInfo> deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}
