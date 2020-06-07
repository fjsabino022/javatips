package com.fsabino.javacodingtips.collections_framework.collection;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class unmodificableList {

    public static void main(String[] args) {

        // empty list of Collections is unmodificable.
        List<String> list = Collections.emptyList();
        try {
            list.add("hola");
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }

        /**
         * Exception in thread "main" java.lang.UnsupportedOperationException
         *             at java.util.AbstractList.add(AbstractList.java:148)
         *             at java.util.AbstractList.add(AbstractList.java:108)
         *             at com.fsabino.javacodingtips.collections_framework.collection.unmodificableList.main(unmodificableList.java:12)
         */

        // Guava allows us to modify a list
        List<String> listModificable = Lists.newArrayList();
        listModificable.add("hola");
        System.out.println(listModificable.toString());
    }
}
