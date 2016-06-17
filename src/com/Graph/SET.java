package com.Graph;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

/**
 * Created by v-vetula on 6/17/2016.
 */
public class SET<key extends Comparable<key>> implements Iterable<key> {
    private TreeSet<key> set;

    public SET() {
        set = new TreeSet<key>();
    }

    public SET(SET<key> x) {
        set = new TreeSet<key>();
    }

    public void add(key key) {
        if (key == null) throw new NullPointerException("called add() with a null key");
        set.add(key);
    }

    public boolean contains(key key) {
        if (key == null) throw new NullPointerException("called contains() with a null key");
        return set.contains(key);
    }

    public void delete(key key) {
        if (key == null) throw new NullPointerException("called delete() on a null key");
        set.remove(key);
    }

    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<key> iterator() {
        return set.iterator();
    }

    public key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() on an empty set");
        return set.last();
    }

    public key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() on an empty set");
        return set.first();
    }

    public key ceiling(key key) {
        if (key == null) throw new NullPointerException("called ceiling() on null set");
        key k = set.ceiling(key);
        if (k == null) throw new NoSuchElementException("all keys are less than " + k);
        return k;
    }

    public key floor(key key) {
        if (key == null) throw new NullPointerException("called floor() on null set");
        key k = set.floor(key);
        if (k == null) throw new NoSuchElementException("all keys are grater than : " + k);
        return k;
    }

    public SET<key> union(SET<key> that) {
        if (that == null) throw new NullPointerException("called on a null set");
        SET<key> c = new SET<key>();
        for (key x : this) {
            c.add(x);
        }
        for (key x : that) {
            c.add(x);
        }
        return c;
    }

    public SET<key> intersects(SET<key> that) {
        if (that == null) throw new NullPointerException("called on a null set");
        SET<key> c = new SET<key>();
        if (this.size() < that.size()) {
            for (key x : this) {
                if (that.contains(x)) c.add(x);
            }
        } else {
            for (key x : that) {
                if (this.contains(x)) c.add(x);
            }
        }

        return c;
    }

    public boolean equals(Object other){
        if(other == this) return true;
        if(other == null) return false;
        if(other.getClass() != this.getClass()) return false;
        SET that = (SET) other;
        return this.set.equals(that.set);
    }
}
