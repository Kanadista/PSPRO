import java.util.ArrayList;
import java.util.List;

public class Contenedor {
    final List<int[]> dataList = new ArrayList<>();
    final int MAX = 10;

    synchronized public void put(int[] valor) {

        dataList.add(valor);

    }

    synchronized public int[] get() {

        int[] data = dataList.get(0);

        dataList.remove(0);

        return data;

    }

    synchronized public boolean isPutAvailable() {

        return dataList.size() == MAX;
    }


    synchronized public boolean isGetAvailable() {

        return dataList.isEmpty();
    }
}
