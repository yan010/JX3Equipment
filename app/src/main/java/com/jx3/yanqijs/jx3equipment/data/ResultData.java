package com.jx3.yanqijs.jx3equipment.data;

import android.support.annotation.NonNull;

import com.jx3.yanqijs.jx3equipment.model.GeneralEquipmentModel;
import com.jx3.yanqijs.jx3equipment.model.ShowModel;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.beans.*;

/**
 * Created by yanqijs on 2016/11/4.
 */

public class ResultData {
    private static ResultData resultData;

    private GeneralEquipmentModel mData = new GeneralEquipmentModel();
    private List<GeneralEquipmentModel> mDatas = new ArrayList<>();
    private List<ShowModel> showModels = new ArrayList<>();

    public static ResultData getInstance() {
        if (resultData == null) {
            resultData = new ResultData();
        }
        return resultData;
    }

    public void add(GeneralEquipmentModel generalEquipmentModel) {
        if (mDatas.size() == 0) {
            mDatas.add(generalEquipmentModel);
            return;
        }
        for (int i = 0; i < mDatas.size(); i++) {
            if (mDatas.get(i).part.equals(generalEquipmentModel.part)) {
                mDatas.remove(i);
                break;
            }
        }
        mDatas.add(generalEquipmentModel);
    }

    public List<GeneralEquipmentModel> getmDatas() {
        return mDatas;
    }

    public void calculateTotal() {
        mData = null;
        mData = new GeneralEquipmentModel();
        if (mDatas.size() == 0)
            return;
        for (GeneralEquipmentModel temp : mDatas) {
            mData.equipmentScore += temp.equipmentScore;
            mData.money += temp.money;
            mData.outDefense += temp.outDefense;
            mData.innerDefense += temp.innerDefense;
            mData.constitution += temp.constitution;
            mData.attribute += temp.attribute;
            mData.attack += temp.attack;
            mData.special += temp.special;
            mData.specialEffect += temp.specialEffect;
            mData.broken += temp.broken;
            mData.hit += temp.hit;
            mData.wushuang += temp.wushuang;
            mData.resistSpecial += temp.resistSpecial;
            mData.resistAttack += temp.resistAttack;
            mData.weiwangxiaohao += temp.weiwangxiaohao;
            mData.banggongxiaohao += temp.banggongxiaohao;
            mData.xiayixiaohao += temp.xiayixiaohao;
        }
    }

    public GeneralEquipmentModel getmData() {
        return mData;
    }

    public List<ShowModel> toShow() {
        showModels.clear();
        showModels.add(getShowModel("装备分数", mData.equipmentScore + ""));
        showModels.add(getShowModel("总价", mData.money + ""));
        showModels.add(getShowModel("外功防御", mData.outDefense + ""));
        showModels.add(getShowModel("内功防御", mData.innerDefense + ""));
        showModels.add(getShowModel("体质", mData.constitution + ""));
        showModels.add(getShowModel("职业特殊属性", mData.attribute + ""));
        showModels.add(getShowModel("攻击", mData.attack + ""));
        showModels.add(getShowModel("会心", mData.special + ""));
        showModels.add(getShowModel("会心效果", mData.specialEffect + ""));
        showModels.add(getShowModel("破防", mData.broken + ""));
        showModels.add(getShowModel("命中", mData.hit + ""));
        showModels.add(getShowModel("无双", mData.wushuang + ""));
        showModels.add(getShowModel("御劲", mData.resistSpecial + ""));
        showModels.add(getShowModel("化劲", mData.resistAttack + ""));
        return showModels;

    }

    @NonNull
    private ShowModel getShowModel(String key, String value) {
        ShowModel showModel = new ShowModel();
        showModel.key = key;
        showModel.value = value;
        return showModel;
    }
}
