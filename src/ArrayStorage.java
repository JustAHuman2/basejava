import java.util.Arrays;

public class ArrayStorage {

    private int size;

    private Resume[] storage = new Resume[10_000];

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("Resume doesn't exist");
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            System.out.println("Resume is already in storage");
        } else if (size == storage.length) {
            System.out.println("Storage is full");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume doesn't exist");
            return null;
        }
        return storage[index];
    }

    public void clear() {
       for (int i = 0; i < size; i++){
           storage[i] = null;
       }
        size = 0;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume doesn't exist");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume[] getAll() {
        Resume[] result = new Resume[size];
        for (int i = 0; i < size; i++) {
            result[i] = storage[i];
        }
        return result;
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()) {
                return i;
            }
        }
        return -1;
    }
}