package cc.niushuai.project.devcontrol.ui.nav.setup;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NavSetUpViewModel extends ViewModel {
    private final MutableLiveData<String> vText;

    public NavSetUpViewModel() {
        this.vText = new MutableLiveData<>();
        this.vText.setValue("this is setup view");
    }

    public MutableLiveData<String> getText() {
        return this.vText;
    }

}
