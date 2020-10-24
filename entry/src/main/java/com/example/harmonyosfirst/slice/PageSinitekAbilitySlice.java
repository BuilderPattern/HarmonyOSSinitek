package com.example.harmonyosfirst.slice;

import com.example.harmonyosfirst.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class PageSinitekAbilitySlice extends AbilitySlice implements Component.ClickedListener {

    private Intent intent;

    private PageHomeAbilitySlice pageHomeAbilitySlice;
    private PageMineAbilitySlice pageMineAbilitySlice;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        this.intent = intent;
        super.setUIContent(ResourceTable.Layout_ability_slice_page_sinitek);
        Text text = (Text) findComponentById(ResourceTable.Id_slice_page_sinitek_text);
        text.setText("SINITEK");

        Text textHome = (Text) findComponentById(ResourceTable.Id_slice_page_sinitek_tab_home);
        Text textSinitek = (Text) findComponentById(ResourceTable.Id_slice_page_sinitek_tab_sinitek);
        Text textMine = (Text) findComponentById(ResourceTable.Id_slice_page_sinitek_tab_mine);

        textHome.setClickedListener(this);
        textSinitek.setClickedListener(this);
        textMine.setClickedListener(this);

        pageHomeAbilitySlice = new PageHomeAbilitySlice();
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
        pageHomeAbilitySlice=null;
        pageMineAbilitySlice=null;
    }

    @Override
    public void onClick(Component component) {
        switch (component.getId()) {
            case ResourceTable.Id_slice_page_sinitek_tab_home:
                present(pageHomeAbilitySlice, intent);
                break;
            case ResourceTable.Id_slice_page_sinitek_tab_sinitek:
//                present(new PageSinitekAbilitySlice(), new Intent());
                break;
            case ResourceTable.Id_slice_page_sinitek_tab_mine:
                present(pageMineAbilitySlice, intent);
                break;
            default:
                break;
        }
    }
}
