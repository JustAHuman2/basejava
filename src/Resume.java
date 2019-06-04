/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    String uuid;

   public String getUuid (){
        return uuid;
    }

    @Override
    public boolean equals(Object obj) {
        Resume otherResume = (Resume) obj;
        return this.uuid == otherResume.uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }
}


