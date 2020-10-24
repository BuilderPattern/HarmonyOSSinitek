package com.example.harmonyosfirst.slice;

import com.example.harmonyosfirst.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class PageMineAbilitySlice extends AbilitySlice implements Component.ClickedListener {

    private Intent intent;

    private PageHomeAbilitySlice pageHomeAbilitySlice;
    private PageSinitekAbilitySlice pageSinitekAbilitySlice;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        this.intent = intent;
        super.setUIContent(ResourceTable.Layout_ability_slice_page_mine);
        Text text = (Text) findComponentById(ResourceTable.Id_slice_page_mine_text);
        text.setText("MINE");

        Text textHome = (Text) findComponentById(ResourceTable.Id_slice_page_mine_tab_home);
        Text textSinitek = (Text) findComponentById(ResourceTable.Id_slice_page_mine_tab_sinitek);
        Text textMine = (Text) findComponentById(ResourceTable.Id_slice_page_mine_tab_mine);

        textHome.setClickedListener(this);
        textSinitek.setClickedListener(this);
        textMine.setClickedListener(this);

        pageHomeAbilitySlice = new PageHomeAbilitySlice();
        pageSinitekAbilitySlice = new PageSinitekAbilitySlice();
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
        pageSinitekAbilitySlice=null;
    }

    @Override
    public void onClick(Component component) {
        switch (component.getId()) {
            case ResourceTable.Id_slice_page_mine_tab_home:
                present(pageHomeAbilitySlice, intent);
                break;
            case ResourceTable.Id_slice_page_mine_tab_sinitek:
                present(pageSinitekAbilitySlice, intent);
                break;
            case ResourceTable.Id_slice_page_mine_tab_mine:
//                present(new PageMineAbilitySlice(), new Intent());
                break;
            default:
                break;
        }
    }
}
