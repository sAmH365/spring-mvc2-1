package hello.itemservice.web.basic

import hello.itemservice.domain.Item
import hello.itemservice.domain.ItemRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/basic/items")
class BasicItemController(
    val itemRepository: ItemRepository
) {

    @GetMapping
    fun items(model: Model): String {
        val items = itemRepository.findAll()
        model.addAttribute("items", items)
        return "basic/items"
    }

    @PostConstruct
    fun init() {
        itemRepository.save(Item("itemA", 10000, 10))
        itemRepository.save(Item("itemB", 20000, 30))
        itemRepository.save(Item("itemC", 330000, 3))
    }
}