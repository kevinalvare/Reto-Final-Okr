package com.co.sofka.api.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class GetOkr implements Task {

    String resource;

    public GetOkr(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

    }

    public static GetOkr withResource(String resource){
        return Tasks.instrumented(GetOkr.class, resource);
    }

}
