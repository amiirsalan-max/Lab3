package aod.lab3;

/**
 * Interface som beskriver vad en lista ska kunna göra.
 *
 * @param <T> typen av element i listan
 * @author Abdisalan Mahad Omar
 * @date 2026-04-27
 */
public interface List<T> extends Iterable<T> {

	void add(T data);

	void add(T data, int index);

	T get(int index);

	void set(T data, int index);

	void remove();

	void remove(int index);

	int size();

	void clear();
}