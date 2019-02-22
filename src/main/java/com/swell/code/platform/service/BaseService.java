package com.swell.code.platform.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.swell.code.platform.dao.BaseRepository;

public interface BaseService<T, ID extends Serializable, R extends BaseRepository<T, ID>> {

	R getRepository();

	T save(T t);
	
	void save(Iterable<T> entities);

	T saveOrUpdate(T t);

	T findById(ID id);

	void deleteById(ID id);

	void delete(T t);

	List<T> findAll();

	List<T> findAll(Iterable<ID> ids);

	List<T> findAll(Sort sort);

	Page<T> findAll(Pageable pageable);

	Page<T> findAll(Pageable pageable, Example<T> example);

	void execute(String sql, Object... args);

	List<Object[]> query(String sql, Object... args);

	List<Object[]> queryPage(String sql, Map<String, Object> paramMap, int pageNumber, int pageSize);
}