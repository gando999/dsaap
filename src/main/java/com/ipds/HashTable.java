package com.ipds;

public class HashTable<K, V> {

	private final HashTableItem<K, V>[] buckets;

	HashTable( final int capacity ) {
		buckets = new HashTableItem[capacity];
	}

	private int getBucketIndex( K key ) {
		final int hashCode = key.hashCode();
		return hashCode % buckets.length;
	}

	public void add( K key, V value ) {
		final int bucketIndex = getBucketIndex( key );
		HashTableItem<K, V> head = buckets[bucketIndex];
		while ( head != null ) {
			if ( head.getKey().equals( key )) {
				head.setValue( value );
			}
			head = head.next;
		}
		final HashTableItem<K, V> newItem = new HashTableItem<>( key, value );
		head = buckets[bucketIndex];
		newItem.next = head;
		buckets[bucketIndex] = newItem;
	}

	public V get( K key ) {
		final int bucketIndex = getBucketIndex( key );
		HashTableItem<K, V> head = buckets[bucketIndex];
		while ( head != null ){
			if ( head.getKey().equals( key ) ) {
				return head.getValue();
			}
			head = head.next;
		}
		return null;
	}

	public V remove( K key ) {
		final int bucketIndex = getBucketIndex( key );
		HashTableItem<K, V> head = buckets[bucketIndex];
		HashTableItem<K, V> prev = null;
		while ( head != null ) {
			if ( head.getKey().equals( key ) ) {
				break;
			}
			prev = head;
			head = head.next;
		}
		if ( head == null ) {
			return null;
		}
		if ( prev != null ) {
			prev.next = head.next;
		} else {
			buckets[bucketIndex] = head.next;
		}
		return head.getValue();
	}

	private static class HashTableItem <K, V> {
		private final K key;
		private V value;

		private HashTableItem<K, V> next;

		HashTableItem( K key, V value ) {
			this.key = key;
			this.value = value;
		}

		K getKey() {
			return key;
		}

		V getValue() {
			return value;
		}

		void setValue( V value ) {
			this.value = value;
		}
	}

}
