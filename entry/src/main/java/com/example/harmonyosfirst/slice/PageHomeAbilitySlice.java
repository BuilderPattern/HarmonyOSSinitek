package com.example.harmonyosfirst.slice;

import com.example.harmonyosfirst.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class PageHomeAbilitySlice extends AbilitySlice implements Component.ClickedListener {

    private Intent intent;

    private PageSinitekAbilitySlice pageSinitekAbilitySlice;
    private PageMineAbilitySlice pageMineAbilitySlice;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        this.intent = intent;
        super.setUIContent(ResourceTable.Layout_ability_slice_page_home);
        Text text = (Text) findComponentById(ResourceTable.Id_slice_page_home_text);
        text.setText("HOME");
        Text textHome = (Text) findComponentById(ResourceTable.Id_slice_page_home_tab_home);
        Text textSinitek = (Text) findComponentById(ResourceTable.Id_slice_page_home_tab_sinitek);
        Text textMine = (Text) findComponentById(ResourceTable.Id_slice_page_home_tab_mine);

        textHome.setClickedListener(this);
        textSinitek.setClickedListener(this);
        textMine.setClickedListener(this);

        pageSinitekAbilitySlice = new PageSinitekAbilitySlice();
        pageMineAbilitySlice = new PageMineAbilitySlice();
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
        this.intent = intent;
    }
    @Override
    protected void onStop() {
        super.onStop();
        pageSinitekAbilitySlice=null;
        pageMineAbilitySlice=null;
    }
    @Override
    public void onClick(Component component) {
        switch (component.getId()) {
            case ResourceTable.Id_slice_page_home_tab_home:
//                present(new PageHomeAbilitySlice(), new Intent());
                break;
            case ResourceTable.Id_slice_page_home_tab_sinitek:
                present(pageSinitekAbilitySlice, intent);
                break;
            case ResourceTable.Id_slice_page_home_tab_mine:
                present(pageMineAbilitySlice, intent);
                break;
            default:
                break;
        }
    }
}
