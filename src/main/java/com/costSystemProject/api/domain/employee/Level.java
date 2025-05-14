package com.costSystemProject.api.domain.employee;

public enum Level {
    JUNIOR_ALFA(1),
    JUNIOR_BETA(2),
    PLENO(3),
    SÊNIOR(4),
    LEAD(5),
    STAFF(6);

    private int code;

    private Level(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static Level valueOf(int code){
        for(Level value: Level.values()){
            if(value.getCode()==code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Level code");
    }


}
