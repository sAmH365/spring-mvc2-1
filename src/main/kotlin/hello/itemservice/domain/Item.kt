package hello.itemservice.domain

class Item (
    var id: Long = 0L,
    var itemName: String = "",
    var price: Int = 0,
    var quantity: Int = 0

) {
    constructor(itemName: String, price: Int, quantity: Int): this() {
        this.itemName = itemName
        this.price = price
        this.quantity = quantity
    }
}