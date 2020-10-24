package com.example.harmonyosfirst;

import com.example.harmonyosfirst.slice.PageHomeAbilitySlice;
import com.example.harmonyosfirst.slice.PageMineAbilitySlice;
import com.example.harmonyosfirst.slice.PageSinitekAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class PageAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
//        addActionRoute("action.page.home", PageHomeAbilitySlice.class.getName());
//        addActionRoute("action.page.sinitek", PageSinitekAbilitySlice.class.getName());
//        addActionRoute("action.page.mine", PageMineAbilitySlice.class.getName());
//        int flags = intent.getFlags();
//        switch (flags) {
//            case 1:
//                super.setMainRoute(PageSinitekAbilitySlice.class.getName());
//                break;
//            case 2:
//                super.setMainRoute(PageMineAbilitySlice.class.getName());
//                break;
//            default:
//                super.setMainRoute(PageHomeAbilitySlice.class.getName());
//                break;
//        }

        String name = PageHomeAbilitySlice.class.getName();
        super.setMainRoute(name);
    }
}
