package cc.niushuai.project.devcontrol.ui.nav.main.log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NavLogViewModel extends ViewModel {

    private final MutableLiveData<String> vText;

    public NavLogViewModel() {
        this.vText = new MutableLiveData<>();
        this.vText.setValue("this is log view");
    }

    public MutableLiveData<String> getText() {
        return this.vText;
    }
}
