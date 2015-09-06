package com.ncrash.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ncrash on 2015. 9. 6..
 * 특정한 인터페이스 타입을 찾음
 * bean lifecycle 중에 BeanPostProcessor를 써서 proxy 객체를 생성해주는 처리
 *
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

}
