package hello.itemservice.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ItemRepositoryTest {

    private val itemRepository = ItemRepository()

    @AfterEach
    fun afterEach() {
        itemRepository.clearStore()
    }

    @Test
    fun save() {
        // given
        val item = Item(
            "itemA",
            16000,
            5
        )
        // when
        val savedItem = itemRepository.save(item)

        // then
        val findItem = itemRepository.findById(item.id)
        Assertions.assertThat(findItem).isEqualTo(savedItem)
    }

    @Test
    fun findAll() {
        // given
        val item1 = Item(
            "itemA",
            16000,
            3
        )

        val item2 = Item(
            "itemA",
            16000,
            3
        )
        // when
        itemRepository.save(item1)
        itemRepository.save(item2)

        val findItems = itemRepository.findAll()

        // then
        Assertions.assertThat(findItems.size).isEqualTo(2)
        Assertions.assertThat(findItems).contains(item1, item2)
    }

    @Test
    fun updateItem() {
        // given
        val item = Item(
            "itemA",
            16000,
            5
        )
        val savedItem = itemRepository.save(item)
        val itemId = savedItem.id

        // when
        val updateParam = Item("itemB", 20000, 30)
        itemRepository.update(item.id, updateParam)

        val findItem = itemRepository.findById(item.id)

        // then
        Assertions.assertThat(findItem.itemName).isEqualTo(updateParam.itemName)
        Assertions.assertThat(findItem.price).isEqualTo(updateParam.price)
        Assertions.assertThat(findItem.quantity).isEqualTo(updateParam.quantity)
    }
}