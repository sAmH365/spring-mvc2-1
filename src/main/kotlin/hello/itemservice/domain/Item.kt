package hello.itemservice.domain

class Item {
    var id: Long = 0L
    var itemName: String = ""
    var price: Int = 0
    var quantity: Int = 0

    var open: Boolean = false // 판매여부
    var regions: MutableList<String> = arrayListOf() // 등록 지역
    var itemType: ItemType = ItemType.ETC // 상품 종류
    var deliveryCode: String = "" // 배송방식

    constructor()

    constructor(itemName: String, price: Int, quantity: Int) : this() {
        this.itemName = itemName
        this.price = price
        this.quantity = quantity
    }
}