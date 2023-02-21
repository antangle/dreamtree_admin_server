package com.dreamtree.api.common.enums;

public enum RoleEnum {
    PARENT("parent"),
    STUDENT("student"),
    ADMIN("admin");


    String name;

    RoleEnum(String name){
        this.name = name;
    }

    public String toString(){
        switch (this){
            case PARENT:
                return "parent";
            case STUDENT:
                return "student";
            case ADMIN:
                return "admin";
        }
        return null;
    }
}
