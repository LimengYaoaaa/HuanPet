package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.HomeContract;
import com.jiyun.huanpet.presenter.presenter.HomePresenterImpl;
import com.jiyun.huanpet.ui.activity.login.LoginActivity;
import com.jiyun.huanpet.ui.base.BaseActivity;
import com.zaaach.citypicker.CityPickerActivity;

import static com.jiyun.huanpet.constants.Constants.REQUESTCODE;

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
    private ImageView fujinyouxuan;
    private ImageView chongwuleixing;
    private ImageView shaixuan;

    private PopupWindow mPopWindow;
    private  Boolean state  = false;
    private  static final int REQUEST_CODE_PICK_CITY = 0;
    private TextView tv2;
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
        fujinyouxuan = (ImageView)findViewById(R.id.fujinyouxuan);
        chongwuleixing = (ImageView)findViewById(R.id.chongwuleixing);
        shaixuan = (ImageView)findViewById(R.id.shaixuan);







        fujinyouxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (state  == false){
                    fujinyouxuan.setImageResource(R.mipmap.live_china_detail_up);
                    View contentView = LayoutInflater.from(HomeActivity.this).inflate(R.layout.popupw_01, null);
                    mPopWindow = new PopupWindow(contentView, DrawerLayout.LayoutParams.WRAP_CONTENT, DrawerLayout.LayoutParams.WRAP_CONTENT);
                    mPopWindow.setContentView(contentView);
                    //设置各个控件的点击响应
                    TextView tv1 = (TextView)contentView.findViewById(R.id.pop_computer);
                    TextView tv2 = (TextView)contentView.findViewById(R.id.pop_financial);
                    TextView tv3 = (TextView)contentView.findViewById(R.id.pop_manage);
                    //价格从高到低
                    TextView tv4 = (TextView)contentView.findViewById(R.id.pop_computer01);
                    //价格从低到高
                    TextView tv5 = (TextView)contentView.findViewById(R.id.pop_computer02);


                    mPopWindow.setBackgroundDrawable(new ColorDrawable(0x000000 ));
                    mPopWindow.setOutsideTouchable(true);
                    //显示PopupWindow
                    mPopWindow.showAsDropDown(findViewById(R.id.linl));
                    // mPopWindow.showAtLocation(findViewById(R.id.linl), Gravity., 0, 0);

                    //mPopWindow.dismiss();
                    state =true;
                }else{
                    fujinyouxuan.setImageResource(R.mipmap.down_arrow);
                    mPopWindow.dismiss();

                    state =false;
                }
            }
        });


        chongwuleixing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (state  == false){
                    chongwuleixing.setImageResource(R.mipmap.live_china_detail_up);
                    View contentView = LayoutInflater.from(HomeActivity.this).inflate(R.layout.popupw, null);
                    mPopWindow = new PopupWindow(contentView, DrawerLayout.LayoutParams.WRAP_CONTENT, DrawerLayout.LayoutParams.WRAP_CONTENT);
                    mPopWindow.setContentView(contentView);
                    //设置各个控件的点击响应
                    TextView tv1 = (TextView)contentView.findViewById(R.id.xiao);
                    TextView tv2 = (TextView)contentView.findViewById(R.id.zhong);
                    TextView tv3 = (TextView)contentView.findViewById(R.id.da);
                    TextView tv4 = (TextView)contentView.findViewById(R.id.mao);
                    TextView tv5 = (TextView)contentView.findViewById(R.id.xiaochong);
                    TextView tv6 = (TextView)contentView.findViewById(R.id.youquan);

                    mPopWindow.setBackgroundDrawable(new ColorDrawable(0x000000 ));
                    mPopWindow.setOutsideTouchable(true);
                    mPopWindow.showAsDropDown(findViewById(R.id.linl));
                    state =true;
                }else{
                    chongwuleixing.setImageResource(R.mipmap.down_arrow);
                    mPopWindow.dismiss();

                    state =false;
                }

            }
        });

        shaixuan.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                if (state  == false){
                    shaixuan.setImageResource(R.mipmap.live_china_detail_up);
                    View contentView = LayoutInflater.from(HomeActivity.this).inflate(R.layout.popupw_02, null);
                    mPopWindow = new PopupWindow(contentView, DrawerLayout.LayoutParams.MATCH_PARENT, DrawerLayout.LayoutParams.MATCH_PARENT);
                    mPopWindow.setContentView(contentView);
                    //设置各个控件的点击响应
                    TextView tv1 = (TextView)contentView.findViewById(R.id.mSelect);
                    tv2 = (TextView)contentView.findViewById(R.id.select_city);
                    tv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

//启动
                            startActivityForResult(new Intent(HomeActivity.this, CityPickerActivity.class),
                                    REQUEST_CODE_PICK_CITY);
                        }
                    });
                    mPopWindow.setBackgroundDrawable(new ColorDrawable(0x000000 ));
                    mPopWindow.setOutsideTouchable(true);
                    //显示PopupWindow
                    mPopWindow.showAsDropDown(findViewById(R.id.linl));
                    // mPopWindow.showAtLocation(findViewById(R.id.linl), Gravity., 0, 0);

                    //mPopWindow.dismiss();
                    state =true;
                }else {


                    shaixuan.setImageResource(R.mipmap.down_arrow);
                    mPopWindow.dismiss();

                    state = false;
                }
            }
        });
    }
    //重写onActivityResult方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK){
            if (data != null){
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                tv2.setText("当前选择：" + city);
            }
        }
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
