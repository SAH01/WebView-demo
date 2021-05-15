package com.example.zhizhi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zhizhi.MainActivity;
import com.example.zhizhi.R;
import com.example.zhizhi.other.Code;
import com.example.zhizhi.other.DBOpenHelper;
import com.example.zhizhi.loginActivity;
/**
 * Created by littlecurl 2018/6/24
 */

/**
 * 此类 implements View.OnClickListener 之后，
 * 就可以把onClick事件写到onCreate()方法之外
 * 这样，onCreate()方法中的代码就不会显得很冗余
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private String         realCode;
    private DBOpenHelper mDBOpenHelper;
    private Button         mBtRegisteractivityRegister;
    private RelativeLayout mRlRegisteractivityTop;
    private ImageView      mIvRegisteractivityBack;
    private LinearLayout   mLlRegisteractivityBody;
    private EditText       mEtRegisteractivityUsername;
    private EditText       mEtRegisteractivityUserid;
    private EditText       mEtRegisteractivityUserphone;
    private EditText       mEtRegisteractivityUseraddress;
    private EditText       mEtRegisteractivityPhonecodes;
    private ImageView      mIvRegisteractivityShowcode;
    private RelativeLayout mRlRegisteractivityBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();

        mDBOpenHelper = new DBOpenHelper(this);

        //将验证码用图片的形式显示出来
        mIvRegisteractivityShowcode.setImageBitmap(Code.getInstance().createBitmap());
        realCode = Code.getInstance().getCode().toLowerCase();
    }

    private void initView(){
        mBtRegisteractivityRegister = findViewById(R.id.bt_registeractivity_register);
        mRlRegisteractivityTop = findViewById(R.id.rl_registeractivity_top);
        mIvRegisteractivityBack = findViewById(R.id.iv_registeractivity_back);
        mLlRegisteractivityBody = findViewById(R.id.ll_registeractivity_body);
        mEtRegisteractivityUsername = findViewById(R.id.et_registeractivity_name);
        mEtRegisteractivityUserid = findViewById(R.id.et_registeractivity_id);
        mEtRegisteractivityUserphone = findViewById(R.id.et_registeractivity_phone);
        mEtRegisteractivityUseraddress = findViewById(R.id.et_registeractivity_address);
        mEtRegisteractivityPhonecodes = findViewById(R.id.et_registeractivity_phoneCodes);
        mIvRegisteractivityShowcode = findViewById(R.id.iv_registeractivity_showCode);
        mRlRegisteractivityBottom = findViewById(R.id.rl_registeractivity_bottom);

        /**
         * 注册页面能点击的就三个地方
         * top处返回箭头、刷新验证码图片、注册按钮
         */
        mIvRegisteractivityBack.setOnClickListener(this);
        mIvRegisteractivityShowcode.setOnClickListener(this);
        mBtRegisteractivityRegister.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_registeractivity_back: //返回登录页面
                Intent intent1 = new Intent(this, loginActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.iv_registeractivity_showCode:    //改变随机验证码的生成
                mIvRegisteractivityShowcode.setImageBitmap(Code.getInstance().createBitmap());
                realCode = Code.getInstance().getCode().toLowerCase();
                break;
            case R.id.bt_registeractivity_register:    //注册按钮
                //获取用户输入的用户名、密码、验证码
                String username = mEtRegisteractivityUsername.getText().toString().trim();
                String userid = mEtRegisteractivityUserid.getText().toString().trim();
                String userphone = mEtRegisteractivityUserphone.getText().toString().trim();
                String useraddress = mEtRegisteractivityUseraddress.getText().toString().trim();
                String phoneCode = mEtRegisteractivityPhonecodes.getText().toString().toLowerCase();
                //注册验证
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(userid) && !TextUtils.isEmpty(phoneCode) && !TextUtils.isEmpty(userphone)
                        && !TextUtils.isEmpty(useraddress)    ) {
                    if (phoneCode.equals(realCode)) {
                        //将用户名和密码加入到数据库中
                        mDBOpenHelper.add(username, userid,userphone,useraddress);
                        SharedPreferences.Editor editor=getSharedPreferences("date",MODE_PRIVATE).edit();
                        editor.putString("phone",userphone);
                        editor.putString("passWorld",userid);
                        editor.commit();
                        Intent intent2 = new Intent(this, MainActivity.class);
                        startActivity(intent2);
                        Toast.makeText(this,  "验证通过，注册成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "验证码错误,注册失败", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "未完善信息，注册失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

