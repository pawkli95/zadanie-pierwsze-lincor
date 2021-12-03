Do stworzenia aplikacji z wykorzystaniem wzorca CQRS wybrałem framework Axon. 
W aplikacji użyłem także wzorca Event Sourcing.
Wykorzystuje ona bazę danych H2 in-memory.
Dzieki wykorzystaniu obiektów Command i obiektów Query udało mi się oddzielić od siebie operacje zapisywania od operacji odczytywania.
Do testu użyłem wbudowanego modułu Axon Test, umożliwiając sobie przetestowanie relację między commandami a eventami.
Do uruchomienia należy w terminalu w folderze głównym wykonać polecenie "docker-compose up", który uruchomi kontener z Axon Server.
Dziękuję za szansę nauczenia się czegoś nowego :)
