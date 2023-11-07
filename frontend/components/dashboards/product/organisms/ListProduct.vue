<script setup>
import ProductItem from '@/components/dashboards/product/molecules/ProductItem.vue'

const { $api } = useNuxtApp()

onMounted(() => {
  fetchData()
})

const products = ref([])

const fetchData = () => {
  $api.products
      .getProducts(null)
      .then((res) => {
        products.value = res.data
      })
}
</script>
<template>
  <div class="tw-flex flex-wrap flex-column">
    <div v-for="(product, index) in products" :key="index" class="tw-w-full md:tw-w-3/4 tw-mx-auto">
      <product-item :product="product" class="tw-w-full" />
    </div>
  </div>
</template>
