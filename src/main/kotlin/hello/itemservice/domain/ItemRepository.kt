package hello.itemservice.domain

import org.springframework.stereotype.Repository

@Repository
class ItemRepository {

    companion object {
        private val store: MutableMap<Long, Item> = HashMap()
        private var sequence = 0L
    }

    fun save(item: Item): Item {
        item.id = ++sequence
        store[sequence] = item
        return item
    }

    fun findById(itemId: Long): Item {
        return store[itemId]!!
    }

    fun findAll(): MutableList<Item> {
        val itemList = mutableListOf<Item>()
        for (el in store.values) {
            itemList.add(el)
        }
        return itemList
//        return (store.values as MutableList<Item>)
    }

    fun update(itemId: Long, updateParam: Item) {
        val findItem = findById(itemId)
        findItem.itemName = updateParam.itemName
        findItem.price = updateParam.price
        findItem.quantity = updateParam.quantity
    }

    fun clearStore() {
        store.clear()
    }
 }