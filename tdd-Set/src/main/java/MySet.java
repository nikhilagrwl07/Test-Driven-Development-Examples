public class MySet {

    private int[] myset;
    private int currentIndex = -1;

    public MySet() {
        myset = new int[10];
    }

    public MySet(int intialSizeOfSet) {
        myset = new int[intialSizeOfSet];
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public boolean insert(int newElement) {

        // checking already existing element
        if (exists(newElement))
            return false;

        if (isResizingRequired()) {
            resize();
        }

        incrementCurrentIndex();
        myset[getCurrentIndex()] = newElement;
        return true;
    }

    private boolean isResizingRequired() {
        return getCurrentIndex() + 1 > (myset.length / 2);
    }

    private void resize() {
        // resize of existing set to twice
        int[] tmpMySet = new int[myset.length * 2];

        for (int i = 0; i <= getCurrentIndex(); i++) {
            tmpMySet[i] = myset[i];
        }
        myset = tmpMySet;

    }

    boolean exists(int newElement) {
        for (int e : myset) {

            if (e == newElement)
                return true;
        }
        return false;
    }

    public int size() {
        return getCurrentIndex() + 1;
    }

    public void decrementCurrentIndex() {
        currentIndex--;
    }

    public void incrementCurrentIndex() {
        currentIndex++;
    }

    public boolean delete(int elementToBeDeleted) {

        int indexOfElementTobeDeleted = -1;

        for (int i = 0; i < getCurrentIndex(); i++) {
            if (myset[i] == elementToBeDeleted) {
                indexOfElementTobeDeleted = i;
                break;
            }
        }

        if (indexOfElementTobeDeleted > -1) {
            // delete the element by shifting all right element from that element to one left side
            for (int i = indexOfElementTobeDeleted; i < getCurrentIndex(); i++) {
                myset[i] = myset[i + 1];
            }
            decrementCurrentIndex();
            return true;
        }

        return false;
    }
}
