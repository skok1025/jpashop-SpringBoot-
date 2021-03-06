package jpabook.jpashop;

import javax.transaction.Transactional;

import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import jpabook.jpashop.domain.Member;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testMember() throws Exception {
		// given
		Member member = new Member();
		member.setName("memberA");
		
		//when
		Long saveId = memberRepository.save(member);
		
		//then
		Member findMember = memberRepository.findOne(saveId);
		
		Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
		Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
		Assertions.assertThat(findMember).isEqualTo(member);
	}
}
