package com.twtstudio.retrox.auth.databinding;
import com.twtstudio.retrox.auth.R;
import com.twtstudio.retrox.auth.BR;
import android.view.View;
public class ActivityLoginBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.image_login_username, 8);
        sViewsWithIds.put(R.id.image_login_password, 9);
    }
    // views
    public final android.widget.EditText editText;
    public final android.widget.ImageView imageLoginPassword;
    public final android.widget.ImageView imageLoginUsername;
    private final android.widget.FrameLayout mboundView0;
    private final android.widget.EditText mboundView2;
    private final android.widget.Button mboundView3;
    private final android.widget.Button mboundView4;
    private final android.widget.TextView mboundView5;
    private final android.widget.TextView mboundView6;
    private final android.widget.ProgressBar mboundView7;
    // variables
    private com.twtstudio.retrox.auth.login.LoginViewModel mViewModel;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener editTextandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.twtuName.get()
            //         is viewModel.twtuName.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(editText);
            // localize variables for thread safety
            // viewModel.twtuName.get()
            java.lang.String viewModelTwtuNameGet = null;
            // viewModel.twtuName != null
            boolean viewModelTwtuNameJavaLangObjectNull = false;
            // viewModel
            com.twtstudio.retrox.auth.login.LoginViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.twtuName
            android.databinding.ObservableField<java.lang.String> viewModelTwtuName = null;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelTwtuName = viewModel.twtuName;

                viewModelTwtuNameJavaLangObjectNull = (viewModelTwtuName) != (null);
                if (viewModelTwtuNameJavaLangObjectNull) {




                    viewModelTwtuName.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView2androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.twtpasswd.get()
            //         is viewModel.twtpasswd.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView2);
            // localize variables for thread safety
            // viewModel.twtpasswd
            android.databinding.ObservableField<java.lang.String> viewModelTwtpasswd = null;
            // viewModel
            com.twtstudio.retrox.auth.login.LoginViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.twtpasswd.get()
            java.lang.String viewModelTwtpasswdGet = null;
            // viewModel.twtpasswd != null
            boolean viewModelTwtpasswdJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelTwtpasswd = viewModel.twtpasswd;

                viewModelTwtpasswdJavaLangObjectNull = (viewModelTwtpasswd) != (null);
                if (viewModelTwtpasswdJavaLangObjectNull) {




                    viewModelTwtpasswd.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityLoginBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 3);
        final Object[] bindings = mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds);
        this.editText = (android.widget.EditText) bindings[1];
        this.editText.setTag(null);
        this.imageLoginPassword = (android.widget.ImageView) bindings[9];
        this.imageLoginUsername = (android.widget.ImageView) bindings[8];
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.EditText) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.Button) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.Button) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.ProgressBar) bindings[7];
        this.mboundView7.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.viewModel :
                setViewModel((com.twtstudio.retrox.auth.login.LoginViewModel) variable);
                return true;
        }
        return false;
    }

    public void setViewModel(com.twtstudio.retrox.auth.login.LoginViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }
    public com.twtstudio.retrox.auth.login.LoginViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelTwtuName((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelTwtpasswd((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeViewModelMViewStyleIsProgressRefreshing((android.databinding.ObservableBoolean) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelTwtuName(android.databinding.ObservableField<java.lang.String> ViewModelTwtuName, int fieldId) {
        switch (fieldId) {
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x1L;
                }
                return true;
            }
        }
        return false;
    }
    private boolean onChangeViewModelTwtpasswd(android.databinding.ObservableField<java.lang.String> ViewModelTwtpasswd, int fieldId) {
        switch (fieldId) {
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x2L;
                }
                return true;
            }
        }
        return false;
    }
    private boolean onChangeViewModelMViewStyleIsProgressRefreshing(android.databinding.ObservableBoolean ViewModelMViewStyleIsProgressRefreshing, int fieldId) {
        switch (fieldId) {
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x4L;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        android.databinding.ObservableField<java.lang.String> viewModelTwtuName = null;
        android.databinding.ObservableField<java.lang.String> viewModelTwtpasswd = null;
        com.kelin.mvvmlight.command.ReplyCommand viewModelOnLaterLoginCommand = null;
        java.lang.String viewModelTwtpasswdGet = null;
        com.kelin.mvvmlight.command.ReplyCommand viewModelOnLoginClickCommand = null;
        com.kelin.mvvmlight.command.ReplyCommand viewModelOnRegisterClickCommand = null;
        boolean viewModelMViewStyleIsProgressRefreshingGet = false;
        java.lang.String viewModelTwtuNameGet = null;
        android.databinding.ObservableBoolean viewModelMViewStyleIsProgressRefreshing = null;
        int viewModelMViewStyleIsProgressRefreshingViewVISIBLEViewGONE = 0;
        com.kelin.mvvmlight.command.ReplyCommand viewModelOnForgetPasswordCommand = null;
        com.twtstudio.retrox.auth.login.LoginViewModel.ViewStyle viewModelMViewStyle = null;
        com.twtstudio.retrox.auth.login.LoginViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.twtuName
                        viewModelTwtuName = viewModel.twtuName;
                    }
                    updateRegistration(0, viewModelTwtuName);


                    if (viewModelTwtuName != null) {
                        // read viewModel.twtuName.get()
                        viewModelTwtuNameGet = viewModelTwtuName.get();
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.twtpasswd
                        viewModelTwtpasswd = viewModel.twtpasswd;
                    }
                    updateRegistration(1, viewModelTwtpasswd);


                    if (viewModelTwtpasswd != null) {
                        // read viewModel.twtpasswd.get()
                        viewModelTwtpasswdGet = viewModelTwtpasswd.get();
                    }
            }
            if ((dirtyFlags & 0x18L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.onLaterLoginCommand
                        viewModelOnLaterLoginCommand = viewModel.onLaterLoginCommand;
                        // read viewModel.onLoginClickCommand
                        viewModelOnLoginClickCommand = viewModel.onLoginClickCommand;
                        // read viewModel.onRegisterClickCommand
                        viewModelOnRegisterClickCommand = viewModel.onRegisterClickCommand;
                        // read viewModel.onForgetPasswordCommand
                        viewModelOnForgetPasswordCommand = viewModel.onForgetPasswordCommand;
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.mViewStyle
                        viewModelMViewStyle = viewModel.mViewStyle;
                    }


                    if (viewModelMViewStyle != null) {
                        // read viewModel.mViewStyle.isProgressRefreshing
                        viewModelMViewStyleIsProgressRefreshing = viewModelMViewStyle.isProgressRefreshing;
                    }
                    updateRegistration(2, viewModelMViewStyleIsProgressRefreshing);


                    if (viewModelMViewStyleIsProgressRefreshing != null) {
                        // read viewModel.mViewStyle.isProgressRefreshing.get()
                        viewModelMViewStyleIsProgressRefreshingGet = viewModelMViewStyleIsProgressRefreshing.get();
                    }
                if((dirtyFlags & 0x1cL) != 0) {
                    if(viewModelMViewStyleIsProgressRefreshingGet) {
                            dirtyFlags |= 0x40L;
                    }
                    else {
                            dirtyFlags |= 0x20L;
                    }
                }


                    // read viewModel.mViewStyle.isProgressRefreshing.get() ? View.VISIBLE : View.GONE
                    viewModelMViewStyleIsProgressRefreshingViewVISIBLEViewGONE = ((viewModelMViewStyleIsProgressRefreshingGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
        }
        // batch finished
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.editText, viewModelTwtuNameGet);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editText, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, viewModelTwtpasswdGet);
        }
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            com.kelin.mvvmlight.bindingadapter.view.ViewBindingAdapter.clickCommand(this.mboundView3, viewModelOnLoginClickCommand);
            com.kelin.mvvmlight.bindingadapter.view.ViewBindingAdapter.clickCommand(this.mboundView4, viewModelOnLaterLoginCommand);
            com.kelin.mvvmlight.bindingadapter.view.ViewBindingAdapter.clickCommand(this.mboundView5, viewModelOnForgetPasswordCommand);
            com.kelin.mvvmlight.bindingadapter.view.ViewBindingAdapter.clickCommand(this.mboundView6, viewModelOnRegisterClickCommand);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            this.mboundView7.setVisibility(viewModelMViewStyleIsProgressRefreshingViewVISIBLEViewGONE);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ActivityLoginBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityLoginBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityLoginBinding>inflate(inflater, com.twtstudio.retrox.auth.R.layout.activity_login, root, attachToRoot, bindingComponent);
    }
    public static ActivityLoginBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityLoginBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.twtstudio.retrox.auth.R.layout.activity_login, null, false), bindingComponent);
    }
    public static ActivityLoginBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityLoginBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_login_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityLoginBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): viewModel.twtuName
        flag 1 (0x2L): viewModel.twtpasswd
        flag 2 (0x3L): viewModel.mViewStyle.isProgressRefreshing
        flag 3 (0x4L): viewModel
        flag 4 (0x5L): null
        flag 5 (0x6L): viewModel.mViewStyle.isProgressRefreshing.get() ? View.VISIBLE : View.GONE
        flag 6 (0x7L): viewModel.mViewStyle.isProgressRefreshing.get() ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}