# Manažment prístupu generáciou aspektov z konfiguračných súborov

V tomto projekte je skúmaná metodika práce s aspektami. Manažment prístupu je oddelený od základnej aplikácie a je riadený aspektami, ktoré budú automaticky generované pre aplikáciu pomocou konfiguračných súborov. V aktuálnej verzii tohto projektu, sú aspekty implementované manuálne.

## Balíky aplikácie

V tomto projekte je implementovaná jednoduchá konzolová aplikácia v balíku **Logistics**. Jej cieľom je simulovať funkcionalitu logistického systému. V tejto aplikácii je možné spravovať katalóg produktov a objednávky. V základnej aplikácii nie sú implementované žiadne bezpečnostné prvky a každý používateľ má v aplikácii neobmedzený prístup.

Táto aplikáciu obsahuje aj bezpečnostnú nadstavbu implementovanú v balíčku **Security**. Táto nadstavba upravuje funkcionalitu tejto aplikácie pomocou aspektovo orientovaného programovania. Implementuje autentizáciu používateľa, manažment prístupu a auditovanie. Pri spustení programu sa používateľ musí prihlásiť do používateľského konta, ktoré má priradené role. Role majú priradené práva, ktoré umožňujú vykonávať určité akcie v aplikácii. 

## Aspekty

- **Authenticator.aj** - zabezpečuje prihlásenie používateľa pri spustení programu a odhlásenie
- **PolicyAccess.aj** - zabezpečuje kontrolu práv používateľa pri vykonávaní operácii v aplikácii
- **Auditor.aj** - zabezpečuje auditovanie produktov pomocou paterny kukučkinho vajca

## Paterny

- **Kukučkino vajce** - využíva sa na auditovanie produktov. Keď vytvoríme nový produkt, tak je nahradený za auditovaný produkt, ak vytvorený produkt je stroj alebo nástroj. Ostatné produkty sú nezmenené. Auditovaný produkt si ukladá informácie o čase a používateľovi pri vytvorení a úprave. 