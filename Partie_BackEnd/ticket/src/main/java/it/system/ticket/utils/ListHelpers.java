package it.system.ticket.utils;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ListHelpers {
    public static <T> List<T> iteratorToList(Iterator<T> iterator) {
        Iterable<T> iterable = () -> iterator;
        List<T> list = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        return list;
    }
}