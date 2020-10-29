package com.example.harmonyosfirst;

import com.example.harmonyosfirst.entity.UserEntity;
import com.example.harmonyosfirst.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.ability.DataAbilityHelper;
import ohos.aafwk.ability.IAbilityContinuation;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.IntentParams;
import ohos.aafwk.content.Operation;
import ohos.bundle.IBundleManager;
import ohos.data.DatabaseHelper;
import ohos.data.orm.OrmContext;

public class MainAbility extends Ability implements IAbilityContinuation {//IAbilityContinuation实现迁移只需实现该接口即可

//    private DatabaseHelper helper;
//    private static final String DATABASE_ALIAS_NAME = "data_base_alias_name_user";
//    private static final String DATABASE__NAME = "data_base_name_user";
//    OrmContext ormContext;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);

//        helper = new DatabaseHelper(this);
//        ormContext = this.helper.getOrmContext(DATABASE_ALIAS_NAME, DATABASE__NAME, UserEntity.class);

        super.setMainRoute(MainAbilitySlice.class.getName());
//        super.setUIContent(ResourceTable.Layout_ability_main);
        PermissionUtil.getInstance(MainAbility.this).requestPermission("ohos.permission.DISTRIBUTED_DATASYNC", 0x1001);
    }

    @Override
    public void onRequestPermissionsFromUserResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsFromUserResult(requestCode, permissions, grantResults);
        if (grantResults != null && grantResults[0] == IBundleManager.PERMISSION_GRANTED) {
            if (requestCode == 0x1001) {
                this.continueAbility();
            } else if (requestCode == 0x1002) {
                Intent intent = new Intent();//启动前台服务
                Operation operation = new Intent.OperationBuilder()
                        .withDeviceId("")
                        .withBundleName("com.example.harmonyosfirst")
                        .withAbilityName("com.example.harmonyosfirst.ForegroundServiceAbility")
//                            .withFlags(Intent.FLAG_ABILITYSLICE_MULTI_DEVICE) // 设置支持分布式调度系统多设备启动的标识（启动远程service）
                        .build();
                intent.setOperation(operation);
                startAbility(intent);
            }
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
