package com.costSystemProject.api.domain.employee;

public enum Position {
    SOFTWARE_ENGINEER(1),
    BUSINESS_ANALYST(2),
    UX_DESIGNER(3),
    TESTER(4),
    LEAD_SOFTWARE_ENGINEER(5),
    AREA_MANAGER(6);


    private int code;

    private Position(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static Position valueOf(int code){
        for(Position value: Position.values()){
            if(value.getCode()==code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Position code");
    }


}
