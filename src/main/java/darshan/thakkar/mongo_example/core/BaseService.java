package darshan.thakkar.mongo_example.core;

import java.util.List;

public interface BaseService<T> {

	List<T> getAllDocuments();

	T save(T requestedEl);

	T update(String id, T requestedEl);

	boolean deleteById(String id);
}
