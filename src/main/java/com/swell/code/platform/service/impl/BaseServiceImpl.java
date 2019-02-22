package com.swell.code.platform.service.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.swell.code.platform.dao.BaseRepository;
import com.swell.code.platform.service.BaseService;

public class BaseServiceImpl<T, ID extends Serializable, R extends BaseRepository<T, ID>> implements BaseService<T, ID, R> {

	@PersistenceContext
	protected EntityManager entityManager;
	@Autowired
	protected R baseRepository;

	@Override
	public R getRepository() {
		return baseRepository;
	}

	@Override
	public T save(T t) {
		return baseRepository.saveAndFlush(t);
	}

	@Override
	public void save(Iterable<T> entities) {
		baseRepository.saveAll(entities);
	}

	@Override
	public T saveOrUpdate(T t) {
		return baseRepository.saveAndFlush(t);
	}

	@Override
	public T findById(ID id) {
		Optional<T> optional = baseRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void deleteById(ID id) {
		baseRepository.deleteById(id);
	}

	@Override
	public void delete(T t) {
		baseRepository.delete(t);
	}

	@Override
	public List<T> findAll() {
		return baseRepository.findAll();
	}

	@Override
	public List<T> findAll(Iterable<ID> ids) {
		return baseRepository.findAllById(ids);
	}

	@Override
	public List<T> findAll(Sort sort) {
		return baseRepository.findAll(sort);
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return baseRepository.findAll(pageable);
	}

	@Override
	public Page<T> findAll(Pageable pageable, Example<T> example) {
		return baseRepository.findAll(example, pageable);
	}

	@Override
	public List<Object[]> query(String sql, Object... args) {
		Query nativeQuery = entityManager.createNativeQuery(sql);
		for (int i = 0; i < args.length; i++) {
			nativeQuery.setParameter(i, args[i]);
		}
		return nativeQuery.getResultList();
	}

	@Override
	public void execute(String sql, Object... args) {
		Query nativeQuery = entityManager.createNativeQuery(sql);
		for (int i = 0; i < args.length; i++) {
			nativeQuery.setParameter(i, args[i]);
		}
		nativeQuery.executeUpdate();
	}

	@Override
	public List<Object[]> queryPage(String sql, Map<String, Object> paramMap, int pageNumber, int pageSize) {
		Query nativeQuery = entityManager.createNativeQuery(sql);
		if (null != paramMap && paramMap.size() >0){
			Iterator<Map.Entry<String, Object>> iterator = paramMap.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, Object> entry = iterator.next();
				String key = entry.getKey();
				Object value = entry.getValue();
				nativeQuery.setParameter(key, value);
			}
		}
		int from = (pageNumber-1)*pageSize;
		nativeQuery.setFirstResult(from);
		nativeQuery.setMaxResults(pageSize);
		return nativeQuery.getResultList();
	}

}