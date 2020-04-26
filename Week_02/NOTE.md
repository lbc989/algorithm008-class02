学习笔记

```
public class HashMap<K,V>
extends AbstractMap<K,V>
implements Map<K,V>, Cloneable, Serializable
```

基于哈希表的实现的`Map`接口。允许`null的`值和`null`键。 （ `HashMap`类大致相当于`Hashtable` ，除了它是不同步的，并允许null）。这个类不能保证map的顺序; 特别是，它不能保证顺序在一段时间内保持不变。

| Modifier and Type | Method and Description                                       |
| :---------------- | :----------------------------------------------------------- |
| `void`            | `clear()`从这张map中删除所有的映射。                         |
| `Object`          | `clone()`返回此 `HashMap`实例的浅拷贝：键和值本身不被克隆。  |
| `V`               | `compute(K key, BiFunction remappingFunction)`尝试计算用于指定键和其当前映射的值的映射（或 `null`如果没有当前映射）。 |
| `boolean`         | `containsKey(Object key)`如果此映射包含指定键的映射，则返回 `true` 。 |
| `boolean`         | `containsValue(Object value)`如果此map将一个或多个键映射到指定值，则返回 `true` 。 |
| `Set>`            | `entrySet()`返回此地图中包含的映射的[`Set`](http://www.matools.com/file/manual/jdk_api_1.8_google/java/util/Set.html)视图。 |
| `void`            | `forEach(BiConsumer action)`对此映射中的每个条目执行给定的操作，直到所有条目都被处理或操作引发异常。 |
| `V`               | get(Object key)`返回到指定键所映射的值，或 `null`如果此映射不包含该键的映射。 |
| `V`               | `getOrDefault(Object key, V defaultValue)`返回到指定键所映射的值，或 `defaultValue`如果此映射不包含该键的映射。 |
| `boolean`         | `isEmpty()`如果此地图不包含键值映射，则返回 `true` 。        |
| `Set`             | `keySet()`返回此地图中包含的键的[`Set`](http://www.matools.com/file/manual/jdk_api_1.8_google/java/util/Set.html)视图。 |
| `V`               | `merge(K key, V value, BiFunction remappingFunction)`如果指定的键尚未与值相关联或与null相关联，则将其与给定的非空值相关联。 |
| `V`               | `put(K key, V value)`将指定的值与此映射中的指定键相关联。    |
| `void`            | `putAll(Map m)`将指定地图的所有映射复制到此map。             |
| `V`               | `putIfAbsent(K key, V value)`如果指定的键尚未与某个值相关联（或映射到 `null` ），则将其与给定值相关联并返回 `null` ，否则返回当前值。 |
| `V`               | `remove(Object key)`从该map中删除指定键的映射（如果存在）。  |
| `boolean`         | `remove(Object key, Object value)`仅当指定的密钥当前映射到指定的值时删除该条目。 |
| `V`               | `replace(K key, V value)`只有当目标映射到某个值时，才能替换指定键的条目。 |
| `boolean`         | `replace(K key, V oldValue, V newValue)`仅当当前映射到指定的值时，才能替换指定键的条目。 |
| `void`            | `replaceAll(BiFunction function)`将每个条目的值替换为对该条目调用给定函数的结果，直到所有条目都被处理或该函数抛出异常。 |
| `int`             | `size()`返回此map中键值映射的数量。                          |
| `Collection`      | `values()`返回此map中包含的值的Collection视图。              |

**HashMap的数据存储结构**
1、HashMap由数组和链表来实现对数据的存储
HashMap采用Entry数组来存储key-value对，每一个键值对组成了一个Entry实体，Entry类实际上是一个单向的链表结构，它具有Next指针，可以连接下一个Entry实体，以此来解决Hash冲突的问题。

数组存储区间是连续的，占用内存严重，故空间复杂的很大。但数组的二分查找时间复杂度小，为O(1)；数组的特点是：寻址容易，插入和删除困难；

链表存储区间离散，占用内存比较宽松，故空间复杂度很小，但时间复杂度很大，达O（N）。链表的特点是：寻址困难，插入和删除容易。

一个长度为16的数组中，每个元素存储的是一个链表的头结点。那么这些元素是按照什么样的规则存储到数组中呢。一般情况是通过hash(key.hashCode())%len获得，也就是元素的key的哈希值对数组长度取模得到。12%16=12,28%16=12,108%16=12,140%16=12。所以12、28、108以及140都存储在数组下标为12的位置。

HashMap里面实现一个静态内部类Entry，其重要的属性有 hash，key，value，next。

HashMap里面用到链式数据结构的一个概念。Entry类里面有一个next属性，作用是指向下一个Entry。打个比方， 第一个键值对A进来，通过计算其key的hash得到的index=0，记做:Entry[0] = A。一会后又进来一个键值对B，通过计算其index也等于0，现在怎么办？HashMap会这样做:B.next = A,Entry[0] = B,如果又进来C,index也等于0,那么C.next = B,Entry[0] = C；这样我们发现index=0的地方其实存取了A,B,C三个键值对,他们通过next这个属性链接在一起。也就是说数组中存储的是最后插入的元素。

在Jdk1.8中HashMap的实现方式做了一些改变，但是基本思想还是没有变得，只是在一些地方做了优化，数据结构的存储由数组+链表的方式，变化为数组+链表+红黑树的存储方式，当链表长度超过阈值（8）时，将链表转换为红黑树。在性能上进一步得到提升。