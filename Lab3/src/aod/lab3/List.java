package aod.lab3;

/**
 * Interface som beskriver grundläggande operationer för en lista.
 *
 * @param <T> typen av element i listan
 * @author Abdisalan Mahad Omar
 * @version 2026-04-27
 */
public interface List<T> extends Iterable<T> {

    /**
     * Lägger till ett element sist i listan.
     *
     * @param data elementet som ska läggas till
     */
    void add(T data);

    /**
     * Lägger till ett element på angivet index.
     *
     * @param data elementet som ska läggas till
     * @param index positionen där elementet ska läggas till
     */
    void add(T data, int index);

    /**
     * Hämtar elementet på angivet index.
     *
     * @param index positionen i listan
     * @return elementet på angivet index
     */
    T get(int index);

    /**
     * Ersätter elementet på angivet index.
     *
     * @param data det nya elementet
     * @param index positionen som ska ändras
     */
    void set(T data, int index);

    /**
     * Tar bort det sista elementet i listan.
     */
    void remove();

    /**
     * Tar bort elementet på angivet index.
     *
     * @param index positionen som ska tas bort
     */
    void remove(int index);

    /**
     * Returnerar antal element i listan.
     *
     * @return antal element
     */
    int size();

    /**
     * Tömmer listan.
     */
    void clear();
}