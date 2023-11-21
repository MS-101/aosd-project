# Manažment prístupu pomocou aspektov a konfiguračných súborov

V tomto projekte je skúmaná metodika práce s aspektami. Manažment prístupu je oddelený od základnej aplikácie a je riadený aspektami, ktorých funkcionalita definovaná v konfiguračných súborov. Tento projekt slúži ako príklad aplikácie, ktorá využíva tieto bezpečnostné aspekty. Manažment prístupu je implementovaný dostatočne genericky aby mohol byť použitý aj v iných konzolových aplikáciach.

## Balíky aplikácie

V tomto projekte je implementovaná jednoduchá konzolová aplikácia v balíku **Logistics**. Jej cieľom je simulovať funkcionalitu logistického systému. V tejto aplikácii je možné spravovať katalóg produktov a objednávky. V základnej aplikácii nie sú implementované žiadne bezpečnostné prvky a každý používateľ má v aplikácii neobmedzený prístup.

Táto aplikáciu obsahuje aj bezpečnostnú nadstavbu implementovanú v balíčku **Security**. Táto nadstavba upravuje funkcionalitu tejto aplikácie pomocou aspektovo orientovaného programovania. Implementuje autentizáciu používateľa, manažment prístupu a auditovanie. Pri spustení programu sa používateľ musí prihlásiť do používateľského konta, ktoré má priradené role. Role majú priradené práva, ktoré umožňujú vykonávať určité akcie v aplikácii. Politika práv 

## Konfigurácia

Konfigurácia manažmentu prístupu je riadená pomocou 5 konfiguračných súborov, ktoré využívajú json súbory.

- **basic.json** - základná konfigurácia, potrebná na aplikovanie autentifikácie pred spustením aplikácie, možnosť odhlásenia a inštrukčných správ. 
- **permissions.json** - sú tu definované všetky aplikačné práva.
- **roles.json** - sú tu definované všetky role a ich práva.
- **users.json** - sú tu definovaný všetci používatelia a ich role.
- **policies.json** - je tu definavaná politika prístupu. Musí byť uvedený názov funkcie a všetky práva, ktoré sú potrebné na jej vykonanie.

## Aspekty

- **Authenticator.aj** - zabezpečuje prihlásenie používateľa pri spustení programu a odhlásenie
- **PolicyAccess.aj** - zabezpečuje kontrolu práv používateľa pri vykonávaní operácii v aplikácii 