package com.swell.code.platform.service.impl;

import com.swell.code.platform.dao.PlatformUserRepository;
import com.swell.code.platform.entity.PlatformUser;
import com.swell.code.platform.service.PlatformUserService;
import com.swell.code.platform.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlatformUserServiceImpl extends BaseServiceImpl<PlatformUser, String, PlatformUserRepository> implements PlatformUserService {

    @Autowired
    private PlatformUserRepository platformUserRepository;

    @Override
    public PlatformUser findByUsername(String username) {
        return platformUserRepository.findByUsername(username);
    }

    @Override
    public Page<PlatformUser> findAll(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.DESC, "createTime");
        return platformUserRepository.findAll(pageRequest);
    }

    @Override
    public Page<PlatformUser> findAll(int pageNumber, int pageSize, final String startDate, final String endDate, final String searchText) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.DESC, "createTime");
        Page<PlatformUser> page = platformUserRepository.findAll(new Specification<PlatformUser>() {

            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<PlatformUser> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (!StringUtils.isEmpty(searchText)) {
                    List<Predicate> restrictions = new ArrayList<>();
                    restrictions.add(cb.like(root.get("username"), "%" + searchText + "%"));
                    restrictions.add(cb.like(root.get("realName"), "%" + searchText + "%"));
                    restrictions.add(cb.like(root.get("contactInformation"), "%" + searchText + "%"));
                    predicates.add(cb.or(restrictions.toArray(new Predicate[]{})));
                }
                if (!StringUtils.isEmpty(startDate)) {
                    predicates.add(cb.greaterThanOrEqualTo(root.get("createTime"), DateUtil.str2date(startDate)));
                }
                if (!StringUtils.isEmpty(endDate)) {
                    predicates.add(cb.lessThan(root.get("createTime"), DateUtil.str2date(endDate)));
                }
                return cb.and(predicates.toArray(new Predicate[]{}));
            }
        }, pageRequest);
        return page;
    }

}
