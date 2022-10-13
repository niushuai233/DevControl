package cc.niushuai.project.devcontrol.ui.nav.main.device;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NavDeviceViewModel extends ViewModel {

    private final MutableLiveData<String> vText;

    public NavDeviceViewModel() {
        this.vText = new MutableLiveData<>();
        this.vText.setValue("this is device view");
    }

    public MutableLiveData<String> getText() {
        return this.vText;
    }
}
