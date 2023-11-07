<script setup lang="ts">
import { notifications } from '@/_mockApis/headerData'
</script>
<template>
  <!-- ---------------------------------------------- -->
  <!-- notifications DD -->
  <!-- ---------------------------------------------- -->
  <v-menu :close-on-content-click="false">
    <template #activator="{ props }">
      <v-btn class="custom-hover-primary" color="primary" icon variant="text" v-bind="props">
        <v-badge color="error" dot>
          <BellRingingIcon size="22" stroke-width="1.5" />
        </v-badge>
      </v-btn>
    </template>
    <v-sheet elevation="10" rounded="md" width="360">
      <div class="px-8 pb-4 pt-6">
        <div class="d-flex align-center justify-space-between">
          <h6 class="text-h5">Notifications</h6>
          <v-chip class="text-white" color="primary" size="small" variant="flat">5 New</v-chip>
        </div>
      </div>
      <perfect-scrollbar style="height: 400px">
        <v-list class="py-0 theme-list" lines="two">
          <v-list-item
            v-for="item in notifications"
            :key="item.title"
            active-color="primary"
            class="py-4 px-8"
            :value="item"
          >
            <template #prepend>
              <v-avatar class="mr-3" size="48">
                <v-img :alt="item.avatar" :src="item.avatar" width="48" />
              </v-avatar>
            </template>
            <div>
              <h6 class="text-subtitle-1 font-weight-bold mb-1">{{ item.title }}</h6>
            </div>
            <p class="text-subtitle-1 font-weight-regular textSecondary">{{ item.subtitle }}</p>
          </v-list-item>
          <v-divider />
        </v-list>
      </perfect-scrollbar>
      <div class="py-4 px-6 text-center">
        <v-btn block color="primary" variant="outlined">See all Notifications</v-btn>
      </div>
    </v-sheet>
  </v-menu>
</template>
