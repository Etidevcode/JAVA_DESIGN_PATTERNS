# Principe de responsabilité unique (SRP - Single Responsibility Principle)

+ Le sujet traité parle de l'exemple d'un contrôleur utilisateur dans une application Java simulant un service Web REST ou MVC. Il montre comment ce contrôleur viole le principe de responsabilité unique en incluant plusieurs responsabilités telles que la gestion des requêtes, la validation des utilisateurs et la persistance des données dans une base de données simulée.

Voici un résumé structuré :

1. **Introduction de l'exemple** :
    - Le sujet commence par expliquer qu'il va illustrer comment le principe de responsabilité unique est violé dans un exemple spécifique.

2. **Description du Contrôleur Utilisateur** :
    - Le contrôleur utilisateur reçoit les demandes du client, simulant un contrôleur dans une application MVC ou un service REST.
    - Il contient une méthode `createUser` qui reçoit une chaîne JSON représentant les informations de l'utilisateur, crée un utilisateur et retourne une réponse.

3. **Problème de Responsabilité Unique** :
    - Le contrôleur utilisateur actuel gère la validation des utilisateurs et la persistance dans une base de données simulée (HashMap).
    - Cette classe doit changer si les règles de validation ou la méthode de persistance changent, violant ainsi le principe de responsabilité unique.

4. **Solution proposée** :
    - On commence par déplacer les responsabilités distinctes (validation et persistance) dans des classes séparées.
    - Un `UserValidator` est introduit pour gérer la validation des utilisateurs.
    - Un `UserPersistenceService` est introduit pour gérer la persistance des utilisateurs dans la base de données.

5. **Refactorisation du Contrôleur Utilisateur** :
    - Le contrôleur utilisateur ne gère plus la validation ni la persistance directement.
    - Il utilise les services `UserValidator` et `UserPersistenceService` pour ces tâches respectives.
    - Cela rend le contrôleur utilisateur conforme au principe de responsabilité unique car il ne change que si la gestion des requêtes change.

6. **Conclusion et test** :
    - Le sujet conclut en soulignant l'importance des tests automatisés (JUnit) pour vérifier que les refactorisations n'introduisent pas de nouveaux bugs.
    - Enfin, il confirme que les tests fonctionnent toujours correctement après la refactorisation, validant ainsi la correction de la violation du principe de responsabilité unique.

En résumé, le sujet illustre comment identifier et corriger une violation du principe de responsabilité unique en déplaçant des responsabilités distinctes dans des classes séparées, ce qui rend le code plus modulaire, maintenable et conforme aux bonnes pratiques de conception logicielle.