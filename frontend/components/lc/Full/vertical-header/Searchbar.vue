<script setup>
import { SearchIcon } from 'vue-tabler-icons'
import { searchSugg } from '@/_mockApis/headerData'
</script>

<template>
  <!-- ---------------------------------------------- -->
  <!-- search1 -->
  <!-- ------------------------------------------------>
  <v-menu :close-on-content-click="false">
    <template #activator="{ props }">
      <v-btn class="custom-hover-primary ml-2" color="primary" icon size="small" variant="text" v-bind="props">
        <search-icon size="22" />
      </v-btn>
    </template>
    <v-sheet elevation="10" rounded="md" width="360">
      <div class="d-flex align-center justify-space-between pa-5">
        <v-text-field color="primary" density="compact" hide-details placeholder="Search" variant="outlined" />
      </div>
      <v-divider />
      <h5 class="text-h5 mt-4 px-5 pb-4">Quick Page Links</h5>
      <perfect-scrollbar style="height: 380px">
        <v-list class="pt-0 pb-5" lines="two">
          <v-list-item
            v-for="(item, index) in searchSugg"
            :key="index"
            active-color="primary"
            class="px-5 py-2"
            :to="item.href"
            :value="item"
          >
            <h6 class="text-subtitle-1 font-weight-bold mb-1">{{ item.title }}</h6>
            <p class="text-subtitle-2 text-medium-emphasis">{{ item.href }}</p>
          </v-list-item>
        </v-list>
      </perfect-scrollbar>
    </v-sheet>
  </v-menu>
</template>
