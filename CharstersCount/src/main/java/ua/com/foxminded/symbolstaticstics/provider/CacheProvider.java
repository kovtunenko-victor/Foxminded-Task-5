package ua.com.foxminded.symbolstaticstics.provider;

public interface CacheProvider<K, V> {
   void put(K key, V symbolToCounter);

   V get(K key);

   boolean isPresent(K key);
}
