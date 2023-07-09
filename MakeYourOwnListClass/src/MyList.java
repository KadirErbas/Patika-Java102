public class MyList<T> implements IMyList<T>{
    private int capacity;
    private T[] array ;

    public MyList() {
        this.capacity = 10;
        this.array = (T[]) new Object [capacity];
    }
    public MyList(int capacity){
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < this.capacity; i++){
            if(array[i] != null){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public void add(T data) {
        if(this.capacity == this.size()){
            this.capacity *= 2;
            T[] newArray = (T[]) new  Object[this.capacity];
            for (int i = 0; i < this.capacity/2; i++) {
                newArray[i] = this.array[i];
            }
            newArray[this.capacity/2] = data;
            this.array = newArray;
        }else {
            this.array[this.size()] = data;
        }
    }

    @Override
    public T get(int index) {
        return this.array[index];
    }

    @Override
    public void remove(int index) {
        this.array[index] = null;
        for (int i = index; i < size(); i++) {
            if (array[i+1] != null){
                array[i] = array[i+1];
                array[i+1] = null;
            }
        }
    }

    @Override
    public void set(int index, T data) {
        this.array[index] =  data;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            sb.append(array[i]);
            if (i != size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    @Override
    public int indexOf(T data) {
        for (int i = 0; i < size(); i++) {
            if(array[i].equals(data)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T data) {
        for (int i = size()-1; i >= 0 ; i--) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public T[] toArray() {
        return  array;
    }

    @Override
    public void clear() {
        this.capacity = 10;
        this.array = (T[]) new Object[capacity];
    }

    @Override
    public MyList<T> subList(int start, int finish) {
        MyList<T> substring = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            substring.add(get(i));
        }
        return substring;
    }

    @Override
    public boolean contains(T data) {
        for (int i = 0; i < size(); i++) {
            if(array[i].equals(data)) return true;
        }
        return false;
    }
}
