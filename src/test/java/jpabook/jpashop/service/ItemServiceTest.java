package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    @Transactional
    public void testSaveItem() {
        // given
        Item item = new Book();
        item.setName("My Book");
        item.setPrice(1000);
        item.setStockQuantity(100);
        // when
        itemRepository.save(item);
        // then
        Item findItem = itemRepository.findOne(item.getId());

        Assertions.assertThat(findItem.getId()).isEqualTo(item.getId());
    }
}