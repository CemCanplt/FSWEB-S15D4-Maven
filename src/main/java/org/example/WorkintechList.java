package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WorkintechList<T> extends ArrayList<T> {

    @Override
    public boolean add(T element) {
        // Eğer eleman listede yoksa ekle
        if (!this.contains(element)) {
            return super.add(element);
        }
        return false;
    }

    public void sort() {
        // String ve Numeric türleri sıralanır
        if (!this.isEmpty()) {
            if (this.get(0) instanceof String) {
                Collections.sort((ArrayList<String>) this); // String için alfabetik sıralama
            } else if (this.get(0) instanceof Number) {
                Collections.sort((ArrayList<Number>) this, Comparator.comparingDouble(a -> ((Number) a).doubleValue())); // Numeric sıralama
            }
        }
    }

    @Override
    public boolean remove(Object o) {
        // Elemanı sil ve ardından listeyi sırala
        boolean isRemoved = super.remove(o);
        if (isRemoved) {
            sort();
        }
        return isRemoved;
    }
}
