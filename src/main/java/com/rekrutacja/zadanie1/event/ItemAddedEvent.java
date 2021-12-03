package com.rekrutacja.zadanie1.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemAddedEvent {

    private UUID id;

    private String name;
}
