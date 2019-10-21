# JEE-LAB1-19

Przykład podstawowej obsługi bazy danych.

## Konfiguracja
Aby program poprawnie działał należy wykonać jedno z poniższych:
### 1. Modyfikacja persistence.xml
Plik znajduje się w _Other Sources_ (Netbeans) lub _src/main/resources/META-INF_ (bezwzględu na IDE).
```
 <property name="javax.persistence.jdbc.url" value="jdbc:derby://<adres bd>"/>
 <property name="javax.persistence.jdbc.user" value="<login do bd>"/>
 <property name="javax.persistence.jdbc.driver" value="org.apache.derby.jdbc.ClientDriver"/>
 <property name="javax.persistence.jdbc.password" value="<haslo do bd>"/>
```

### 2. Utworzenie bazy danych zgodnej z persistence.xml
Skypt do utworzenia bazy danych zgodnej z zamieszczonym kodem:
```
create table "PC".T1
(
	C1_STRINGS VARCHAR(40) not null primary key,
	C2_INT INTEGER
)
```
