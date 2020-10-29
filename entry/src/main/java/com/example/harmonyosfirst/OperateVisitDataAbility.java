package com.example.harmonyosfirst;

import com.example.harmonyosfirst.slice.OperateVisitDataAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.bundle.IBundleManager;

public class OperateVisitDataAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);

        super.setMainRoute(OperateVisitDataAbilitySlice.class.getName());
    }

    private boolean isPermission=false;
    @Override
    public void onRequestPermissionsFromUserResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsFromUserResult(requestCode, permissions, grantResults);
        if (requestCode == 0x1003 && grantResults[0] == IBundleManager.PERMISSION_GRANTED){
            isPermission=true;
        }
    }
}
