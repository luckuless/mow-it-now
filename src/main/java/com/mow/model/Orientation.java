package com.mow.model;

import com.mow.enums.NotationCardinale;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Orientation {

    NotationCardinale notationCardinale;
    int position;
    
}
