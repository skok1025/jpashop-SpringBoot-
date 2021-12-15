package jpabook.jpashop;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jpabook.jpashop.domain.Member;

@Repository
public class MemberRepository {
	
	@Autowired
	private EntityManager em;
	
	public Long save(Member m) {
		em.persist(m);
		
		return m.getId();
	}
	
	public Member find(Long id) {
		return em.find(Member.class, id);
	}

}
