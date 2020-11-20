package com.example.harmonyosfirst.slice;

import com.example.harmonyosfirst.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class PageSinitekAbilitySlice extends AbilitySlice implements Component.ClickedListener {
    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD001100, "PageAbility-----PageSinitekAbilitySlice");
    private Intent intent;

    private PageHomeAbilitySlice pageHomeAbilitySlice;
    private PageMineAbilitySlice pageMineAbilitySlice;

    Text textClick;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        HiLog.error(LABEL_LOG, "onStart");
        this.intent = intent;
        super.setUIContent(ResourceTable.Layout_ability_slice_page_sinitek);
//        Text text = (Text) findComponentById(ResourceTable.Id_slice_page_sinitek_text);
//        text.setText("SINITEK");

        textClick = (Text) findComponentById(ResourceTable.Id_slice_page_sinitek_text);
        Text textHome = (Text) findComponentById(ResourceTable.Id_slice_page_sinitek_tab_home);
        Text textSinitek = (Text) findComponentById(ResourceTable.Id_slice_page_sinitek_tab_sinitek);
        Text textMine = (Text) findComponentById(ResourceTable.Id_slice_page_sinitek_tab_mine);

        textClick.setClickedListener(this);
        textHome.setClickedListener(this);
        textSinitek.setClickedListener(this);
        textMine.setClickedListener(this);

        if (pageHomeAbilitySlice == null) {
            pageHomeAbilitySlice = new PageHomeAbilitySlice();
        }
        if (pageMineAbilitySlice == null) {
            pageMineAbilitySlice = new PageMineAbilitySlice();
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

    private int num = 0;

    @Override
    public void onClick(Component component) {
        switch (component.getId()) {
            case ResourceTable.Id_slice_page_sinitek_text:
                num++;
                textClick.setText("num：" + num);
                break;
            case ResourceTable.Id_slice_page_sinitek_tab_home:
                present(pageHomeAbilitySlice, intent);
                terminate();
                break;
            case ResourceTable.Id_slice_page_sinitek_tab_sinitek:
//                present(new PageSinitekAbilitySlice(), new Intent());
                break;
            case ResourceTable.Id_slice_page_sinitek_tab_mine:
                present(pageMineAbilitySlice, intent);
                terminate();
                break;
            default:
                break;
        }
    }
}
