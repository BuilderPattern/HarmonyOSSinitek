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

        String name = PageHomeAbilitySlice.class.getName();
        super.setMainRoute(name);
    }
}
