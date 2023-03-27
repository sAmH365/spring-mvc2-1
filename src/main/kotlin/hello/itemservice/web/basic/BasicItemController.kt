package hello.itemservice.web.basic

import hello.itemservice.domain.Item
import hello.itemservice.domain.ItemRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
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

    @GetMapping("/{itemId}")
    fun item(model: Model, @PathVariable itemId: Long): String {
        val item = itemRepository.findById(itemId)
        model.addAttribute("item", item)

        return "basic/item"
    }

    @GetMapping("/add")
    fun addForm(): String {
        return "basic/addForm"
    }

//    @PostMapping("/add")
    fun addItemV1(@ModelAttribute("item") item: Item): String {
        itemRepository.save(item)
//        model.addAttribute("item", item)  // @ModelAttribute 사용하면 자동추가, 생략 가능

        return "basic/item"
    }

//    @PostMapping("/add")
    fun addItemV2(@ModelAttribute item: Item): String {
        itemRepository.save(item) // @ModelAttribute에 name 속성 지정하지 않으면 클래스명의 첫글자를 소문자를 바꾼값(item)을 model에 넣어준다.
        return "basic/item"
    }

//    @PostMapping("/add")
    fun addItemV3(item: Item): String {
        itemRepository.save(item)
        return "basic/item"
    }

    @PostMapping("/add")
    fun addItemV4(item: Item): String {
        itemRepository.save(item)
        return "redirect:/basic/items/${item.id}"
    }

    @GetMapping("/{itemId}/edit")
    fun editForm(@PathVariable itemId: Long, model:Model): String {
        val item = itemRepository.findById(itemId)
        model.addAttribute("item", item)
        return "basic/editForm"
    }

    @PostMapping("/{itemId}/edit")
    fun edit(@PathVariable itemId: Long, item:Item): String {
        itemRepository.update(itemId, item)
        return "redirect:/basic/items/{itemId}"
    }

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    fun init() {
        itemRepository.save(Item("itemA", 10000, 10))
        itemRepository.save(Item("itemB", 20000, 30))
        itemRepository.save(Item("itemC", 330000, 3))
    }
}