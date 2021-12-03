package com.rekrutacja.zadanie1.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddItemCommand {

    @TargetAggregateIdentifier
    private UUID id;

    private String name;
}
