package hello.itemservice.domain

/**
 * FAST: 빠른배송
 * NORMAL: 일반배송
 * SLOW: 느린배송
 */
class DeliveryCode {

    private var code: String
        get() = this.code
        set(value) {
            this.code = value
        }

    private var displayName: String
        get() = this.displayName
        set(value) {
            this.displayName = value
        }
}