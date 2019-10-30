# Kata2
## Histograma

**Objetivo**
- Dado un array que se rellenará de valores enteros realizar una aplicación de consola para el cálculo del histograma, es decir la frecuencia de cada valor en ese array

## Introducción
Hay determinadas clases que manipulan objetos (ArrayList, HashMap, ...).

Para poder utilizar tipos primitivos con estas clases, Java provee las llamadas **clases envolventes**, también llamadas clases contenedoras o **Wrappers** (Integer, Double, etc.). Estas clases proporcionan métodos que permiten manipular el tipo de dato primitivo como si fuese un objeto. 

Las conversiones entre los tipos primitivos y sus clases envolventes (y viceversa) son automáticas. No es necesario hacer un casting. Para realizarlas Java utiliza el **Autoboxing**.

A lo largo de las versiones de esta Kata2 usaremos un mapa (Array Asociativo) y lo implementaremos como *HashMap*. Inicialmente, tanto la clave como los valores podrán ser objetos de tipo entero (Integer). 

Además de los métodos `put()` y `get()`también se tienen estos:
* `containsKey(Object Key)` => comprueba si el mapa contiene la clave *Key*.
* `keySet()` => obtiene el conjunto de claves del mapa.

## Iteración sobre mapas
Hay varias formas de iterar sobre un Mapa en Java. Vamos a repasar los métodos más comunes y revisar sus ventajas y desventajas.

Dado que todos los mapas en Java implementan la interfaz de Mapa, las siguientes técnicas funcionarán para cualquier implementación de un mapa (HashMap, TreeMap, LinkedHashMap, Hastable, etc.)

### Método nº1. Iteración sobre las entradas utilizando un bucle *For-Each*
Este es el método más común y es preferible en la mayoría de los casos. Debería usarse si se necesita en cada iteración tanto las claves como los valores del mapa. 

```java
Map<Integer, Integer> map = new HashMap<Integer, Integer>();
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
}
```

Este tipo de bucle lanzará un *NullPointerException* si se intenta iterar sobre un mapa que es nulo, por lo que antes de iterar siempre se debería verificar las referencias nulas. 

### Método nº2. Iteración sobre claves o valores utilizando un bucle *For-Each*
Si solo se necesita claves o valores del mapa, se puede iterar sobre `keySet` o `values` en lugar de `entrySet`.

```java
Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//iterar solo sobre claves
for (Integer key : map.keySet()){
    System.out.println("Key = " + key);
}

//iterar solo sobre valores
for (Integer value : map.value()) {
    System.out.println("Value = " + value);
}
```

Este método proporciona una ligera ventaja de rendimiento sobre la iteración `keySet` (aproximadamente un 10% más rápido) y es más limpio. 

### Método nº3. Iteración usando *Iterator*
#### Opción a): usando *Generics*
```java
Map<Integer, Integer> map = new HashMap<Integer, Integer>();
Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
while (entries.hashNext()) {
    Map.Entry<Integer, Integer> entry = entries.next();
    System.out.println("Key = " + entry.getKey() " + ", Value = " + entry.getValue());
}
```
#### Opción b): sin usar *Generics*
```java
Map map = new HashMap();
Iterator entries = map.entrySet().iterator();
while (entries.hashNext()) {
    Map.Entry entry = (Map.Entry) entries.next();
    Integer key = (Integer) entry.getKey();
    Integer value = (Integer) entry.getValue();
    System.out.println("Key = " + key + ", Value = " + value);
}
```
También se puede usar la misma técnica para iterar sobre `keySet` o `values`.

Este método puede parecer redundante pero tiene sus propias ventajas:
1) Es la única forma de iterar sobre un mapa en versiones anteriores de Java y
2) Es el único método que permite eliminar entradas del mapa durante la iteración llamando a `iterator.remove()`. Si se intenta hacer esto durante la iteración *For-Each* se obtendrá *"resultados impredecibles*" según javadoc. 

Desde el punto de vista del rendimiento, este método es igual a *For-Each*.

### Método nº4. Iteración sobre claves y búsqueda de valores (ineficaz).

```java
Map<Integer, Integer> map = new HashMap<Integer, Integer>();
for (Integer key : map.keySet()) {
    Integer value = map.get(key);
    System.out.println("Key = " + key + ", Value = " + value);
}
```

Esto podría parecer una alternativa más limpia para el método nº1 pero en la práctica es bastante lento e ineficaz ya que obtener valores con una clave puede consumir mucho tiempo. Ese método debe ser evitado en lo posible. 

### Conclusión
Si solo necesita claves o valores del mapa, usa el método nº2. Si está atascado con una verión anterior de Java (menor de Java 5) o planea eliminar entradas durante la iteración, debe usar el método nº3. De lo contrario, usar el método nº1. 

## Atajos en NETBEANS para bucles for
![](https://github.com/gitfrandu4/Kata2/blob/master/images/forShortcuts.png "")
