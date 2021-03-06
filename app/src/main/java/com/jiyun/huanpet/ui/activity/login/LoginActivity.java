package com.jiyun.huanpet.ui.activity.login;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.LoginContract;
import com.jiyun.huanpet.presenter.presenter.LoginPresenterImpl;
import com.jiyun.huanpet.ui.activity.home.activity.HomeActivity;
import com.jiyun.huanpet.ui.base.BaseActivity;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by mengYao on 2017/12/9.
 */

public class LoginActivity extends BaseActivity<LoginPresenterImpl> implements LoginContract.LoginView, View.OnClickListener {

    private Button mBtnLogin;
    private TextView mToRegister;
    private LinearLayout mWxLogin;
    private LinearLayout mQqLogin;
    private ImageView mLoginBack;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void findViewById() {
        mBtnLogin = (Button) findViewById(R.id.mBtnLogin);
        mToRegister = (TextView) findViewById(R.id.mToRegister);
        mWxLogin = (LinearLayout) findViewById(R.id.mWxLogin);
        mQqLogin = (LinearLayout) findViewById(R.id.mQqLogin);
        mLoginBack = (ImageView) findViewById(R.id.mLoginBack);
    }

    @Override
    protected void init() {
        mBtnLogin.setOnClickListener(this);
        mToRegister.setOnClickListener(this);
        mWxLogin.setOnClickListener(this);
        mQqLogin.setOnClickListener(this);
        mLoginBack.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void openProgress() {

    }

    @Override
    public void closeProgress() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mBtnLogin:
                startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
            case R.id.mToRegister:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.mWxLogin:
                UMShareAPI.get(this).getPlatformInfo(LoginActivity.this, SHARE_MEDIA.WEIXIN, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                    }
                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        Intent intent = new Intent(LoginActivity.this, BindPhoneActivity.class);
                        startActivity(intent);
                    }
                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                    }
                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {
                    }
                });

                break;
            case R.id.mQqLogin:
                UMShareAPI.get(this).getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }
                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

                        String uid = map.get("name");
                        String iconurl = map.get("iconurl");
                        Intent intent = new Intent(LoginActivity.this, BindPhoneActivity.class);

                        intent.putExtra("name",uid);
                        intent.putExtra("img",iconurl);
                        startActivity(intent);
                        Log.e("name",uid);
                        Log.e("iconurl",uid);
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });



                break;
            case R.id.mLoginBack:
                finish();
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
