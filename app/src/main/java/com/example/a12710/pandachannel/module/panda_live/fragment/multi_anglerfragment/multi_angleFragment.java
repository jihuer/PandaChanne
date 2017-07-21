package com.example.a12710.pandachannel.module.panda_live.fragment.multi_anglerfragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.MultiBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**.
 * Created by 12710 on 2017/7/19.
 * 多视角直播
 */

public class multi_angleFragment extends BaseFragment implements MultiAngleContract.MultiAngleView {
    @BindView(R.id.look_recycler)
    XRecyclerView lookRecycler;
    Unbinder unbinder;

    @Override
    protected void initData() {
        MultiAngleFragmentPresenter multiAngleFragmentPresenter = new MultiAngleFragmentPresenter(this);
        multiAngleFragmentPresenter.start();
    }

    @Override
    protected void initView(View view) {
       // Toast.makeText(getActivity(), "initView", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_looktack;
    }

    @Override
    public void setPresenter(MultiAngleFragmentPresenter multiAngleFragmentPresenter) {

    }

    @Override
    public void setResultData(final MultiBean multiBean) {
        Toast.makeText(getActivity(), multiBean.toString()+"", Toast.LENGTH_SHORT).show();

       if (multiBean!=null) {
           lookRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
           CommonAdapter commonAdapter = new CommonAdapter<MultiBean.ListBean>(getActivity(), R.layout.xrecycler_item, multiBean.getList()) {
               @Override
               protected void convert(ViewHolder holder, MultiBean.ListBean listBean, int position) {
                   holder.setText(R.id.tv_recycler, listBean.getTitle());
                   ImageView imageView = holder.getView(R.id.iv_recycler);
                   Glide.with(getActivity()).load(listBean.getImage()).into(imageView);

               }
           };
           lookRecycler.setAdapter(commonAdapter);
       }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
