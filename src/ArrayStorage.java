import java.util.Arrays;

public class ArrayStorage {

    private int size;

    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < size; i++) {
            if (r.toString() == storage[i].toString()) {
               return;
            }
        }
        storage[size] = r;
        size++;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].toString()) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                return;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].toString()) {
                return storage[i];
            }
        }
        return null;
    }

    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}