package com.example.a12710.pandachannel.module.panda_live.fragment.looktalkfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.LookTalkBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 12710 on 2017/7/22.
 */

public class LookTalkFragment extends BaseFragment implements LookTalkContract.LookTackView {
    @BindView(R.id.bt_livesend)
    Button btLivesend;
    @BindView(R.id.ed_live)
    EditText edLive;
    @BindView(R.id.live_re)
    RelativeLayout liveRe;
    @BindView(R.id.recycler)
    XRecyclerView recycler;
    Unbinder unbinder;
    private int p = 1;
    private CommonAdapter commonAdapter;
    private List<LookTalkBean.DataBean.ContentBean> list = new ArrayList<>();
    @Override
    protected void initData() {
        LookTalkFragmentPresenter lookTalkFragmentPresenter = new LookTalkFragmentPresenter(this, p);
        lookTalkFragmentPresenter.start();
    }

    @Override
    protected void initView(View view) {
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        commonAdapter = new CommonAdapter<LookTalkBean.DataBean.ContentBean>(getActivity(), R.layout.item_looktalk, list) {
            @Override
            protected void convert(ViewHolder holder, LookTalkBean.DataBean.ContentBean contentBean, int position) {
                RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
                holder.itemView.setLayoutParams(lp);
            //    Toast.makeText(mContext, contentBean.getAuthor(), Toast.LENGTH_SHORT).show();
                holder.setText(R.id.tv_looktalkname, contentBean.getAuthor());
                holder.setText(R.id.sidelook_titler, contentBean.getMessage());
                holder.setText(R.id.tv_looktalktime, contentBean.getRelative_time() + "");
            }


        };
        recycler.setAdapter(commonAdapter);
        recycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                recycler.refresh();
            }

            @Override
            public void onLoadMore() {
                recycler.loadMoreComplete();
                p++;
                initData();
                recycler.refreshComplete();
            }
        });

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_looktalk;
    }

    @Override
    public void setPresenter(LookTalkFragmentPresenter lookTalkFragmentPresenter) {

    }

    @Override
    public void setResultData(LookTalkBean lookTalkBean) {
        if (lookTalkBean != null) {
           // Toast.makeText(getActivity(), lookTalkBean.toString() + "", Toast.LENGTH_SHORT).show();
            list.addAll(lookTalkBean.getData().getContent());
            commonAdapter.notifyDataSetChanged();
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
