# Principe ouvert-fermé

+ **Le principe ouvert-fermé**, qui fait partie des principes **SOLID** en programmation orientée objet, stipule que les modules (classes, fonctions, etc.) doivent être ouverts à l'extension mais fermés à la modification. Cela signifie qu'une classe doit être conçue de manière à pouvoir être étendue sans nécessiter de modifications dans son code source.

**Résumé du principe ouvert-fermé :**


**1. Héritage et abstraction :**

+ Utiliser l'héritage pour étendre les fonctionnalités d'une classe sans modifier son code source. Les classes de base contiennent des méthodes et propriétés communes, tandis que les classes dérivées implémentent ou étendent ces fonctionnalités.

**2. Eviter la duplication :**

+ Identifier et extraire les propriétés et méthodes communes dans une classe de base pour éviter la duplication de code. Par exemple, dans le cas des classes `ISPSubscriber` et `PhoneSubscriber`, des propriétés telles que **subscriberId, address, et phoneNumber** sont communes et peuvent être placées dans une classe de base **Subscriber**.

**3. Méthodes abstraites :**

+ Définir des méthodes abstraites dans les classes de base pour les comportements qui varient selon les sous-classes. Par exemple, la méthode calculateBill peut être abstraite dans la classe de base et implémentée différemment dans chaque sous-classe.

**4. Extension des classes :**

+ Lorsque de nouveaux comportements ou services sont nécessaires (comme l'ajout d'un service VoIP), créer de nouvelles classes dérivées qui implémentent les méthodes abstraites de la classe de base. Cela permet d'ajouter de nouvelles fonctionnalités sans modifier le code existant des classes de base ou des autres classes dérivées.
