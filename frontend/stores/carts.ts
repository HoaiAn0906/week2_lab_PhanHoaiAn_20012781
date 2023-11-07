import { defineStore } from 'pinia'

export const useCartStore = defineStore({
    id: 'cart',
    state: () => ({
        cart: [],
        amount: 0,
        cartTotal: 0
    }),
    getters: {
        getCart: (state) => {
            return state.cart
        },
        getAmount: (state) => {
            return state.amount
        },
        getCartTotal: (state) => {
            return state.cartTotal
        }
    },
    actions: {
        ADD_TO_CART(payload: any) {
            //check product is already in cart
            if (this.cart.length > 0) {
               const product = this.cart.find((item: any) => item.product_id === payload.product_id)
                if (product) {
                    console.log('product already in cart')
                } else {
                    this.cart.push(payload)
                    this.amount++
                    this.cartTotal += payload.product_prices[0].price
                }
            } else {
                this.cart.push(payload)
                this.amount++
                this.cartTotal += payload.product_prices[0].price
            }
        }
    }
})