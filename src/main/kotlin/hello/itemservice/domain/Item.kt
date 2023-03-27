package hello.itemservice.domain

class Item {
    var id = 0L
    var itemName = ""
    var price = 0
    var quantity = 0

    constructor(itemName: String, price: Int, quantity: Int) {
        this.itemName = itemName
        this.price = price
        this.quantity = quantity
    }
}