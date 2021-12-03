package com.rekrutacja.zadanie1;

import com.rekrutacja.zadanie1.aggregate.AddItemAggregate;
import com.rekrutacja.zadanie1.command.AddItemCommand;
import com.rekrutacja.zadanie1.event.ItemAddedEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class ItemAggregateTest {

    private FixtureConfiguration<AddItemAggregate> fixture;
    private UUID id;
    private static final String itemName = "item";

    @BeforeEach
    public void setUp() {
        fixture = new AggregateTestFixture<>(AddItemAggregate.class);
        id = UUID.randomUUID();
    }

    @Test
    public void should_dispatch_itemadded_event_when_additem_command() {
        fixture.givenNoPriorActivity()
                .when(new AddItemCommand(
                        id,
                        itemName
                ))
                .expectEvents(new ItemAddedEvent(
                        id,
                        itemName
                ));
    }
}
