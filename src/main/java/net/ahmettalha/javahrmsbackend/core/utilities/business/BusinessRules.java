package net.ahmettalha.javahrmsbackend.core.utilities.business;

import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;

public class BusinessRules {
    public static Result run(Result... logics){
        for (Result logic : logics){
            if (!logic.isSuccess()){
                return logic;
            }
        }
        return null;
    }
}
