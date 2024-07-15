# Principe de substitution de Liskov (LSP)

Le **principe de substitution de Liskov (Liskov Substitution Principle - LSP)** est l'un des cinq principes SOLID de la programmation orientée objet. Formulé par Barbara Liskov en 1987, il stipule que les objets d'une classe dérivée doivent pouvoir remplacer les objets de la classe de base sans altérer le comportement attendu du programme. Voici un résumé détaillé de ce principe, sans utiliser de code :

### Définition du principe de substitution de Liskov (LSP)

Le principe de substitution de Liskov affirme que si *S* est une sous-classe de *T*, alors les objets de type *T* doivent pouvoir être remplacés par des objets de type *S* sans modifier les propriétés désirables du programme, c'est-à-dire sans introduire d'erreurs.

### Explication avec un exemple conceptuel

#### Contexte

Considérons une hiérarchie de classes représentant des formes géométriques, où `Rectangle` (rectangle) est une classe de base et `Square` (carré) est une sous-classe. Logiquement, un carré est un type particulier de rectangle où tous les côtés sont égaux. Cela pourrait suggérer que `Square` peut hériter de `Rectangle`.

#### Problème

Supposons que la classe `Rectangle` ait des méthodes pour définir la largeur (`setWidth`) et la hauteur (`setHeight`). Si nous créons un carré en utilisant cette hiérarchie, nous devons redéfinir ces méthodes pour que la largeur et la hauteur soient toujours égales (puisqu'un carré a tous ses côtés de la même longueur).

Cette redéfinition modifie le comportement attendu de la classe de base `Rectangle` :

1. **Violation des attentes** : Les méthodes `setWidth` et `setHeight` de `Rectangle` supposent que largeur et hauteur peuvent être définies indépendamment. Pour un carré, ces méthodes doivent être redéfinies pour maintenir les côtés égaux, ce qui viole l'interface et les attentes de la classe de base.

2. **Incohérence** : Si un carré est passé à une méthode qui s'attend à un rectangle, cette méthode peut se comporter de manière inattendue. Par exemple, si la méthode change la largeur d'un rectangle, elle s'attend à ce que seule la largeur change. Avec un carré, changer la largeur change aussi la hauteur, ce qui conduit à des incohérences.

#### Solution respectant LSP

Pour respecter le LSP, il est préférable de ne pas utiliser l'héritage dans ce cas. Au lieu de cela, nous pouvons utiliser une abstraction commune, comme une interface ou une classe de base abstraite, que les rectangles et les carrés implémenteront séparément :

- **Interface commune** : Définir une interface `Shape` avec des méthodes communes comme `calculateArea`.
- **Implémentations séparées** : `Rectangle` et `Square` implémenteront cette interface de manière indépendante, chacun avec sa propre logique pour gérer les attributs de la forme (largeur, hauteur pour le rectangle; côté pour le carré).

### Points clés du LSP

1. **Comportement attendu** : Les sous-classes doivent maintenir les comportements attendus définis par la classe de base. Les méthodes des sous-classes ne doivent pas violer les contrats établis par les méthodes de la classe de base.

2. **Interchangeabilité** : Les instances de la sous-classe doivent pouvoir remplacer les instances de la classe de base sans affecter la fonctionnalité du programme. Cela signifie que le comportement des méthodes doit rester cohérent et prévisible.

3. **Principe de conception** : LSP guide les concepteurs à structurer les relations de classe de manière à garantir que les sous-classes sont réellement substituables pour leurs classes de base. Cela conduit à des systèmes plus robustes, faciles à comprendre et à maintenir.

4. **Exemples courants de violation** : Les violations courantes de LSP se produisent lorsqu'une sous-classe modifie les contraintes ou les comportements de la classe de base, comme dans l'exemple du rectangle et du carré. D'autres exemples incluent les sous-classes qui lèvent des exceptions non attendues ou qui modifient les valeurs retournées de manière imprévisible.

### Conclusion

Le principe de substitution de Liskov est crucial pour garantir que les systèmes orientés objet sont bien conçus, robustes et maintenables. Il assure que les sous-classes peuvent remplacer leurs classes de base sans introduire de comportements incorrects ou inattendus, ce qui est essentiel pour l'évolutivité et la fiabilité des logiciels.