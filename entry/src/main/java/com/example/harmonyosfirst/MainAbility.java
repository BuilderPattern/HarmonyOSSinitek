package com.example.harmonyosfirst;

import com.example.harmonyosfirst.ResourceTable;
import com.example.harmonyosfirst.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.ability.IAbilityContinuation;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.IntentParams;
import ohos.bundle.IBundleManager;
import ohos.security.SystemPermission;

public class MainAbility extends Ability implements IAbilityContinuation {//IAbilityContinuation实现迁移只需实现该接口即可

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
//        super.setUIContent(ResourceTable.Layout_ability_main);
        requestPermissions("ohos.permission.DISTRIBUTED_DATASYNC");
    }

    private void requestPermissions(String permission) {
        if (canRequestPermission(SystemPermission.DISTRIBUTED_DATASYNC)) {
            requestPermissionsFromUser(new String[]{permission}, 0x1001);
        }
    }

    @Override
    public void onRequestPermissionsFromUserResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsFromUserResult(requestCode, permissions, grantResults);
        if (requestCode == 0x1001 && grantResults != null && grantResults[0] == IBundleManager.PERMISSION_GRANTED) {
            this.continueAbility();
        }
    }

    @Override
    public boolean onStartContinuation() {
        return true;
    }

    @Override
    public boolean onSaveData(IntentParams intentParams) {
        return true;
    }

    @Override
    public boolean onRestoreData(IntentParams intentParams) {
        return true;
    }

    @Override
    public void onCompleteContinuation(int i) {
        this.terminateAbility();//结束当前设备运行的应用
    }
}
