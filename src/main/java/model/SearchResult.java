package model;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import lombok.Data;

@Data
public abstract class SearchResult<T> {

	private int totalProducts = 0;
    private int pageSize = 25;
    private ConcurrentHashMap<String,List<T>> products = null;
    
    
}
