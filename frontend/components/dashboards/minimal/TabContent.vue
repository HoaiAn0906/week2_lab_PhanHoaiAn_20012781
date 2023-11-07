<script setup lang="ts">
const tab = ref('one')
</script>

<template>
  <v-card>
    <v-tabs v-model="tab" bg-color="secondary">
      <v-tab class="tw-font-bold" value="one">{{ $t('home.tabContent.allCondition') }}</v-tab>
    </v-tabs>

    <v-card-text class="tw-bg-secondary">
      <v-window v-model="tab">
        <v-window-item bg-color="secondary" value="one">
          <div class="tw-flex tw-flex-wrap">
            <v-text-field
                class="tw-m-2 tw-mr-1 tw-w-full md:tw-w-auto"
                hide-details
                label="Tên"
                type="text"
                variant="solo-filled"
            />
            <v-select
              class="tw-m-2 tw-mr-1 tw-w-full md:tw-w-auto"
              hide-details
              :items="['foo', 'bar']"
              :label="$t('home.model.maxPrice')"
              variant="solo-filled"
            />
            <v-btn class="tw-m-2 tw-uppercase" color="primary" height="50" variant="flat" width="200">
              <v-icon color="white" size="24">mdi-magnify</v-icon>
              <span class="tw-text-white tw-font-bold tw-ml-1">{{ $t('home.model.car') }}</span>
            </v-btn>
          </div>
        </v-window-item>
      </v-window>
    </v-card-text>
  </v-card>
</template>

<style scoped lang="scss"></style>
