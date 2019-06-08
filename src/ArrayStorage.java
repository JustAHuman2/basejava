import java.util.Arrays;

public class ArrayStorage {

    private int size;

    private Resume[] storage = new Resume[10000];

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].toString()) {
                return i;
            }
        }
        return -1;
    }

    public void update(Resume r) {
        int index = getIndex(r.uuid);
        if (-1 == index) {
            System.out.println("Error, resume doesn't exist");
            return;
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        if (-1 != getIndex(r.uuid)) {
            System.out.println("Error, this resume is already in storage");
            return;
        }
        if (storage.length == size) {
            System.out.println("Error, storage is full");
            return;
        }
        storage[size] = r;
        size++;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (-1 == index) {
            System.out.println("Error, resume doesn't exist");
            return;
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            return;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (-1 == index) {
            return null;
        }
        return storage[index];
    }

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public Resume[] getAll() {
        if (size() == 0) {
            System.out.println("Resume storage is empty");
        }
        return Arrays.copyOf(storage, size);

    }

    public int size() {
        return size;
    }
}