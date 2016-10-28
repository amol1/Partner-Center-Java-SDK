package com.microsoft.univstore.partnercentersdk.models.utils;

public class KeyValuePair<K, V>
{
    private K key;

    private V value;

    public KeyValuePair()
    {
    }

    public KeyValuePair( K key, V value )
    {
        this.key = key;
        this.value = value;
    }

    public K getKey()
    {
        return key;
    }

    public V getValue()
    {
        return value;
    }

}
