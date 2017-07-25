package com.example.a12710.pandachannel.activity.personal_info.SettingFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ASUS on 2017/7/24.
 */

public class FragmentYudaode extends BaseFragment {
    @BindView(R.id.dysfunction)
    CheckBox dysfunction;
    @BindView(R.id.Contentproblem)
    CheckBox Contentproblem;
    @BindView(R.id.uinterface)
    CheckBox uinterface;
    @BindView(R.id.videoplayback)
    CheckBox videoplayback;
    @BindView(R.id.Display)
    CheckBox Display;
    @BindView(R.id.other)
    CheckBox other;
    @BindView(R.id.idea)
    EditText idea;
    @BindView(R.id.emile)
    EditText emile;
    @BindView(R.id.submit)
    Button submit;
    Unbinder unbinder;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_setting_yudaode;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.submit)
    public void onViewClicked() {
        if (dysfunction.isChecked() || Contentproblem.isChecked() || uinterface.isChecked()
                || videoplayback.isChecked() || Display.isChecked() || other.isChecked()) {
            if (emile.getText().length()>0) {
                Toast.makeText(getContext(), "提交成功", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getContext(), "邮箱格式不正确", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getContext(), "请选择问题类型", Toast.LENGTH_SHORT).show();
        }
    }
}
