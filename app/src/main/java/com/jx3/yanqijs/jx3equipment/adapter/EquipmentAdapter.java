package com.jx3.yanqijs.jx3equipment.adapter;

import android.content.Context;

import com.jx3.yanqijs.jx3equipment.imp.RecyclerImp;
import com.jx3.yanqijs.jx3equipment.model.BaseEquipmentModel;

/**
 * Created by yanqijs on 2016/10/28.
 */

public class EquipmentAdapter extends BaseRecyclerAdapter<BaseEquipmentModel> {
    public EquipmentAdapter(Context context, RecyclerImp onRecyclerImp) {
        super(context, onRecyclerImp);
    }

    @Override
    public void init(BaseRecyclerHelper helper, int position, BaseEquipmentModel item) {

    }

    @Override
    protected int getLayoutID() {
        return 0;
    }

    @Override
    protected void setOnRecyclerImp(RecyclerImp onRecyclerImp) {

    }

    @Override
    protected void setFooter(boolean isFooter, int totalCount, int perCount) {

    }
}
