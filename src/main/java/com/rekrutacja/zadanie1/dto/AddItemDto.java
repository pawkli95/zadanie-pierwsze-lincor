package com.rekrutacja.zadanie1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddItemDto {

    private UUID id;

    private String name;
}
