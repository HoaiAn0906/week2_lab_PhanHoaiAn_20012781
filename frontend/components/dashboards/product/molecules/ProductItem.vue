<script setup>
import {useCartStore} from "@/stores/carts";

const props = defineProps({
  product: {
    type: Object,
    required: true,
  },
  type: {
    type: String,
    default: 'index'
  }
})

const cartStore = useCartStore()

const addToCart = () => {
  cartStore.ADD_TO_CART(props.product)
}
</script>
<template>
  <div class="tw-block md:tw-flex tw-b-4 tw-py-3 product-item tw-gap-3">
    <div class="t-w-full md:tw-w-[300px] md:tw-min-w-[280px] tw-h-[200px] tw-overflow-hidden">
      <div class="tw-relative overflow-hidden">
        <div
          class="tw-absolute tw-bg-[#1bc744] tw-text-center tw-w-[200px] tw-h-[33px] tw-text-white tw-font-bold tw-top-3 special tw-rotate-45 tw-z-[3]"
        >
          Special
        </div>
        <v-img class="tw-object-cover tw-w-full" height="185" :src="product.product_images[0]?.path" />
      </div>
    </div>
    <div class="tw-mt-1 md:tw-mt-0 tw-min-w-[500px]">
      <div class="tw-flex tw-mb-[15px] tw-text-white tw-justify-between">
        <div class="tw-leading-[22px]">
          <a class="tw-no-underline tw-font-bold hover:tw-text-primary" href="#">
            <div class="tw-text-[22px] tw-text-black">{{ product.name }}</div>
          </a>
        </div>
        <div class="tw-flex">
          <div class="tw-w-[20px] price tw-h-[48px]" />
          <div class="tw-w-[138px] tw-bg-primary tw-text-end tw-pr-1 tw-h-[48px]">
            <div class="tw-text-[13px] tw-pt-[2px]">
              <span class="tw-text-[10px] mr-1">By for</span>
              <span>{{ product.product_prices[0].price }}</span>
            </div>
            <div>
              <span class="tw-text-[10px] mr-1">MSRP</span>
              <span class="tw-text-[22px] tw-font-bold tw-leading-[22px]">{{ product.product_prices[0].price }}</span>
            </div>
          </div>
        </div>
      </div>
      <div>
        <div class="tw-flex tw-flex-wrap tw-gap-3 tw-items-center">
          <div class="tw-flex tw-gap-2">
            <div class="tw-text-[13px]">
              <div>Manufacturer Name: {{ product.manufacturer }}</div>
            </div>
          </div>
        </div>
      </div>
      <v-btn v-if="type === 'index'" class="tw-mt-8 tw-float-right" color="primary">
        <span class="tw-text-[13px]">Buy</span>
      </v-btn>
      <v-btn v-if="type === 'index'" class="tw-mt-8 tw-float-right tw-mr-2" color="primary" variant="outlined" @click="addToCart">
        <span class="tw-text-[13px]">Add to cardt</span>
      </v-btn>
      <v-btn class="tw-mt-8 tw-float-right tw-mr-2" variant="outlined" color="primary" :to="{ name: 'chart-product-id', params: { id: product.product_id } }">
        <span class="tw-text-[13px]">Chart Price</span>
      </v-btn>
    </div>
  </div>
  <v-divider class="my-1" />
</template>
<style lang="scss">
.special {
  right: -60px;
}
.product-item {
  img .v-img__img--contain {
    object-fit: cover !important;
  }
}

.price {
  border-right: solid 30px #1bc744;
  border-top: solid 48px transparent;
}
</style>
