package com.costSystemProject.api.domain.employee;

public enum TypeOfContract {
    REMOTE(1),
    ON_SITE(2),
    HYBRID(3);

    private int code;

    private TypeOfContract(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TypeOfContract valueOf(int code){
        for(TypeOfContract value: TypeOfContract.values()){
            if(value.getCode()==code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid type of contract code");
    }

}
