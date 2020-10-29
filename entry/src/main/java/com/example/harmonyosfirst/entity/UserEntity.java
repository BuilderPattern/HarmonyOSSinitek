package com.example.harmonyosfirst.entity;

import ohos.aafwk.ability.DataAbilityHelper;
import ohos.data.orm.OrmDatabase;
import ohos.data.rdb.RdbOpenCallback;
import ohos.data.rdb.RdbStore;

public class UserEntity extends OrmDatabase {

    private String name;
    private String nickName;
    private int age;

    public UserEntity() {
        super();
    }

    @Override
    public void corruptionHandler(RdbStore store) {
        super.corruptionHandler(store);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public RdbOpenCallback getHelper() {
        return new RdbOpenCallback() {
            @Override
            public void onCreate(RdbStore rdbStore) {
                onOpen(rdbStore);
                int version = rdbStore.getVersion();
            }

            @Override
            public void onUpgrade(RdbStore rdbStore, int i, int i1) {//currentVersion、TargetVersion
                rdbStore.setVersion(i);
            }
        };
    }
}
