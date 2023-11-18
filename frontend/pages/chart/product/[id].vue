<script setup lang="ts">
import UiParentCard from "@/components/shared/UiParentCard.vue";

const dayjs = useDayjs()
import { computed, ref } from 'vue'
const page = ref({ title: 'Gredient Chart' })
const { $api } = useNuxtApp()
const route = useRoute()
const month = ref([])
const price = ref([])

const fetchData = () => {
  $api.products.getChartPriceByTime(route.params.id).then(res => {
    month.value = res.data.month.map(item => dayjs(item).format('MM/DD/YYYY'))
    price.value = res.data.price

    //refresh apex chart
    gredientChart.series = [
      {
        name: 'Price',
        data: price.value,
      },
    ]

    console.log(month.value)
  }).catch(err => {
    console.log(err)
  })
}

onMounted(() => {
  fetchData()
})

const chartOptions = computed(() => {
  return {
    chart: {
      type: 'line',
      height: 350,
      fontFamily: 'inherit',
      foreColor: '#a1aab2',
      toolbar: {
        show: false,
      },
      dropShadow: {
        enabled: true,
        color: 'rgba(0,0,0,0.2)',
        top: 12,
        left: 4,
        blur: 3,
        opacity: 0.4,
      },
    },
    stroke: {
      width: 7,
      curve: 'smooth',
    },

    xaxis: {
      type: 'datetime',
      categories: month.value,
    },
    fill: {
      type: 'gradient',
      gradient: {
        shade: 'dark',
        gradientToColors: ['#0b70fb'],
        shadeIntensity: 1,
        type: 'horizontal',
        opacityFrom: 1,
        opacityTo: 0.9,
        stops: [0, 100, 100, 100],
      },
    },
    markers: {
      size: 4,
      opacity: 0.9,
      colors: ['#4e79ff'],
      strokeColor: '#fff',
      strokeWidth: 2,

      hover: {
        size: 7,
      },
    },
    grid: {
      show: false,
    },
    tooltip: {
      theme: 'light',
    },
  }
})

const gredientChart = {
  series: [
    {
      name: 'Price',
      data: price.value,
    },
  ],
}
</script>

<template>
  <v-row>
    <v-col cols="12">
      <ui-parent-card title="Product">
        <apexchart height="350" :options="chartOptions" :series="gredientChart.series" type="line" />
      </ui-parent-card>
    </v-col>
  </v-row>
</template>

<style scoped lang="scss">

</style>