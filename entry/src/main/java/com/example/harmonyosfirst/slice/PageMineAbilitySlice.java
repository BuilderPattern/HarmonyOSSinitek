package com.example.harmonyosfirst.slice;

import com.example.harmonyosfirst.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class PageMineAbilitySlice extends AbilitySlice implements Component.ClickedListener {
    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD001100, "PageAbility-----PageMineAbilitySlice");
    private Intent intent;

    private PageHomeAbilitySlice pageHomeAbilitySlice;
    private PageSinitekAbilitySlice pageSinitekAbilitySlice;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        HiLog.error(LABEL_LOG, "onStart");
        this.intent = intent;
        super.setUIContent(ResourceTable.Layout_ability_slice_page_mine);
//        Text text = (Text) findComponentById(ResourceTable.Id_slice_page_mine_text);
//        text.setText("MINE");

        Text textHome = (Text) findComponentById(ResourceTable.Id_slice_page_mine_tab_home);
        Text textSinitek = (Text) findComponentById(ResourceTable.Id_slice_page_mine_tab_sinitek);
        Text textMine = (Text) findComponentById(ResourceTable.Id_slice_page_mine_tab_mine);

        textHome.setClickedListener(this);
        textSinitek.setClickedListener(this);
        textMine.setClickedListener(this);

        if (pageHomeAbilitySlice == null) {
            pageHomeAbilitySlice = new PageHomeAbilitySlice();
        }
        if (pageSinitekAbilitySlice == null) {
            pageSinitekAbilitySlice = new PageSinitekAbilitySlice();
        }
    }

    @Override
    public void onActive() {
        super.onActive();
        HiLog.error(LABEL_LOG, "onActive");
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
        HiLog.error(LABEL_LOG, "onForeground");
        this.intent = intent;
    }

    @Override
    protected void onStop() {
        super.onStop();
        HiLog.error(LABEL_LOG, "onStop");
    }

    @Override
    public void onClick(Component component) {
        switch (component.getId()) {
            case ResourceTable.Id_slice_page_mine_tab_home:
                present(pageHomeAbilitySlice, intent);
                terminate();
                break;
            case ResourceTable.Id_slice_page_mine_tab_sinitek:
                present(pageSinitekAbilitySlice, intent);
                terminate();
                break;
            case ResourceTable.Id_slice_page_mine_tab_mine:
//                present(new PageMineAbilitySlice(), new Intent());
                break;
            default:
                break;
        }
    }
}
