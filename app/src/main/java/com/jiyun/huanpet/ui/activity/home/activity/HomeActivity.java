package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.HomeContract;
import com.jiyun.huanpet.presenter.presenter.HomePresenterImpl;
import com.jiyun.huanpet.ui.activity.login.LoginActivity;
import com.jiyun.huanpet.ui.base.BaseActivity;

import static com.jiyun.huanpet.constants.Constants.REQUESTCODE;
import static com.jiyun.huanpet.utils.LogUtils.W;

/**
 * Created by mengYao on 2017/12/8.
 */

public class HomeActivity extends BaseActivity<HomePresenterImpl> implements HomeContract.HomeView, View.OnClickListener {

    private DrawerLayout drawer_layout;
    private ImageView mMenuHead;
    private ImageView mPersonalCenter;
    private RelativeLayout mMessageContainer;
    private RelativeLayout mPetContainer;
    private RelativeLayout mOrderContainer;
    private RelativeLayout mWalletContainer;
    private RelativeLayout mKonwContainer;
    private RelativeLayout mSettingContainer;
    private Button mBtnSwitchUser;
    private RelativeLayout mInfomation;
    private TextView mMenuName;
    private TextView mMenuPhone;
    private RelativeLayout mNoLoginContainer;


    @Override
    protected int getLayoutId() {
        return R.layout.menu_layout;
    }

    @Override
    protected void findViewById() {
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mPersonalCenter = (ImageView) findViewById(R.id.mPersonalCenter);
        mInfomation = (RelativeLayout) findViewById(R.id.mInfomation);
        mMenuHead = (ImageView) findViewById(R.id.mMenuHead);
        mMenuName = (TextView) findViewById(R.id.mMenuName);
        mMenuPhone = (TextView) findViewById(R.id.mMenuPhone);
        mMessageContainer = (RelativeLayout) findViewById(R.id.mMessageContainer);
        mPetContainer = (RelativeLayout) findViewById(R.id.mPetContainer);
        mOrderContainer = (RelativeLayout) findViewById(R.id.mOrderContainer);
        mWalletContainer = (RelativeLayout) findViewById(R.id.mWalletContainer);
        mKonwContainer = (RelativeLayout) findViewById(R.id.mKonwContainer);
        mSettingContainer = (RelativeLayout) findViewById(R.id.mSettingContainer);
        mBtnSwitchUser = (Button) findViewById(R.id.mBtnSwitchUser);
        mNoLoginContainer = (RelativeLayout) findViewById(R.id.mNoLoginContainer);
    }

    @Override
    protected void init() {
        mPersonalCenter.setOnClickListener(this);
        mInfomation.setOnClickListener(this);
        mMessageContainer.setOnClickListener(this);
        mPetContainer.setOnClickListener(this);
        mOrderContainer.setOnClickListener(this);
        mWalletContainer.setOnClickListener(this);
        mKonwContainer.setOnClickListener(this);
        mSettingContainer.setOnClickListener(this);
        mBtnSwitchUser.setOnClickListener(this);
        mNoLoginContainer.setOnClickListener(this);
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
            case R.id.mInfomation:
                startActivity(new Intent(this,PersonalInfomationActivity.class));
                break;
            case R.id.mMessageContainer:
                startActivity(new Intent(this,NewsActivity.class));
                break;
            case R.id.mPetContainer:
                startActivity(new Intent(this,PetActivity.class));

                break;
            case R.id.mOrderContainer:
                startActivity(new Intent(this,OrderActivity.class));

                break;
            case R.id.mWalletContainer:
                startActivity(new Intent(this,WalletActivity.class));

                break;
            case R.id.mKonwContainer:
                startActivity(new Intent(this,KonwActivity.class));
                break;
            case R.id.mSettingContainer:
                startActivity(new Intent(this,SettingActivity.class));
                break;
            case R.id.mBtnSwitchUser:
                startActivity(new Intent(this,FosterteacherActivity.class));
                break;
            case R.id.mNoLoginContainer:
                startActivityForResult(new Intent(this,LoginActivity.class),REQUESTCODE);
                break;
        }
    }
}
