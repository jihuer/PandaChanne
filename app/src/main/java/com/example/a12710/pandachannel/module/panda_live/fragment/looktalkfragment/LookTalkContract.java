package com.example.a12710.pandachannel.module.panda_live.fragment.looktalkfragment;

import com.example.a12710.pandachannel.base.BaseView;
import com.example.a12710.pandachannel.model.bean.LookTalkBean;

/**
 * Created by 12710 on 2017/7/20.
 */

public interface LookTalkContract {
   interface LookTackView extends BaseView<LookTalkFragmentPresenter>{
       void setResultData(LookTalkBean lookTalkBean);

   }


}
