public interface IMyList <T>{
    int getCapacity();
    int size();
    void add(T data);
    T get(int index);
    void remove(int index);
    void set(int index, T data);
    String toString();
    int indexOf(T data);
    int lastIndexOf(T data);
    boolean isEmpty();
    T[] toArray();
    void clear();
    MyList<T> subList(int start,int finish);
    boolean contains(T data);

}
