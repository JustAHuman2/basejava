import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if ((null != storage[i]) && (uuid == (storage[i].getUuid()))) {
                return storage[i];
            }
        }
        return null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        ArrayList<Resume> resumes = new ArrayList<>();
        for (int i = 0; i < storage.length; i++) {
            if (null != storage[i]) {
                resumes.add(storage[i]);
            }
        }
        Resume[] result = new Resume[resumes.size()];
        for (int i = 0; i < resumes.size(); i++) {
            result[i] = resumes.get(i);
        }
        return result;
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if ((null != storage[i]) && (r.equals(storage[i]))) {
                return;
            }
        }
        for (int i = 0; i < storage.length; i++) {
            if (null == storage[i]) {
                storage[i] = r;
                Arrays.sort(storage, new ResumeSort());
                break;
            }
        }
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if ((null != storage[i]) && (uuid == (storage[i].getUuid()))) {
                storage[i] = null;
                Arrays.sort(storage, new ResumeSort());
                break;
            }
        }
    }

    int size() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (null != storage[i]) {
                count++;
            }
        }
        return count;
    }

    public class ResumeSort implements Comparator<Resume> {
        public int compare(Resume left, Resume right) {
            if (((left != null) & (right != null)) || ((left == null) & (right == null))) {
                return 0;
            }
            if ((left != null) & (right == null)) {
                return 1;
            }
            if ((left == null) & (right != null)) {
                return -1;
            }
            return compare(left, right);
        }
    }
}