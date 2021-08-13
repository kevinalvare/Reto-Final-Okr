package com.co.sofka.api.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Page {
    private String id;
    private String name;
    private String okr[];
}
