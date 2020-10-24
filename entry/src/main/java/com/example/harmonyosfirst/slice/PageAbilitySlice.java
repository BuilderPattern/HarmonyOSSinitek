package com.example.harmonyosfirst.slice;

import com.example.harmonyosfirst.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.DirectionalLayout.LayoutConfig;
import ohos.agp.components.Text;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;
import ohos.agp.utils.TextAlignment;

public class PageAbilitySlice extends AbilitySlice {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
//        super.setUIContent(ResourceTable.Layout_ability_page);
//        present(new PageHomeAbilitySlice(), intent);
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
