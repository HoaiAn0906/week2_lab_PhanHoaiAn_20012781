<script setup lang="ts">
import { ref } from 'vue'
import TabContent from '@/components/dashboards/minimal/TabContent'
import ListProduct from '@/components/dashboards/product/organisms/ListProduct'

const page = ref({ title: 'Minimal' })
const breadcrumbs = ref([
  {
    text: 'Dashboard',
    disabled: false,
    href: '#',
  },
  {
    text: 'Minimal',
    disabled: true,
    href: '#',
  },
])

const { data } = useAuth()

onMounted(() => {
  console.log(data)
})
</script>

<template>
  <img
    alt="background home"
    class="tw-absolute tw-top-[0px] tw-left-[0px] tw-w-full"
    src="https://motors.stylemixthemes.com/elementor-classified-one/wp-content/uploads/sites/23/2022/07/listing_bnr.jpg"
  />
  <v-row class="mt-3">
    <v-col class="tw-mt-[300px]" cols="12" lg="12">
      <tab-content />
    </v-col>
    <v-col cols="12" lg="12">
      <v-divider class="border-opacity-100" color="error" :thickness="4" />
    </v-col>
  </v-row>
  <v-row>
    <v-col cols="12">
      <list-product />
    </v-col>
  </v-row>
</template>
