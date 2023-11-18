<script setup lang="ts">
import {useCartStore} from "@/stores/carts";
import ProductItem from "@/components/dashboards/product/molecules/ProductItem.vue";

const { $api } = useNuxtApp()
const cartStore = useCartStore()

const cartItems = computed(() => cartStore.getCart)
const cartTotal = computed(() => cartStore.getCartTotal)

const payment = () => {
  const order = {
    custormer_id: 1,
    employee_id: 1,
    order_date: new Date(),
  }
  //fix cors error
  $api.orders.createOrder(order).then(res => {
    console.log(res)
  }).catch(err => {
    console.log(err)
  })
}
</script>

<template>
  <div v-if="cartItems.length === 0" class="tw-flex tw-items-center tw-justify-center tw-h-screen">
    <div class="tw-flex tw-flex-col tw-items-center">
      <div class="tw-text-[22px] tw-font-bold tw-mb-3">Your cart is empty</div>
      <div class="tw-text-[13px] tw-text-center">
        <div>Looks like you haven't made your choice yet</div>
        <div>or the product is out of stock.</div>
      </div>
      <div class="tw-mt-3">
        <v-btn color="primary" :to="{ name: 'index' }">
          <span class="tw-text-[13px]">Continue shopping</span>
        </v-btn>
      </div>
    </div>
  </div>
  <div v-else>
    <h1>Cart</h1>
    <div class="tw-flex flex-wrap flex-column">
      <div v-for="(item, index) in cartItems" :key="index" class="tw-w-full md:tw-w-3/4 tw-mx-auto">
        <product-item :product="item" class="tw-w-full" />
      </div>
    </div>
<!--    total price: {{ cartStore.totalPrice }}-->
    <div class="tw-flex tw-justify-end tw-mt-3">
      <div class="tw-text-[13px]">Total price: {{ cartTotal }}</div>
    </div>
<!--    btn payment-->
    <div class="tw-flex tw-justify-end tw-mt-3">
      <v-btn color="primary">
        <span class="tw-text-[13px]" @click="payment">Payment</span>
      </v-btn>
    </div>
  </div>
</template>

<style scoped lang="scss">

</style>